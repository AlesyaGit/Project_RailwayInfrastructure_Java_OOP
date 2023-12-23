package States;

import Exceptions.RailroadHazard;
import Models.Notification;
import Models.World;

public class WaitOnStationLocomotiveState extends LocomotiveState{
    public static final int WAIT = 2;
    private final LocomotiveOnJourneyState locomotiveOnJourneyState;
    public WaitOnStationLocomotiveState(World world,LocomotiveOnJourneyState locomotiveOnJourneyState){
        super(world);
        this.locomotiveOnJourneyState = locomotiveOnJourneyState;
    }
    @Override
    public void handle() throws RailroadHazard {
        super.handle();
        if(tick>=WAIT){
            locomotive.setState(locomotiveOnJourneyState);
        }
    }

    @Override
    public void init() {
        super.init();
        world.addNotification(new Notification("Locomotive with Id = " + locomotive.getId() +" arrived to " +locomotiveOnJourneyState.getPreDestination().station.getName()));
    }

    @Override
    public String toString() {
        return "Wait on the Station";
    }
}
