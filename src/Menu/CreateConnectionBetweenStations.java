package Menu;

import Exceptions.StationNotFound;
import Interfaces.IScanner;
import Models.Station;
import Models.World;

public class CreateConnectionBetweenStations extends MenuHandler{
    protected CreateConnectionBetweenStations(int number, String title) {
        super(number, title);
    }

    @Override
    public void handle(IScanner scanner, World world) throws StationNotFound {
        scanner.printlnString("Linking station...");
        scanner.printString("Enter station's Id: ");
        int stationId = scanner.readInt();
        Station station1 = world.getStationById(stationId);
        if(station1==null) throw new StationNotFound("Station1 not found");
        scanner.printString("Enter station's Id to link to: ");
        int stationId2 = scanner.readInt();
        Station station2 = world.getStationById(stationId2);

        if(station2==null) throw new StationNotFound("Station2 not found");

        scanner.printString("Enter a distance: ");
        int distance = scanner.readInt();
        world.createConnection(station1, station2, distance);
    }
}
