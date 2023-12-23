package States;

import Exceptions.RailroadHazard;
import Fabric.LocomotiveOnJourneyToSourceStationStateFabric;
import Models.Notification;
import Models.Station;
import Models.StationWithDistance;
import Models.World;

import java.util.List;

public class WaitOnDestStationLocomotiveState extends LocomotiveState{
    public static final int WAIT = 30;
    private Station source;
    private Station destination;

    public WaitOnDestStationLocomotiveState(World world, Station source, Station destination) {
        super(world);
        this.source = source;
        this.destination = destination;
    }

    @Override
    public void handle() throws RailroadHazard {
        super.handle();
        if(tick>=WAIT){
            List<StationWithDistance> route = world.getWorldNetwork().searchRoute(source, destination);
            locomotive.setState(new WaitQueueLocomotiveState<>(world, source, destination, route, new LocomotiveOnJourneyToSourceStationStateFabric()));
        }
    }

    @Override
    public void init() {
        super.init();
        world.addNotification(new Notification("Locomotive with Id = "+locomotive.getId()+" waits 30 sec, then backs to the source station"));
    }

    @Override
    public String toString() {
        return "Wait On Destination Station";
    }
}
