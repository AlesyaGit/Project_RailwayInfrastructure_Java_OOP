package Implements;

import Interfaces.IFileStorage;
import Models.Locomotive;
import Models.RailroadCar;
import States.LocomotiveOnJourneyState;

import java.io.File;
import java.io.FileWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FileStorage implements IFileStorage {
    private final String FILE_NAME = "AppState.txt";
    @Override
    public void save(List<Locomotive> locomotives, List<RailroadCar> railroadCars) {
        String railRoadCars = railroadCars.stream()
                .sorted(Comparator.comparing(RailroadCar::getWeight)).map(RailroadCar::toString)
                .collect(Collectors.joining("\n"));
        String locomotivesString = locomotives.stream()
                .sorted(Comparator
                        .comparing(x->(x.getState() instanceof LocomotiveOnJourneyState ? ((LocomotiveOnJourneyState)x.getState()).getCoveredDistance() : 0)
                        ,Collections.reverseOrder())).map(Locomotive::toString)
                .collect(Collectors.joining("\n"));
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter writer = new FileWriter(file);
            writer.write("Locomotives\n");
            writer.write(locomotivesString);
            writer.write("\nRailroads\n");
            writer.write(railRoadCars);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
