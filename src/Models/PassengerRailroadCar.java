package Models;

public class PassengerRailroadCar extends RailroadCar {
    private int numberOfSeats;

    private boolean airConditioning;

    public PassengerRailroadCar(double weight,int numberOfSeats, boolean airConditioning) {
        super(weight, true);
        this.numberOfSeats = numberOfSeats;
        this.airConditioning = airConditioning;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public boolean isAirConditioning() {
        return airConditioning;
    }

    public void setAirConditioning(boolean airConditioning) {
        this.airConditioning = airConditioning;
    }

    @Override
    public String toString() {
        return super.toString() + " Number of seats = "+numberOfSeats+ "; Air conditioning = "+ airConditioning;
    }
}