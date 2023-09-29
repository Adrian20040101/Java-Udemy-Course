package dev.lpa;

enum Geometry{POINT, LINE}
enum PointMarker{CIRCLE, STAR, SQUARE, TRIANGLE, RHOMBUS}
enum LineMarker{DOTTED, SOLID, DASHED}
enum Color{BLUE, GREEN, YELLOW, RED, BLACK}
public interface Mappable {

    String JSON_PROPERTY = """
            "properties" : { %s }
            """;

    String getLabel();
    Geometry getType();
    String getMarker();

    default String JSON(){
        return """
                "type": "%s", "label": "%s", "marker": "%s" """
                .formatted(getType(), getLabel(), getMarker());
    }

    static void printData(Mappable mappable){
        System.out.printf(JSON_PROPERTY, mappable.JSON());
    }

}
