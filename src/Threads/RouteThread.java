package Threads;

import Exceptions.RailroadHazard;
import Models.Locomotive;
import Models.World;
import States.LocomotiveOnJourneyState;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RouteThread extends Thread{
    private final World world;
    public RouteThread(World world){
        this.world = world;
    }
    @Override
    public void run() {
        Random rnd = new Random();
        while (true){
            List<Locomotive> started = world.getLocomotives();
            started.forEach(x-> {
                try {
                    x.getState().handle();
                } catch (RailroadHazard e) {
                    world.addNotification(e.getRailroadHazardInformation());
                }
            });
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            List<Locomotive> locomotivesOnJourney = world.getLocomotives().stream().filter(x->x.getState() instanceof LocomotiveOnJourneyState).toList();
            locomotivesOnJourney.forEach(x->{
                double percentage = (x.getSpeed() / 100) * 3;
                x.setSpeed(rnd.nextBoolean()? x.getSpeed()-percentage: x.getSpeed()+percentage);
            });
        }
    }
}
