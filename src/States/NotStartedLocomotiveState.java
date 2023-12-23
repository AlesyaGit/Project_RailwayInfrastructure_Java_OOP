package States;

import Exceptions.RailroadHazard;
import Models.World;

public class NotStartedLocomotiveState extends LocomotiveState{
    public NotStartedLocomotiveState(World world) {
        super(world);
    }

    @Override
    public void handle() throws RailroadHazard {
        super.handle();
    }

    @Override
    public String toString() {
        return "Not started";
    }
}
