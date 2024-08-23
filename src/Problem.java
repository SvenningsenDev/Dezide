import costfactors.CostFactor;

import java.util.ArrayList;
import java.util.List;

public class Problem {
    private double estimatedTimeHours;
    private List<CostFactor> costFactors;

    // Constructor for creating a simple problem with only hours
    public Problem(double estimatedTimeHours) {
        this.estimatedTimeHours = estimatedTimeHours;
    }

    // Constructor for creating a special problem with hours and a list of cost factors
    public Problem(double estimatedTimeHours, List<CostFactor> costFactors) {
        this.estimatedTimeHours = estimatedTimeHours;
        this.costFactors = costFactors;
    }

    public double getEstimatedTimeHours() {
        return estimatedTimeHours;
    }

    public List<CostFactor> getCostFactors() {
        return costFactors;
    }
}
