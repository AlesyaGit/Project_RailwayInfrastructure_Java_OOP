package Models;

public class ToxicMaterialsRailroadCar extends HeavyFreightRailroadCar{
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

    public ToxicMaterialsRailroadCar(double weight,double maximumLoadCapacity, double netWeight, double grossWeight, boolean hasHazardousMaterialsSigns, String toxicMaterialName) {
        super(weight,maximumLoadCapacity, netWeight, grossWeight,true);
        this.hasHazardousMaterialsSigns = hasHazardousMaterialsSigns;
        this.toxicMaterialName = toxicMaterialName;
    }

    @Override
    public String toString() {
        return super.toString() + "Toxic material name = " + toxicMaterialName + "; Has hazardous materials signs = "+ hasHazardousMaterialsSigns;
    }
}
