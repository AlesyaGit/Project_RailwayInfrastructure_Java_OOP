package Menu;

import Exceptions.*;
import Interfaces.IScanner;
import Models.Notification;
import Models.World;

import java.util.stream.Collectors;

public class DisplayNotificationsHandler extends MenuHandler{
    protected DisplayNotificationsHandler(int number, String title) {
        super(number, title);
    }

    @Override
    public void handle(IScanner scanner, World world) {
        scanner.printlnString(world.getNotifications().stream().map(Notification::toString).collect(Collectors.joining("\n")));
    }
}
