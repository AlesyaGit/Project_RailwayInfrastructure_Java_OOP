package Models;

import States.NotStartedLocomotiveState;

import java.util.ArrayList;

public class GenerateLocomotives {
    public ArrayList<Locomotive> generate(World world){
        ArrayList<Locomotive> locomotives = new ArrayList<>();
        RailroadRandomCarCreator creator = new RailroadRandomCarCreator();

        for (int i=0; i < 25; i++){
            Locomotive locomotive = new Locomotive("Locomotive "+i, 180, 5,5,1000);
            for (int j=0; j < locomotive.getMaxRailroadCars(); j++){
                try {
                    RailroadCar railroadCar = creator.getRandRailroadCar(locomotive.getMaxWeightLoadedTransport()/locomotive.getMaxRailroadCars());
                    world.addRailroadCar(railroadCar);
                    locomotive.attachRailroadCar(railroadCar);
                    locomotive.setState(new NotStartedLocomotiveState(world));
                }catch (Exception e){

                }
            }
            locomotives.add(locomotive);
        }
        return locomotives;
    }
}
