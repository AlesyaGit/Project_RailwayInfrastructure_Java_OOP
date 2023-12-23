package Models;

public class LiquidToxicMaterialRailroadCar extends LiquidMaterialsRailroadCar{
    private boolean hasHazardousMaterialsSigns;
    private String toxicMaterialName;

    public boolean isHasHazardousMaterialsSigns() {
        return hasHazardousMaterialsSigns;
    }

    public void setHasHazardousMaterialsSigns(boolean hasHazardousMaterialsSigns) {
        this.hasHazardousMaterialsSigns = hasHazardousMaterialsSigns;
    }

    public String getToxicMaterialName() {
        return toxicMaterialName;
    }

    public void setToxicMaterialName(String toxicMaterialName) {
        this.toxicMaterialName = toxicMaterialName;
    }

    public LiquidToxicMaterialRailroadCar(double weight,double netWeight, double grossWeight, boolean hasPump, int numberOfValves, boolean hasHazardousMaterialsSigns, String toxicMaterialName) {
        super(weight,netWeight, grossWeight, hasPump, numberOfValves);
        this.hasHazardousMaterialsSigns = hasHazardousMaterialsSigns;
        this.toxicMaterialName = toxicMaterialName;
    }
}
