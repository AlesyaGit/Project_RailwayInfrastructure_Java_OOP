package States;

import Exceptions.RailroadHazard;
import Models.Station;
import Models.StationWithDistance;
import Models.World;

import java.util.List;

public class LocomotiveOnJourneyToDestStationState extends LocomotiveOnJourneyState{
    public LocomotiveOnJourneyToDestStationState(World world, Station source, Station destination, List<StationWithDistance> route) {
        super(world, source, destination, route);
    }

    @Override
    public void handle() throws RailroadHazard {
        super.handle();
        if(isEnd){
            getRoute().forEach(x->x.station.setArrivingLocomotive(null));
            locomotive.setState(new WaitOnDestStationLocomotiveState(world, getDestination(), getSource()));
        }
    }

    @Override
    public String toString() {
        return "On journey to destination Station; "+super.toString();
    }
}
