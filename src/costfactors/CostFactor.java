package costfactors;

public interface CostFactor {
    String getName();
    double getMultiplierInPercent();
    double applyCostFactor(double cost);
}
