package Interfaces;

import Models.Locomotive;
import Models.RailroadCar;

import java.util.List;

public interface IFileStorage {
    void save(List<Locomotive> locomotives, List<RailroadCar> railroadCars);
}
