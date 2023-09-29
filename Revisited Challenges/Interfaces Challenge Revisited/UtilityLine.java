package dev.lpa;

enum LineUsage{ELECTRICAL, FIBER_OPTIC, WATER, GAS}

public class UtilityLine implements Mappable{

    private String name;
    private LineUsage usage;

    public UtilityLine(String name, LineUsage usage) {
        this.name = name;
        this.usage = usage;
    }

    @Override
    public String getLabel() {
        return name + " (" + usage + ")";
    }

    @Override
    public Geometry getType() {
        return Geometry.LINE;
    }

    @Override
    public String getMarker() {
        LineMarker marker = switch(usage){
            case ELECTRICAL, FIBER_OPTIC -> LineMarker.SOLID;
            case GAS -> LineMarker.DOTTED;
            case WATER -> LineMarker.DASHED;
        };

        Color color = switch(usage){
            case ELECTRICAL -> Color.YELLOW;
            case FIBER_OPTIC -> Color.GREEN;
            case WATER -> Color.BLUE;
            case GAS -> Color.RED;
        };

        return color + " " + marker;
    }

    @Override
    public String JSON(){
        return Mappable.super.JSON() + """
                "name" : "%s", "usage": %s """.formatted(name, usage);
    }
}
