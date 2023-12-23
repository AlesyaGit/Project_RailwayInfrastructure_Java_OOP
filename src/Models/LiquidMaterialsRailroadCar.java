package Models;

public class LiquidMaterialsRailroadCar extends BasicFreightRailroadCar{
    private boolean hasPump;
    private int numberOfValves;

    public boolean isHasPump() {
        return hasPump;
    }

    public void setHasPump(boolean hasPump) {
        this.hasPump = hasPump;
    }

    public int getNumberOfValves() {
        return numberOfValves;
    }

    public void setNumberOfValves(int numberOfValves) {
        this.numberOfValves = numberOfValves;
    }

    public LiquidMaterialsRailroadCar(double weight,double netWeight, double grossWeight, boolean hasPump, int numberOfValves) {
        super(weight,netWeight, grossWeight, false);
        this.hasPump = hasPump;
        this.numberOfValves = numberOfValves;
    }

    @Override
    public String toString() {
        return super.toString() + " Has pump = " + hasPump + "; Number of valves = "+ numberOfValves;
    }
}
