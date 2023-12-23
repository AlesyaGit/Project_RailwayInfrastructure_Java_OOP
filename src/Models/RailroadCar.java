package Models;

public abstract class RailroadCar {
    private static int idCounter = 0;
    private final int id;
    private boolean isAttached;
    private double weight;
    private final boolean requiresElectricalGrid;
    public RailroadCar(double weight, boolean requiresElectricalGrid) {
        this.weight = weight;
        this.id = ++idCounter;
        this.isAttached = false;
        this.requiresElectricalGrid = requiresElectricalGrid;
    }

    public int getId() {
        return id;
    }

    public boolean isRequiresElectricalGrid() {
        return requiresElectricalGrid;
    }

    public boolean isAttached() {
        return isAttached;
    }

    public void setAttached(boolean attached) {
        isAttached = attached;
    }

    @Override
    public String toString() {
        return "ID = "+id+"; Type = "+ getClass().getSimpleName() + "; " + "Weight = "+ weight+ "; " + " Is attached = "+ isAttached + "; ";
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
