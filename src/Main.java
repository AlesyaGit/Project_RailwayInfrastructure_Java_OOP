import Implements.FileStorage;
import Menu.Menu;
import Models.*;
import Threads.RouteThread;
import Threads.SaveThread;

public class Main {
    public static void main(String[] args) {
        World world = new World();
        world.getWorldNetwork().generateStations(100);
        world.getWorldNetwork().generateConnections(5,650,1000);
        world.generateLocomotivesRandomly();
        RouteThread routeThread = new RouteThread(world);
        routeThread.start();
        SaveThread saveThread = new SaveThread(new FileStorage(), world);
        saveThread.start();
        Menu menu = new Menu(world);
        menu.show();
    }
}