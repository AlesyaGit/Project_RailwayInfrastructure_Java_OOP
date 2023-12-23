package Models;

import Interfaces.IScanner;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RailroadRandomCarCreator {
    private final List<FuncCreateRandomRailroadCar> randomRailroadCars;

    public RailroadRandomCarCreator() {
        this.randomRailroadCars = new ArrayList<>();
        randomRailroadCars.add(RailroadRandomCarCreator::CreatePassengerRailroadCar);
        randomRailroadCars.add(RailroadRandomCarCreator::CreatePostOfficeRailroadCar);
        randomRailroadCars.add(RailroadRandomCarCreator::CreateBaggageAndMailRailroadCar);
        randomRailroadCars.add(RailroadRandomCarCreator::CreateRestaurantRailroadCar);
        randomRailroadCars.add(RailroadRandomCarCreator::CreateBasicFreightRailroadCar);
        randomRailroadCars.add(RailroadRandomCarCreator::CreateHeavyFreightRailroadCar);
        randomRailroadCars.add(RailroadRandomCarCreator::CreateRefrigeratedRailroadCar);
        randomRailroadCars.add(RailroadRandomCarCreator::CreateLiquidMaterialsRailroadCar);
        randomRailroadCars.add(RailroadRandomCarCreator::CreateGaseousMaterialsRailroadCar);
        randomRailroadCars.add(RailroadRandomCarCreator::CreateExplosivesRailroadCar);
        randomRailroadCars.add(RailroadRandomCarCreator::CreateToxicMaterialsRailroadCar);
        randomRailroadCars.add(RailroadRandomCarCreator::CreateLiquidToxicMaterialRailroadCar);
    }

    public RailroadCar getRandRailroadCar(int maximumWeight){
        Random rnd = new Random();
        int index = rnd.nextInt(randomRailroadCars.size());
        return randomRailroadCars.get(index).createRailroadCar(rnd, maximumWeight);
    }
    public static RailroadCar CreatePassengerRailroadCar(Random random,int maxWeight){
        double weight = random.nextInt(maxWeight);
        int sets = random.nextInt(50-20)+20;
        return new PassengerRailroadCar(weight,sets,random.nextBoolean());
    }


    public static RailroadCar CreatePostOfficeRailroadCar(Random random,int maxWeight){
        boolean mailSorter = random.nextBoolean();
        int pouches = random.nextInt(100-50)+50;
        double weight = random.nextInt(maxWeight-100)+100;
        return new PostOfficeRailroadCar(weight,mailSorter,pouches);
    }
    public static RailroadCar CreateBaggageAndMailRailroadCar(Random random,int maxWeight){
        int capacity= random.nextInt(300-100)+100;
        boolean lockers = random.nextBoolean();
        double weight = random.nextInt(maxWeight-100)+100;
        return new BaggageAndMailRailroadCar(weight,capacity,lockers);
    }

    public static RailroadCar CreateRestaurantRailroadCar(Random random,int maxWeight){
        int seatingCapacity= random.nextInt(50-20)+20;
        boolean lockers = random.nextBoolean();
        double weight = random.nextInt(maxWeight-100)+100;
        return new RestaurantRailroadCar(weight,seatingCapacity,lockers);
    }

    public static RailroadCar CreateBasicFreightRailroadCar(Random random,int maxWeight){
        double netWeight= random.nextDouble(300-100)+100;
        double grossWeight= random.nextDouble(300-100)+100;
        boolean elcGrid = random.nextBoolean();
        double weight = random.nextInt(maxWeight-100)+100;
        return new BasicFreightRailroadCar(weight,netWeight,grossWeight,elcGrid);
    }

    public static RailroadCar CreateHeavyFreightRailroadCar(Random random,int maxWeight){
        double maxLoadCapacity= random.nextDouble(300-100)+100;
        double netWeight= random.nextDouble(300-100)+100;
        double grossWeight= random.nextDouble(300-100)+100;
        boolean elcGrid = random.nextBoolean();
        double weight = random.nextInt(maxWeight-100)+100;
        return new HeavyFreightRailroadCar(weight,maxLoadCapacity,netWeight,grossWeight,elcGrid);
    }


    public static RailroadCar CreateRefrigeratedRailroadCar(Random random,int maxWeight){
        double netWeight= random.nextDouble(300-100)+100;
        double grossWeight= random.nextDouble(300-100)+100;
        boolean collingSystem = random.nextBoolean();
        double weight = random.nextInt(maxWeight-100)+100;
        return new RefrigeratedRailroadCar(weight,netWeight,grossWeight,collingSystem);
    }

    public static RailroadCar CreateLiquidMaterialsRailroadCar(Random random,int maxWeight){
        double netWeight= random.nextDouble(300-100)+100;
        double grossWeight= random.nextDouble(300-100)+100;
        boolean pump = random.nextBoolean();
        int numbOfValves = random.nextInt(100)+100;
        double weight = random.nextInt(maxWeight-100)+100;
        return new LiquidMaterialsRailroadCar(weight,netWeight,grossWeight,pump,numbOfValves);
    }

    public static RailroadCar CreateGaseousMaterialsRailroadCar(Random random,int maxWeight){
        double netWeight= random.nextDouble(300-100)+100;
        double grossWeight= random.nextDouble(300-100)+100;
        double weight = random.nextInt(maxWeight-100)+100;
        return new GaseousMaterialsRailroadCar(weight,netWeight,grossWeight);
    }

    public static RailroadCar CreateExplosivesRailroadCar(Random random,int maxWeight){
        double maxLoadCapacity= random.nextDouble(300-100)+100;
        double netWeight= random.nextDouble(300-100)+100;
        double grossWeight= random.nextDouble(300-100)+100;
        boolean blstRst = random.nextBoolean();
        int maxExplosiveWeight = random.nextInt(100)+100;

        double weight = random.nextInt(maxWeight-100)+100;
        return new ExplosivesRailroadCar(weight,maxLoadCapacity,netWeight,grossWeight,blstRst,maxExplosiveWeight);
    }

    public static RailroadCar CreateToxicMaterialsRailroadCar(Random random,int maxWeight){
        double maxLoadCapacity= random.nextDouble(300-100)+100;
        double netWeight= random.nextDouble(300-100)+100;
        double grossWeight= random.nextDouble(300-100)+100;
        boolean hasHazardousMaterialsSigns = random.nextBoolean();
        String toxicMaterialName = "Toxic material #"+random.nextInt(100);
        double weight = random.nextInt(maxWeight-100)+100;
        return new ToxicMaterialsRailroadCar(weight,maxLoadCapacity,netWeight,grossWeight,hasHazardousMaterialsSigns,toxicMaterialName);
    }
    public static RailroadCar CreateLiquidToxicMaterialRailroadCar(Random random,int maxWeight){
        double netWeight= random.nextDouble(300-100)+100;
        double grossWeight= random.nextDouble(300-100)+100;
        boolean pump = random.nextBoolean();
        int numbOfValves = random.nextInt(100)+100;
        boolean hasHazardousMaterialsSigns = random.nextBoolean();
        String toxicMaterialName = "Toxic material #"+random.nextInt(100);
        double weight = random.nextInt(maxWeight-100)+100;
        return new LiquidToxicMaterialRailroadCar(weight,netWeight,grossWeight,pump,numbOfValves, hasHazardousMaterialsSigns,toxicMaterialName);
    }


}
