package Fabric;

import Models.Station;
import Models.StationWithDistance;
import Models.World;
import States.LocomotiveOnJourneyState;

import java.util.List;

public interface LocomotiveOnJourneyStateFabric<T extends LocomotiveOnJourneyState> {
    T create(World world, Station source, Station destination, List<StationWithDistance> route);
}
