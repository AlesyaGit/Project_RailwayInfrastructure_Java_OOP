package Models;

public class PostOfficeRailroadCar extends RailroadCar {
    private boolean hasMailSorter;
    private int numberOfPouches;

    public PostOfficeRailroadCar(double weight,boolean hasMailSorter, int numberOfPouches) {
        super(weight, true);
        this.hasMailSorter = hasMailSorter;
        this.numberOfPouches = numberOfPouches;
    }


    public int getNumberOfPouches() {
        return numberOfPouches;
    }

    public void setNumberOfPouches(int numberOfPouches) {
        this.numberOfPouches = numberOfPouches;
    }

    public boolean isHasMailSorter() {
        return hasMailSorter;
    }

    public void setHasMailSorter(boolean hasMailSorter) {
        this.hasMailSorter = hasMailSorter;
    }

    @Override
    public String toString() {
        return super.toString() + " Number of pouches = " + numberOfPouches +"; Has mail sorter = " +hasMailSorter;
    }
}