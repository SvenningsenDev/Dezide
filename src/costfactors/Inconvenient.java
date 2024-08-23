package costfactors;

public class Inconvenient implements CostFactor {
    private final String name;
    private final double multiplier;

    public Inconvenient() {
        this.name = "Inconvenient";
        this.multiplier = 0.1;
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
