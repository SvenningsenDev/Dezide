import costfactors.CostFactor;

import java.util.ArrayList;
import java.util.List;

public class Problem {
    private double estimatedTimeHours;
    private List<CostFactor> costFactors;
    // a cost variable could be added to build a Problem from a cost

    public Problem(double estimatedTimeHours) {
        this.estimatedTimeHours = estimatedTimeHours;
    }

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
