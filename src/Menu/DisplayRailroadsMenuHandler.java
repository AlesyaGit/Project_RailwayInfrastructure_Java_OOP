package Menu;

import Exceptions.*;
import Interfaces.IScanner;
import Models.Locomotive;
import Models.RailroadCar;
import Models.World;

import java.util.stream.Collectors;

public class DisplayRailroadsMenuHandler extends MenuHandler{
    protected DisplayRailroadsMenuHandler(int number, String title) {
        super(number, title);
    }

    @Override
    public void handle(IScanner scanner, World world) {
        scanner.printlnString(world.getRailroadCars().stream().map(RailroadCar::toString).collect(Collectors.joining("\n")));
    }
}
