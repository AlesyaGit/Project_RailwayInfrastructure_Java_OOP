package Models;

import java.util.List;

public class LocomotiveRoute {
    private Station source;
    private Station destination;
    private List<StationWithDistance> stations;

    public LocomotiveRoute(Station source, Station destination, List<StationWithDistance> stations) {
        this.source = source;
        this.destination = destination;
        this.stations = stations;
    }

    public Station getDestination() {
        return destination;
    }

    public void setDestination(Station destination) {
        this.destination = destination;
    }

    public Station getSource() {
        return source;
    }

    public void setSource(Station source) {
        this.source = source;
    }
}
