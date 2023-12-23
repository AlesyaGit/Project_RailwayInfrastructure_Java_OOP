package States;

import Exceptions.RailroadHazard;
import Fabric.LocomotiveOnJourneyStateFabric;
import Models.Station;
import Models.StationWithDistance;
import Models.World;

import java.util.List;

public class WaitQueueLocomotiveState<T extends LocomotiveOnJourneyState> extends LocomotiveState{
    private final Station source;
    private final List<StationWithDistance> route;
    private final Station destination;
    private final LocomotiveOnJourneyStateFabric<T> fabric;
    public WaitQueueLocomotiveState(World world, Station source, Station destination, List<StationWithDistance> route, LocomotiveOnJourneyStateFabric<T> fabric) {
        super(world);
        this.source = source;
        this.destination = destination;
        this.route = route;
        this.fabric = fabric;
    }

    @Override
    public void handle() throws RailroadHazard {
        super.handle();
        StationWithDistance station = route.stream().filter(x->x.station.getArrivingLocomotive()!=null).findFirst().orElse(null);
        if(station!=null) {
            return;
        };
        locomotive.setState(fabric.create(world, source, destination, route));
    }

    @Override
    public String toString() {
        return "Wait in the queue";
    }
}
