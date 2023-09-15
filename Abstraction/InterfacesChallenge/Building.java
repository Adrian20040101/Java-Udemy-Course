package dev.lpa;

enum Usage{ENTERTAINMENT, GOVERNMENT, SPORTS, RESIDENTIAL}
public class Building implements Mappable{

    private String name;
    private Usage usage;

    public Building(String name, Usage usage){
        this.name = name;
        this.usage = usage;
    }

    @Override
    public String getLabel() {
        return name + "( " + usage + " )";
    }

    @Override
    public Geometry getGeometricType() {
        return Geometry.POINT;
    }

    @Override
    public String getIconType() {
        return switch(usage){
            case ENTERTAINMENT -> Color.RED + " " + PointMarker.TRIANGLE;
            case RESIDENTIAL -> Color.GREEN + " " + PointMarker.SQUARE;
            case SPORTS -> Color.BLUE + " " + PointMarker.PUSH_PIN;
            case GOVERNMENT -> Color.ORANGE + " " + PointMarker.STAR;
        };
    }

    //to have the name and the usage separately printed in the same mappable info output, do this:

    @Override
    public String toJSON() {
        return Mappable.super.toJSON() + """
                "name" : "%s", "usage" : "%s"\s""".formatted(name, usage);
    }
}
