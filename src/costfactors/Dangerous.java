package costfactors;

public class Dangerous implements CostFactor {
    private final String name;
    private final double multiplier;

    public Dangerous() {
        this.name = "Dangerous";
        this.multiplier = 0.25;
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
