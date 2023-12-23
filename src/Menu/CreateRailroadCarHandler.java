package Menu;

import Exceptions.RailroadCarNotFound;
import Interfaces.IScanner;
import Models.Locomotive;
import Models.RailroadCar;
import Models.RailroadCarCreator;
import Models.World;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

record ItemRailroadCarList(String name, int number, FuncCreateRailroadCar creator) {
    @Override
    public String toString() {
        return number + ". " + name;
    }
}
public class CreateRailroadCarHandler extends MenuHandler{
    private final List<ItemRailroadCarList> railroadCarMap = new ArrayList<>();
    public CreateRailroadCarHandler(int number, String title) {
        super(number, title);
        this.railroadCarMap.add(new ItemRailroadCarList("Passenger railroad car", 1, RailroadCarCreator::CreatePassengerRailroadCar));
        this.railroadCarMap.add(new ItemRailroadCarList("Railroad post office", 2, RailroadCarCreator::CreatePostOfficeRailroadCar));
        this.railroadCarMap.add(new ItemRailroadCarList("Railroad baggage and mail car", 3, RailroadCarCreator::CreateBaggageAndMailRailroadCar));
        this.railroadCarMap.add(new ItemRailroadCarList("Railroad restaurant car", 4, RailroadCarCreator::CreateRestaurantRailroadCar));
        this.railroadCarMap.add(new ItemRailroadCarList("Basic railroad freight car", 5, RailroadCarCreator::CreateBasicFreightRailroadCar));
        this.railroadCarMap.add(new ItemRailroadCarList("Heavy railroad freight car", 6, RailroadCarCreator::CreateHeavyFreightRailroadCar));
        this.railroadCarMap.add(new ItemRailroadCarList("Refrigerated railroad car", 7, RailroadCarCreator::CreateRefrigeratedRailroadCar));
        this.railroadCarMap.add(new ItemRailroadCarList("Railroad car for liquid materials", 8, RailroadCarCreator::CreateLiquidMaterialsRailroadCar));
        this.railroadCarMap.add(new ItemRailroadCarList("Railroad car for gaseous material", 9, RailroadCarCreator::CreateGaseousMaterialsRailroadCar));
        this.railroadCarMap.add(new ItemRailroadCarList("Railroad car for explosives", 10, RailroadCarCreator::CreateExplosivesRailroadCar));
        this.railroadCarMap.add(new ItemRailroadCarList("Railroad car for toxic materials", 11, RailroadCarCreator::CreateToxicMaterialsRailroadCar));
        this.railroadCarMap.add(new ItemRailroadCarList("Railroad car for liquid, toxic material", 12, RailroadCarCreator::CreateLiquidToxicMaterialRailroadCar));
    }
    @Override
    public void handle(IScanner scanner, World world) throws RailroadCarNotFound {
        scanner.printlnString("Creating railroad car");
        String menu = railroadCarMap.stream().map(x->x.toString()).collect(Collectors.joining ("\n"));
        scanner.printlnString(menu);
        scanner.printString("Enter number: ");
        int number = scanner.readInt();
        ItemRailroadCarList item = railroadCarMap.stream().filter(x->x.number()==number).findFirst().orElse(null);
        if(item==null) throw new RailroadCarNotFound("Railroad with this number doesn't exist");

        RailroadCar railroadCar = item.creator().createRailroadCar(scanner);
        world.addRailroadCar(railroadCar);

    }
}
