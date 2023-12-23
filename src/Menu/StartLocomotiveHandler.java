package Menu;

import Exceptions.*;
import Fabric.LocomotiveOnJourneyToDestStationStateFabric;
import Interfaces.IScanner;
import Models.*;
import States.LocomotiveOnJourneyToDestStationState;
import States.WaitQueueLocomotiveState;

import java.util.List;

public class StartLocomotiveHandler extends MenuHandler{
    protected StartLocomotiveHandler(int number, String title) {
        super(number, title);
    }

    @Override
    public void handle(IScanner scanner, World world) throws LocomotiveNotFound, StationNotFound {
        scanner.printlnString("Starting a locomotive...");
        scanner.printString("Enter a locomotive's Id: ");
        int locId = scanner.readInt();
        Locomotive locomotive = world.getLocomotiveById(locId);
        if (locomotive ==null) throw new LocomotiveNotFound("Locomotive not found");
        scanner.printString("Enter a source (station Id): ");
        int sourceId = scanner.readInt();
        Station source = world.getStationById(sourceId);
        if(source==null) throw new StationNotFound("Station not found");

        scanner.printString("Enter a source (station Id): ");
        int destId = scanner.readInt();
        Station dest = world.getStationById(destId);
        if(dest==null) throw new StationNotFound("Station not found");
        List<StationWithDistance> route = world.getWorldNetwork().searchRoute(source, dest);
        WaitQueueLocomotiveState<LocomotiveOnJourneyToDestStationState> state =
                new WaitQueueLocomotiveState<>(world,source, dest, route, new LocomotiveOnJourneyToDestStationStateFabric());
        locomotive.setState(state);
        scanner.printlnString("The locomotive is started successfully!");
    }
}
