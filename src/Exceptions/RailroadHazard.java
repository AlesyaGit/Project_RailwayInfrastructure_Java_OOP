package Exceptions;

import Models.RailroadHazardInformation;

public class RailroadHazard extends Exception{
    private final RailroadHazardInformation railroadHazardInformation;

    public RailroadHazard(RailroadHazardInformation railroadHazardInformation) {
        this.railroadHazardInformation = railroadHazardInformation;
    }

    public RailroadHazardInformation getRailroadHazardInformation() {
        return railroadHazardInformation;
    }
}
