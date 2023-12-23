package Models;

public class RefrigeratedRailroadCar extends BasicFreightRailroadCar{
    private boolean hasCoolingSystem;

    public boolean isHasCoolingSystem() {
        return hasCoolingSystem;
    }

    public void setHasCoolingSystem(boolean hasCoolingSystem) {
        this.hasCoolingSystem = hasCoolingSystem;
    }

    public RefrigeratedRailroadCar(double weight,double netWeight, double grossWeight, boolean hasCoolingSystem) {
        super(weight,netWeight, grossWeight, true);
        this.hasCoolingSystem = hasCoolingSystem;
    }

    @Override
    public String toString() {
        return super.toString() + "; Has cooling system = "+ hasCoolingSystem;
    }
}
