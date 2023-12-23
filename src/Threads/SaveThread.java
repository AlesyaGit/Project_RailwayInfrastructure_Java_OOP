package Threads;

import Exceptions.RailroadHazard;
import Interfaces.IFileStorage;
import Models.Locomotive;
import Models.World;
import States.LocomotiveOnJourneyState;

import java.util.List;
import java.util.Random;

public class SaveThread extends Thread{
    private final World world;
    IFileStorage fileStorage;
    public SaveThread(IFileStorage fileStorage, World world){
        this.world = world;
        this.fileStorage = fileStorage;
    }
    @Override
    public void run() {
        while (true){
            fileStorage.save(world.getLocomotives(), world.getRailroadCars());
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
