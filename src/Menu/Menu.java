package Menu;

import Implements.Scanner;
import Models.World;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Menu {
    private final World world;
    private final ArrayList<MenuHandler> menuHandlers;

    public Menu(World world) {
        this.world = world;
        this.menuHandlers = new ArrayList<>();
        menuHandlers.add(new CreateLocomotiveHandler(1, "Create Locomotive"));
        menuHandlers.add(new CreateRailroadCarHandler(2, "Create Railroad car"));
        menuHandlers.add(new AttachingRailroadCarToLocomotiveHandler(3, "Attache Railroad car to Locomotive"));
        menuHandlers.add(new CreateStationHandler(4, "Create Station"));
        menuHandlers.add(new DisplayStationsHandler(6, "Display Stations"));
        menuHandlers.add(new CreateConnectionBetweenStations(7, "Create a Connection between Stations"));
        menuHandlers.add(new DisplayRailroadsMenuHandler(8, "Display Railroads"));
        menuHandlers.add(new DisplayLocomotivesHandler(9, "Display Locomotives"));
        menuHandlers.add(new StartLocomotiveHandler(10, "Start Locomotive"));
        menuHandlers.add(new DisplayNotificationsHandler(11, "Display Notifications"));


    }

    public void show(){
        while (true){
            Scanner in = new Scanner(new java.util.Scanner(System.in));
            String menu = menuHandlers.stream().map(x->x.toString()).collect(Collectors.joining ("\n"));;

            in.printlnString(menu);
            in.printString("Enter number: ");
            int a = in.readInt();

            MenuHandler menuHandler= menuHandlers.stream().filter(x->x.check(a)).findFirst().orElse(null);
            if(menuHandler==null) {
                in.printlnString("Invalid input");
                continue;
            }
            try {
                menuHandler.handle(in,world);
            }catch (Exception e){
                in.printlnString("Error: "+e.getMessage());
            }
        }
    }
}
