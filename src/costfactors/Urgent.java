package costfactors;

public class Urgent implements CostFactor {
    private final String name;
    private final double multiplier;

    public Urgent() {
        this.name = "Urgent";
        this.multiplier = 0.15;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getMultiplierInPercent() {
        return multiplier * 100;
    }

    @Override
    public double applyCostFactor(double cost) {
        return cost * multiplier;
    }
}
