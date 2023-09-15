package dev.lpa;

enum Utility{FIBER_OPTIC, ELECTRICITY, WATER, GAS}

public class UtilityLine implements Mappable{

    private String name;
    private Utility utility;

    public UtilityLine(String name, Utility utility){
        this.name = name;
        this.utility = utility;
    }

    @Override
    public String getLabel() {
        return name + "( " + utility + " )";
    }

    @Override
    public Geometry getGeometricType() {
        return Geometry.LINE;
    }

    @Override
    public String getIconType() {
        return switch(utility){
            case GAS -> Color.RED + " " + LineMarker.DASHED;
            case WATER -> Color.BLUE + " " + LineMarker.DOTTED;
            case ELECTRICITY -> Color.ORANGE + " " + LineMarker.DASHED;
            case FIBER_OPTIC -> Color.GREEN + " " + LineMarker.SOLID;
        };
    }

    @Override
    public String toJSON() {
        return Mappable.super.toJSON() + """
                "name" : "%s, "utility" : "%s"\s""".formatted(name, utility);
    }

}
