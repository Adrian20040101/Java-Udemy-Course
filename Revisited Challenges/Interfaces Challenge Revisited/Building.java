package dev.lpa;

enum BuildingUsage{GOVERNMENT, SPORT, ENTERTAINMENT, RELAXATION, EDUCATION}

public class Building implements Mappable{

    private String name;
    private BuildingUsage usage;

    public Building(String name, BuildingUsage usage) {
        this.name = name;
        this.usage = usage;
    }

    @Override
    public String getLabel() {
        return name + " (" + usage + ")";
    }

    @Override
    public Geometry getType() {
        return Geometry.POINT;
    }

    @Override
    public String getMarker() {
        PointMarker marker = switch(usage){
            case GOVERNMENT -> PointMarker.STAR;
            case SPORT -> PointMarker.CIRCLE;
            case ENTERTAINMENT -> PointMarker.SQUARE;
            case EDUCATION -> PointMarker.RHOMBUS;
            case RELAXATION -> PointMarker.TRIANGLE;
        };

        Color color = switch(usage){
            case GOVERNMENT -> Color.YELLOW;
            case SPORT -> Color.GREEN;
            case ENTERTAINMENT -> Color.BLUE;
            case EDUCATION -> Color.RED;
            case RELAXATION -> Color.BLACK;
        };

        return color + " " + marker;
    }

    @Override
    public String JSON(){
        return Mappable.super.JSON() + """ 
                , "name" : "%s", "usage": %s """.formatted(name, usage);
    }
}
