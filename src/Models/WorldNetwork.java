package Models;

import java.util.*;

public class WorldNetwork {
    public List<Station> getStations() {
        return stations;
    }

    private final List<Station> stations;
    public WorldNetwork() {
        stations = new ArrayList<>();
    }

    public void addStation(Station station) {
        stations.add(station);
    }
    public void addConnection(int stationId, int station2Id, int weight) {
        Station station = getStationById(stationId);
        Station station2 = getStationById(station2Id);
        Connection connection1 = new Connection(station2, weight);
        Connection connection2 = new Connection(station, weight);
        station.addEdge(connection1);
        station2.addEdge(connection2);
    }
    public void addConnection(Station station, Station station2, int weight) {
        Connection connection1 = new Connection(station2, weight);
        Connection connection2 = new Connection(station, weight);
        station.addEdge(connection1);
        station2.addEdge(connection2);
    }

    public void generateStations(int numberStations){
        for (int i = 0; i < numberStations; i++) {
            Station station = new Station("Station " + (i+1));
            stations.add(station);
        }
    }

    public void generateConnections(int maxEdgesPerStation,int minDistance, int maxDistance){
        Random random = new Random();
        for (int i = 0; i < stations.size(); i++) {
            Station source = stations.get(i);
            int numEdges = random.nextInt(maxEdgesPerStation) + 1;
            List<Station> availableStations = new ArrayList<>(stations);
            availableStations.remove(source);
            for (int j = 0; j < numEdges; j++) {
                if (availableStations.isEmpty()) {
                    break;
                }
                int index = random.nextInt(availableStations.size());
                Station destination = availableStations.get(index);
                availableStations.remove(index);
                int distance = random.nextInt(minDistance,maxDistance) + 1;
                addConnection(source, destination, distance);
            }
        }
    }
    public Station getStationById(int id) {
        return stations.stream().filter(x->x.getId()==id).findFirst().orElse(null);
    }
    public List<StationWithDistance> searchRoute(Station start, Station end) {
        Set<Station> visited = new HashSet<>();
        Stack<StationWithDistance> stack = new Stack<>();
        Map<Station, Station> previousNodes = new HashMap<>();
        Map<Station, Integer> previousDistances = new HashMap<>();

        stack.push(new StationWithDistance(start, 0));
        visited.add(start);

        while (!stack.isEmpty()) {
            StationWithDistance current = stack.pop();
            if (current.station == end) {
                break;
            }
            for (Connection connection : current.station.getEdges()) {
                Station neighbor = connection.getStation();
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    previousNodes.put(neighbor, current.station);
                    int distance = connection.getDistance();
                    previousDistances.put(neighbor, distance);
                    stack.push(new StationWithDistance(neighbor, current.distance + distance));
                }
            }
        }

        List<StationWithDistance> path = new ArrayList<>();
        Station current = end;
        while (current != null) {
            int distance = previousDistances.get(current) != null ? previousDistances.get(current) : 0;
            path.add(new StationWithDistance(current, distance));
            current = previousNodes.get(current);
        }
        Collections.reverse(path);
        return path;
    }
}
