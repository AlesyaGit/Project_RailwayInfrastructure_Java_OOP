package Models;

public class BasicFreightRailroadCar extends RailroadCar{
    private double netWeight;

    public double getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(double netWeight) {
        this.netWeight = netWeight;
    }

    public double getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(double grossWeight) {
        this.grossWeight = grossWeight;
    }

    private double grossWeight;

    public BasicFreightRailroadCar(double weight,double netWeight, double grossWeight, boolean requiresElectricalGrid) {
        super(weight, requiresElectricalGrid);
        this.netWeight = netWeight;
        this.grossWeight = grossWeight;
    }

    @Override
    public String toString() {
        return super.toString() + " Net weight = " + (int)netWeight +"; Gross weight = "+ (int)grossWeight+ "; Requires electrical grid = " + isRequiresElectricalGrid()+ "; ";
    }
}
