package Models;

import Interfaces.IScanner;

public class RailroadCarCreator {
    public static RailroadCar CreatePassengerRailroadCar(IScanner scanner){
        scanner.printString("Enter seats: ");
        int seats = scanner.readInt();
        scanner.printString("Air Conditioning?: ");
        boolean airCond = scanner.readBoolean();
        scanner.printString("Enter weight: ");
        double weight = scanner.readDouble();
        return new PassengerRailroadCar(weight,seats, airCond);
    }
    public static RailroadCar CreatePostOfficeRailroadCar(IScanner scanner){
        scanner.printString("Mail Sorter?: ");
        boolean mailSorter = scanner.readBoolean();
        scanner.printString("Enter number of pouches: ");
        int pouches = scanner.readInt();
        scanner.printString("Enter weight: ");
        double weight = scanner.readDouble();
        return new PostOfficeRailroadCar(weight,mailSorter,pouches);
    }
    public static RailroadCar CreateBaggageAndMailRailroadCar(IScanner scanner){
        scanner.printString("Enter capacity: ");
        int capacity= scanner.readInt();
        scanner.printString("Lockers?: ");
        boolean lockers = scanner.readBoolean();
        scanner.printString("Enter weight: ");
        double weight = scanner.readDouble();
        return new BaggageAndMailRailroadCar(weight,capacity,lockers);
    }

    public static RailroadCar CreateRestaurantRailroadCar(IScanner scanner){
        scanner.printString("Enter seating capacity: ");
        int seatingCapacity= scanner.readInt();
        scanner.printString("Kitchen?: ");
        boolean lockers = scanner.readBoolean();
        scanner.printString("Enter weight: ");
        double weight = scanner.readDouble();
        return new RestaurantRailroadCar(weight,seatingCapacity,lockers);
    }

    public static RailroadCar CreateBasicFreightRailroadCar(IScanner scanner){
        scanner.printString("Enter net weight: ");
        double netWeight= scanner.readDouble();
        scanner.printString("Enter gross weight: ");
        double grossWeight= scanner.readDouble();
        scanner.printString("Requires Electrical Grid?: ");
        boolean elcGrid = scanner.readBoolean();
        scanner.printString("Enter weight: ");
        double weight = scanner.readDouble();
        return new BasicFreightRailroadCar(weight,netWeight,grossWeight,elcGrid);
    }

    public static RailroadCar CreateHeavyFreightRailroadCar(IScanner scanner){
        scanner.printString("Enter max load capacity: ");
        double maxLoadCapacity= scanner.readDouble();
        scanner.printString("Enter net weight: ");
        double netWeight= scanner.readDouble();
        scanner.printString("Enter gross weight: ");
        double grossWeight= scanner.readDouble();
        scanner.printString("Requires Electrical Grid?: ");
        boolean elcGrid = scanner.readBoolean();
        scanner.printString("Enter weight: ");
        double weight = scanner.readDouble();
        return new HeavyFreightRailroadCar(weight,maxLoadCapacity,netWeight,grossWeight,elcGrid);
    }


    public static RailroadCar CreateRefrigeratedRailroadCar(IScanner scanner){
        scanner.printString("Enter net weight: ");
        double netWeight= scanner.readDouble();
        scanner.printString("Enter gross weight: ");
        double grossWeight= scanner.readDouble();
        scanner.printString("Cooling System?: ");
        boolean collingSystem = scanner.readBoolean();
        scanner.printString("Enter weight: ");
        double weight = scanner.readDouble();
        return new RefrigeratedRailroadCar(weight,netWeight,grossWeight,collingSystem);
    }

    public static RailroadCar CreateLiquidMaterialsRailroadCar(IScanner scanner){
        scanner.printString("Enter net weight: ");
        double netWeight= scanner.readDouble();
        scanner.printString("Enter gross weight: ");
        double grossWeight= scanner.readDouble();
        scanner.printString("Pump?: ");
        boolean pump = scanner.readBoolean();
        scanner.printString("Number of valves: ");
        int numbOfValves = scanner.readInt();
        scanner.printString("Enter weight: ");
        double weight = scanner.readDouble();
        return new LiquidMaterialsRailroadCar(weight,netWeight,grossWeight,pump,numbOfValves);
    }

    public static RailroadCar CreateGaseousMaterialsRailroadCar(IScanner scanner){
        scanner.printString("Enter net weight: ");
        double netWeight= scanner.readDouble();
        scanner.printString("Enter gross weight: ");
        double grossWeight= scanner.readDouble();
        scanner.printString("Enter weight: ");
        double weight = scanner.readDouble();
        return new GaseousMaterialsRailroadCar(weight,netWeight,grossWeight);
    }

    public static RailroadCar CreateExplosivesRailroadCar(IScanner scanner){
        scanner.printString("Enter max load capacity: ");
        double maxLoadCapacity= scanner.readDouble();
        scanner.printString("Enter net weight: ");
        double netWeight= scanner.readDouble();
        scanner.printString("Enter gross weight: ");
        double grossWeight= scanner.readDouble();
        scanner.printString("Blast resistant?: ");
        boolean blstRst = scanner.readBoolean();
        scanner.printString("Enter Max Explosive Weight: ");
        int maxExplosiveWeight = scanner.readInt();
        scanner.printString("Enter weight: ");
        double weight = scanner.readDouble();
        return new ExplosivesRailroadCar(weight,maxLoadCapacity,netWeight,grossWeight,blstRst,maxExplosiveWeight);
    }

    public static RailroadCar CreateToxicMaterialsRailroadCar(IScanner scanner){
        scanner.printString("Enter max load capacity: ");
        double maxLoadCapacity= scanner.readDouble();
        scanner.printString("Enter net weight: ");
        double netWeight= scanner.readDouble();
        scanner.printString("Enter gross weight: ");
        double grossWeight= scanner.readDouble();
        scanner.printString("Hazardous Materials Signs?: ");
        boolean hasHazardousMaterialsSigns = scanner.readBoolean();
        scanner.printString("Enter toxic material name: ");
        String toxicMaterialName = scanner.readString();
        scanner.printString("Enter weight: ");
        double weight = scanner.readDouble();
        return new ToxicMaterialsRailroadCar(weight,maxLoadCapacity,netWeight,grossWeight,hasHazardousMaterialsSigns,toxicMaterialName);
    }
    public static RailroadCar CreateLiquidToxicMaterialRailroadCar(IScanner scanner){
        scanner.printString("Enter net weight: ");
        double netWeight= scanner.readDouble();
        scanner.printString("Enter gross weight: ");
        double grossWeight= scanner.readDouble();
        scanner.printString("Pump?: ");
        boolean pump = scanner.readBoolean();
        scanner.printString("Number of valves: ");
        int numbOfValves = scanner.readInt();
        scanner.printString("Hazardous Materials Signs?: ");
        boolean hasHazardousMaterialsSigns = scanner.readBoolean();
        scanner.printString("Enter toxic material name: ");
        String toxicMaterialName = scanner.readString();
        scanner.printString("Enter weight: ");
        double weight = scanner.readDouble();
        return new LiquidToxicMaterialRailroadCar(weight,netWeight,grossWeight,pump,numbOfValves, hasHazardousMaterialsSigns,toxicMaterialName);
    }
}
