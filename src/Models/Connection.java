package Models;

public class Connection {
    private Station station;
    private int distance;

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Connection(Station station, int distance) {
        this.station = station;
        this.distance = distance;
    }
}
