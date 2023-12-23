package Models;

public class RestaurantRailroadCar extends RailroadCar {
    private int seatingCapacity;
    private boolean hasKitchen;

    public RestaurantRailroadCar(double weight,int seatingCapacity, boolean hasKitchen) {
        super(weight, true);
        this.seatingCapacity = seatingCapacity;
        this.hasKitchen = hasKitchen;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public boolean isHasKitchen() {
        return hasKitchen;
    }

    public void setHasKitchen(boolean hasKitchen) {
        this.hasKitchen = hasKitchen;
    }

    @Override
    public String toString() {
        return super.toString() + " Seating capacity = "+ seatingCapacity + "; Has kitchen = "+ hasKitchen;
    }
}
