package States;

import Exceptions.RailroadHazard;
import Models.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public abstract class LocomotiveOnJourneyState extends LocomotiveState{
    private final Queue<StationWithDistance> queue;
    private final Station source;

    private StationWithDistance preDestination;
    private double coveredPreDistance;
    private double totalPreDistance;
    protected boolean isEnd;

    private final List<StationWithDistance> route;
    private final double totalDistance;

    public double getCoveredDistance() {
        return coveredDistance;
    }

    private double coveredDistance;
    public final int MAX_NORMAL_SPEED = 200;
    private final Station destination;
    public LocomotiveOnJourneyState(World world,Station source, Station destination, List<StationWithDistance> route){
        super(world);
        this.queue = new LinkedList<>();
        this.route = route;
        queue.addAll(route.stream().filter(x->x.station!=source).toList());
        this.source = source;
        this.destination = destination;
        this.preDestination = null;
        this.totalDistance = route.stream().mapToInt(x->x.distance).sum();
        this.totalPreDistance = 0;
        this.coveredDistance = 0;
        this.coveredPreDistance = 0;
        this.isEnd = false;
    }
    @Override
    public void handle() throws RailroadHazard {
        super.handle();
        double speed = locomotive.getSpeed();
        preDestination = preDestination == null? queue.poll() : preDestination;
        if(preDestination==null){
            isEnd = true;
            return;
        }
        totalPreDistance = preDestination.distance;

        if(totalPreDistance<=coveredPreDistance){
            locomotive.setState(new WaitOnStationLocomotiveState(world,this));
            preDestination = null;
            coveredPreDistance =0;
            totalPreDistance = 0;
            return;
        }
        double distance =  speed+coveredPreDistance;
        double addDistance = distance > totalPreDistance ? totalPreDistance - coveredPreDistance : speed;
        coveredPreDistance= Math.min(coveredPreDistance+addDistance, totalPreDistance);
        coveredDistance= Math.min(coveredDistance+addDistance, totalDistance);;
        if(speed>MAX_NORMAL_SPEED){
            throw new RailroadHazard(new RailroadHazardInformation(locomotive,
                    getPercentTotalDistance() ,
                    locomotive.numberOfPeople(),
                    getPercentCoveredPreDistance()));
        }
    }

    private double getPercentCoveredPreDistance() {
        return (coveredPreDistance/ totalPreDistance)*100;
    }

    private double getPercentTotalDistance() {
        return (coveredDistance / totalDistance) * 100;
    }

    @Override
    public void init(){
        route.forEach(x->x.station.setArrivingLocomotive(locomotive));

    }
    public Station getSource() {
        return source;
    }

    public Station getDestination() {
        return destination;
    }
    public StationWithDistance getPreDestination() {
        return preDestination;
    }

    public List<StationWithDistance> getRoute() {
        return route;
    }
    @Override
    public String toString() {
        return "Covered total distance "+(int)getPercentTotalDistance()+"%; " + "covered pre distance "+(int)getPercentCoveredPreDistance()+"%; " + "number of people "+ locomotive.numberOfPeople();
    }
}
