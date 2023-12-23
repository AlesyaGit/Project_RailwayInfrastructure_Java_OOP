package Fabric;

import Models.Station;
import Models.StationWithDistance;
import Models.World;
import States.LocomotiveOnJourneyToDestStationState;

import java.util.List;

public class LocomotiveOnJourneyToDestStationStateFabric implements LocomotiveOnJourneyStateFabric<LocomotiveOnJourneyToDestStationState> {
    @Override
    public LocomotiveOnJourneyToDestStationState create(World world, Station source, Station destination, List<StationWithDistance> route) {
        return new LocomotiveOnJourneyToDestStationState(world, source, destination, route);
    }
}
