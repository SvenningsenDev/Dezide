package costfactors;

public class Difficult implements CostFactor {
    private final String name;
    private final double multiplier;

    public Difficult() {
        this.name = "Difficult";
        this.multiplier = 0.05;
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
