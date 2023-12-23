package Menu;

import Exceptions.*;
import Interfaces.IScanner;
import Models.Locomotive;
import Models.RailroadCar;
import Models.World;
import States.NotStartedLocomotiveState;

import java.util.List;
import java.util.stream.Collectors;

public class AttachingRailroadCarToLocomotiveHandler extends MenuHandler{
    protected AttachingRailroadCarToLocomotiveHandler(int number, String title) {
        super(number, title);
    }
    @Override
    public void handle(IScanner scanner, World world) throws RailroadCarNotFound, RailroadCarsEmpty, LocomotiveNotFound, ExceedMaximumSizeOfRailroads, ExceedMaximumSizeOfRailroadsWithRequiredElectricalGrid, ExceedMaxWeightLoadedTransport {

        List<RailroadCar> unAttachedRailroadCars = world.getRailroadCars().stream().filter(x->!x.isAttached()).toList();
        if(unAttachedRailroadCars.size() == 0) throw new RailroadCarsEmpty("There aren't Railroad cars");
        scanner.printlnString(unAttachedRailroadCars.stream().map(Object::toString).collect(Collectors.joining("\n")));
        scanner.printString("Enter Id: ");
        int idRailroadCar = scanner.readInt();

        RailroadCar railroadCar = unAttachedRailroadCars.stream().filter(x->x.getId()==idRailroadCar).findFirst().orElse(null);
        if(railroadCar==null) throw new RailroadCarNotFound("Rail road car not found");


        List<Locomotive> locomotives = world.getLocomotives().stream().filter(x->x.getState() instanceof NotStartedLocomotiveState).toList();
        scanner.printlnString("Attaching railroad car to locomotive...");
        scanner.printlnString(locomotives.stream().map(Locomotive::toString).collect(Collectors.joining("\n")));
        scanner.printString("Enter Id: ");
        int idLoc = scanner.readInt();
        Locomotive locomotive = world.getLocomotives().stream().filter(x->x.getState() instanceof NotStartedLocomotiveState && x.getId()==idLoc).findFirst().orElse(null);
        if(locomotive==null) throw new LocomotiveNotFound("Locomotive not found");
        locomotive.attachRailroadCar(railroadCar);
        scanner.printlnString("Successfully attached!");
    }
}
