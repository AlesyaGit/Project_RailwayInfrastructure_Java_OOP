package Models;

public record RailroadHazardInformation(Locomotive locomotive, double percentCoveredTotalDistance, int numberOfPeople, double percentCoveredPreDistance){
    @Override
    public String toString() {
        return "Locomotive with Id = "+ locomotive.getId()+" exceeded the speed limit. Information: "
                + "covered total distance "+(int)percentCoveredTotalDistance+"%; "
                + "covered pre distance "+(int)percentCoveredPreDistance+"%; "
                + "number of people "+ numberOfPeople;
    }
}
