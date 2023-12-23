package Menu;

import Exceptions.*;
import Interfaces.IScanner;
import Models.World;

public abstract class MenuHandler {
    private final int number;
    private final String title;


    protected MenuHandler(int number, String title) {
        this.number = number;
        this.title = title;
    }

    public boolean check(int menuNumber){
        return menuNumber == number;
    }
    public abstract void handle(IScanner scanner, World world) throws StationNotFound, RailroadCarNotFound, RailroadCarsEmpty, LocomotiveNotFound, ExceedMaximumSizeOfRailroads, ExceedMaximumSizeOfRailroadsWithRequiredElectricalGrid, ExceedMaxWeightLoadedTransport;

    public int getNumber() {
        return number;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return number+". "+title;
    }
}
