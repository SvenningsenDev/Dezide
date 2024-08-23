import costfactors.CostFactor;

public class ExtendedConverter extends Converter {

    public ExtendedConverter(double globalHourlyRate, Boolean useGlobal) {
        super(globalHourlyRate, useGlobal);
    }

    public double specialProblemCost(Problem problem, TroubleshootingModel tModel) {
        if (problem.getCostFactors() == null) {
            System.err.println("Error: This method only works with special problems.");
            return 0.0;
        }

        System.out.println("Calculating cost of a special problem");

        double rate = getRate(tModel);
        double hours = problem.getEstimatedTimeHours();

        System.out.println("Using " + (useGlobal ? "global hourly rate: " : "specified rate from " + tModel.getId() + ": ") + rate);
        double cost = hours * rate;
        System.out.println(hours + " hours at the rate " + rate + " costs: " + cost);

        double extraCost = 0;
        for (CostFactor costFactor : problem.getCostFactors()) {
            System.out.println("The cost factor " + costFactor.getName() + " adds " + costFactor.getMultiplierInPercent() + "% to the cost");
            extraCost += costFactor.applyCostFactor(cost);
        }
            System.out.println("With the cost factors, the extra cost is " + extraCost +  ", and the total cost is " + (cost + extraCost));
        return cost + extraCost;
    }
}
