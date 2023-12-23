package Menu;

import Exceptions.StationNotFound;
import Interfaces.IScanner;
import Models.Locomotive;
import Models.World;
import States.NotStartedLocomotiveState;

public class CreateLocomotiveHandler extends MenuHandler{
    protected CreateLocomotiveHandler(int number, String title) {
        super(number, title);
    }

    @Override
    public void handle(IScanner scanner,World world) throws StationNotFound {
        scanner.printlnString("Creating locomotive...");
        scanner.printString("Enter name: ");
        String name = scanner.readString();
        scanner.printString("Enter speed: ");
        int speed = scanner.readInt();
        scanner.printString("Enter max railroad cars: ");

        int maxRailroadCars = scanner.readInt();
        scanner.printString("Enter max electric railroad cars: ");

        int maxElectricRailroadCar = scanner.readInt();

        scanner.printString("Enter max weight loaded transport: ");
        int maxWeight = scanner.readInt();

        Locomotive locomotive = new Locomotive(name, speed,maxRailroadCars, maxElectricRailroadCar,maxWeight);
        world.addLocomotive(locomotive);
        locomotive.setState(new NotStartedLocomotiveState(world));
    }
}
