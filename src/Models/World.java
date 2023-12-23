package Models;

import States.LocomotiveOnJourneyState;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class World {
    private ArrayList<Locomotive> locomotives;
    private final ArrayList<RailroadCar> railroadCars;
    private final ArrayList<Notification> notifications;
    private final WorldNetwork worldNetwork;
    public World() {
        this.locomotives = new ArrayList<>();
        this.notifications = new ArrayList<>();
        this.railroadCars = new ArrayList<>();
        this.worldNetwork = new WorldNetwork();

    }
    public void addLocomotive(Locomotive locomotive){
        locomotives.add(locomotive);
    }
    public void addNotification(Notification notification){
        notifications.add(notification);
    }
    public void addNotification(RailroadHazardInformation railroadHazardInformation) {
        notifications.add(new Notification(railroadHazardInformation.toString()));
    }
    public List<Notification> getNotifications(){
        return Collections.unmodifiableList(notifications);
    }
    public List<Locomotive> getLocomotives(){
        return  Collections.unmodifiableList(locomotives);
    }

    public void addRailroadCar(RailroadCar railroadCar){
        railroadCars.add(railroadCar);
    }
    public List<RailroadCar> getRailroadCars() {
        return Collections.unmodifiableList(railroadCars);
    }

    public WorldNetwork getWorldNetwork() {
        return worldNetwork;
    }

    public void addStation(Station station){
        worldNetwork.addStation(station);
    }

    public void createConnection(Station station, Station station2, int distance){
        worldNetwork.addConnection(station, station2, distance);
    }

    public Station getStationById(int id){
        return worldNetwork.getStationById(id);
    }
    public Locomotive getLocomotiveById(int id){
        return locomotives.stream().filter(x->x.getId()==id).findFirst().orElse(null);
    }

    public void generateLocomotivesRandomly(){
        this.locomotives = new GenerateLocomotives().generate(this);
    }

    public List<Locomotive> getStartedLocomotives(){
        return locomotives.stream().filter(x->x.getState() instanceof LocomotiveOnJourneyState).collect(Collectors.toList());
    }

}
