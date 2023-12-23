package Fabric;

import Models.Station;
import Models.StationWithDistance;
import Models.World;
import States.LocomotiveOnJourneyToSourceStationState;

import java.util.List;

public class LocomotiveOnJourneyToSourceStationStateFabric implements LocomotiveOnJourneyStateFabric<LocomotiveOnJourneyToSourceStationState>{
    @Override
    public LocomotiveOnJourneyToSourceStationState create(World world, Station source, Station destination, List<StationWithDistance> route) {
        return new LocomotiveOnJourneyToSourceStationState(world, source, destination, route);
    }
}
