package Models;

public class ExplosivesRailroadCar extends HeavyFreightRailroadCar{
    private boolean isBlastResistant;
    private int maximumExplosiveWeight;

    public boolean isBlastResistant() {
        return isBlastResistant;
    }

    public void setBlastResistant(boolean blastResistant) {
        isBlastResistant = blastResistant;
    }

    public int getMaximumExplosiveWeight() {
        return maximumExplosiveWeight;
    }

    public void setMaximumExplosiveWeight(int maximumExplosiveWeight) {
        this.maximumExplosiveWeight = maximumExplosiveWeight;
    }

    public ExplosivesRailroadCar(double weight,double maximumLoadCapacity, double netWeight, double grossWeight, boolean isBlastResistant, int maximumExplosiveWeight) {
        super(weight,maximumLoadCapacity, netWeight, grossWeight, false);
        this.isBlastResistant = isBlastResistant;
        this.maximumExplosiveWeight = maximumExplosiveWeight;
    }

    @Override
    public String toString() {
        return super.toString() + " Is blast resistant = "+ isBlastResistant +"; Maximum explosive weight = "+maximumExplosiveWeight;
    }
}
