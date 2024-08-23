public class Converter {
    private final double globalHourlyRate;
    protected Boolean useGlobal;

    public Converter(double globalHourlyRate, Boolean useGlobal) {
        this.globalHourlyRate = globalHourlyRate;
        this.useGlobal = useGlobal;
    }

    // Simpler constructor that defaults to using globalHourlyRate
    public Converter(double globalHourlyRate) {
        this.globalHourlyRate = globalHourlyRate;
        this.useGlobal = true;
    }

    // Calculates the price of fixing a simple problem based on only hours and hourly rate
    public double simpleProblemCost(Problem problem, TroubleshootingModel tModel) {
        if (problem.getCostFactors() != null) {
            throw new IllegalArgumentException("Error: This method only works with simple problems.");
        }

        System.out.println("Calculating cost of a simple problem");
        double rate = getRate(tModel);
        double hours = problem.getEstimatedTimeHours();
        System.out.println("Using " + (useGlobal ? "global hourly rate: " : "specified rate from " + tModel.getId() + ": ") + rate);
        double cost = hours * rate;
        System.out.println(hours + " hours at the rate " + rate + " costs: " + cost);
        return cost;
    }

    // Calculates the amount of hours a problem took, based on the cost
    public double costToHours(double cost, TroubleshootingModel tModel) {
        System.out.println("Calculating cost to hours");
        double rate = getRate(tModel);
        System.out.println("Using " + (useGlobal ? "global hourly rate: " : "specified rate from " + tModel.getId() + ": ") + rate);
        double hours = cost / rate;
        System.out.println("A cost of " + cost + " means that " + hours + " hours were spent at the rate " + rate);
        return hours;
    }

    public double getRate(TroubleshootingModel tModel) {
        return useGlobal ? globalHourlyRate : tModel.getHourlyRate();
    }
}
