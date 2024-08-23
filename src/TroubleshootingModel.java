import costfactors.CostFactor;
import costfactors.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TroubleshootingModel {
    private String id;
    private double hourlyRate;

    public TroubleshootingModel(String id, double hourlyRate) {
        this.id = id;
        this.hourlyRate = hourlyRate;
    }

    public String getId() {
        return id;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public Problem detectEasyProblem() {
        Random random = new Random();
        double randomEstimatedTime = getRandomHours();
        return new Problem(randomEstimatedTime);
    }

    public Problem detectSpecialProblem() {
        double randomEstimatedTime = getRandomHours();
        List<CostFactor> allCostFactors = getCostFactors();

        Random random = new Random();

        int numOfFactors = random.nextInt(allCostFactors.size()) + 1;

        List<CostFactor> selectedFactors = new ArrayList<>();

        while (selectedFactors.size() < numOfFactors) {
            int index = random.nextInt(allCostFactors.size());
            CostFactor factor = allCostFactors.get(index);
            if (!selectedFactors.contains(factor)) {
                selectedFactors.add(factor);
            }
        }
        return new Problem(randomEstimatedTime, selectedFactors);
    }

    private double getRandomHours() {
        Random random = new Random();
        return (random.nextInt(999) + 1) / 10.0;
    }

    private List<CostFactor> getCostFactors() {
        List<CostFactor> allCostFactors = new ArrayList<>();
        allCostFactors.add(new Urgent());
        allCostFactors.add(new Dangerous());
        allCostFactors.add(new Difficult());
        allCostFactors.add(new Inconvenient());

        return allCostFactors;
    }
}