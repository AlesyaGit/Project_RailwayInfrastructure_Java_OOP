package Models;

public class HeavyFreightRailroadCar extends BasicFreightRailroadCar{
    private double maximumLoadCapacity;

    public double getMaximumLoadCapacity() {
        return maximumLoadCapacity;
    }

    public void setMaximumLoadCapacity(double maximumLoadCapacity) {
        this.maximumLoadCapacity = maximumLoadCapacity;
    }

    public HeavyFreightRailroadCar(double weight,double maximumLoadCapacity, double netWeight, double grossWeight, boolean requiresElectricalGrid) {
        super(weight,netWeight, grossWeight,requiresElectricalGrid);
        this.maximumLoadCapacity = maximumLoadCapacity;
    }

    @Override
    public String toString() {
        return super.toString() + " Maximum load capacity = " +(int) maximumLoadCapacity +"; ";
    }
}
