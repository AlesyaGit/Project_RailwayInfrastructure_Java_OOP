package Models;

import Exceptions.ExceedMaxWeightLoadedTransport;
import Exceptions.ExceedMaximumSizeOfRailroads;
import Exceptions.ExceedMaximumSizeOfRailroadsWithRequiredElectricalGrid;
import States.LocomotiveState;
import States.NotStartedLocomotiveState;

import javax.swing.plaf.nimbus.State;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Locomotive {
    private static int idCounter = 0;
    private final int id;
    private LocomotiveRoute route;
    private LocomotiveState state;
    private final String name;
    private double speed;
    private final int maxRailroadCars;
    private final int maxElectricRailroadCars;
    private final int maxWeightLoadedTransport;
    private final ArrayList<RailroadCar> railroadCars;
    public Locomotive(String name, int speed,int maxRailroadCars, int maxElectricRailroadCars, int maxWeightLoadedTransport) {
        this.id = ++idCounter;
        this.name = name;
        this.maxWeightLoadedTransport = maxWeightLoadedTransport;
        this.speed= speed;
        this.route = null;
        this.maxRailroadCars = maxRailroadCars;
        this.maxElectricRailroadCars = maxElectricRailroadCars;
        this.railroadCars = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSpeed() {
        return speed;
    }
    public void setSpeed(double speed) {
        this.speed = speed;
    }


    public int getMaxRailroadCars() {
        return maxRailroadCars;
    }

    public int getMaxElectricRailroadCars() {
        return maxElectricRailroadCars;
    }
    public void attachRailroadCar(RailroadCar railroadCar) throws ExceedMaximumSizeOfRailroads, ExceedMaximumSizeOfRailroadsWithRequiredElectricalGrid, ExceedMaxWeightLoadedTransport {
        if(railroadCars.size()>=maxRailroadCars)
            throw new ExceedMaximumSizeOfRailroads("Exceeded maximum number of railroads");
        if(railroadCar.isRequiresElectricalGrid() && getNumberOfRailroadCardWithRequiredElectricalGrid()>=maxElectricRailroadCars)
            throw new ExceedMaximumSizeOfRailroadsWithRequiredElectricalGrid("Exceeded maximum number of railroads with required electrical grid");
        if(getWeightTransports() + railroadCar.getWeight()> maxWeightLoadedTransport)
            throw new ExceedMaxWeightLoadedTransport("Exceeded maximum number of loaded transport");
        railroadCar.setAttached(true);
        railroadCars.add(railroadCar);
    }
    public long getNumberOfRailroadCardWithRequiredElectricalGrid(){
        return railroadCars.stream().filter(RailroadCar::isRequiresElectricalGrid).count();
    }
    public List<RailroadCar> getRailroadCars() {
        return Collections.unmodifiableList(railroadCars);
    }
    public double getWeightTransports(){
        return railroadCars.stream().mapToDouble(RailroadCar::getWeight).sum();
    }

    @Override
    public String toString() {
        return "ID = "+id+"; Name = "+ name+"; state = ( "+ state +" );";
    }

    public LocomotiveRoute getRoute() {
        return route;
    }

    public int getMaxWeightLoadedTransport() {
        return maxWeightLoadedTransport;
    }

    public void setState(LocomotiveState state){
        state.setLocomotive(this);
        this.state = state;
        state.init();
    }
    public LocomotiveState getState(){
        return state;
    }
    public int numberOfPeople(){
        return railroadCars.stream().filter(x->x instanceof PassengerRailroadCar).mapToInt(x->((PassengerRailroadCar) x).getNumberOfSeats()).sum();
    }
}
