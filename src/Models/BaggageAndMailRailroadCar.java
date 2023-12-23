package Models;

public class BaggageAndMailRailroadCar extends RailroadCar {
    private int capacity;

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isHasLockers() {
        return hasLockers;
    }

    public void setHasLockers(boolean hasLockers) {
        this.hasLockers = hasLockers;
    }

    private boolean hasLockers;

    public BaggageAndMailRailroadCar(double weight,int capacity, boolean hasLockers) {
        super(weight, false);
        this.capacity = capacity;
        this.hasLockers = hasLockers;
    }

    @Override
    public String toString() {
        return super.toString() + " Capacity = "+ capacity + "; Has lockers = " + hasLockers;
    }
}