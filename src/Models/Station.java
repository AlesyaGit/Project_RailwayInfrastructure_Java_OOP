package Models;

import java.util.ArrayList;

public class Station {
    private static int idCounter = 0;
    private String name;
    private final ArrayList<Connection> connections;

    private Locomotive arrivingLocomotive;
    private final int id;
    
    public Station(String name) {
        this.name = name;
        this.connections = new ArrayList<>();
        this.id = ++idCounter;
        this.arrivingLocomotive = null;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }

    public ArrayList<Connection> getEdges() {
        return connections;
    }

    public void addEdge(Connection connection){
        connections.add(connection);
    }

    public Locomotive getArrivingLocomotive() {
        return arrivingLocomotive;
    }

    public void setArrivingLocomotive(Locomotive arrivingLocomotive) {
        this.arrivingLocomotive = arrivingLocomotive;
    }
}
