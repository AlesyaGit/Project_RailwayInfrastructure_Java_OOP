package States;

import Exceptions.RailroadHazard;
import Models.Notification;
import Models.Station;
import Models.StationWithDistance;
import Models.World;

import java.util.List;

public class LocomotiveOnJourneyToSourceStationState extends LocomotiveOnJourneyState {
    public LocomotiveOnJourneyToSourceStationState(World world, Station source, Station destination, List<StationWithDistance> route) {
        super(world, source, destination, route);
    }

    @Override
    public void handle() throws RailroadHazard {
        super.handle();
        if(isEnd){
            getRoute().forEach(x->x.station.setArrivingLocomotive(null));
            locomotive.setState(new NotStartedLocomotiveState(world));
            world.addNotification(new Notification("Locomotive with Id = "+locomotive.getId()+" finished the journey!"));
        }
    }

    @Override
    public String toString() {
        return "On journey to source Station; "+super.toString();
    }
}
