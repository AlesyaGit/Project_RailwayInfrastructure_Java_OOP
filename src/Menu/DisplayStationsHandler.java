package Menu;

import Exceptions.*;
import Interfaces.IScanner;
import Models.Connection;
import Models.Station;
import Models.World;

public class DisplayStationsHandler extends MenuHandler{
    protected DisplayStationsHandler(int number, String title) {
        super(number, title);
    }

    @Override
    public void handle(IScanner scanner, World world){
        for (Station station : world.getWorldNetwork().getStations()) {
            System.out.println(station.getName() + " (Id="+ station.getId() +")" +":");
            for (Connection edge : station.getEdges()) {
                System.out.println("- " + edge.getStation().getName() + " (Id="+ edge.getStation().getId() +")" + " (" + edge.getDistance() + " km)");
            }
            System.out.println();
        }
    }
}
