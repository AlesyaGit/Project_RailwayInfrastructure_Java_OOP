package Menu;

import Interfaces.IScanner;
import Models.Station;
import Models.World;

public class CreateStationHandler extends MenuHandler{
    protected CreateStationHandler(int number, String title) {
        super(number, title);
    }

    @Override
    public void handle(IScanner scanner, World world) {
        scanner.printlnString("Creating station...");
        scanner.printString("Enter name: ");
        String name = scanner.readString();
        Station station = new Station(name);
        world.addStation(station);
        scanner.printlnString("Station successfully created!");
    }
}
