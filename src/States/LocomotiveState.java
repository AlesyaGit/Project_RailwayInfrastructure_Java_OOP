package States;

import Exceptions.RailroadHazard;
import Models.Locomotive;
import Models.World;

public abstract class LocomotiveState {
    protected int tick = 0;


    protected Locomotive locomotive;
    public World world;
    public LocomotiveState(World world){
        this.world = world;
    }

    public void handle() throws RailroadHazard {
        tick++;
    }

    public Locomotive getLocomotive() {
        return locomotive;
    }

    public void setLocomotive(Locomotive locomotive) {
        this.locomotive = locomotive;
    }
    public void init(){

    }
}
