package Models;

public class StationWithDistance {
    public Station station;
    public int distance;

    public StationWithDistance(Station station, int distance) {
        this.station = station;
        this.distance = distance;
    }


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
}