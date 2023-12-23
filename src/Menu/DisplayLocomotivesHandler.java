package Menu;

import Exceptions.*;
import Interfaces.IScanner;
import Models.Locomotive;
import Models.World;

import java.util.stream.Collectors;

public class DisplayLocomotivesHandler extends MenuHandler{
    public DisplayLocomotivesHandler(int number, String title) {
        super(number, title);
    }

    @Override
    public void handle(IScanner scanner, World world) {
        scanner.printlnString(world.getLocomotives().stream().map(Locomotive::toString).collect(Collectors.joining("\n")));
    }
}
