package dev.lpa;

enum Geometry{POINT, LINE}

enum Color{BLACK, RED, BLUE, GREEN, ORANGE}

enum PointMarker{CIRCLE, PUSH_PIN, STAR, TRIANGLE, SQUARE}

enum LineMarker{DASHED, DOTTED, SOLID}

public interface Mappable {
    String JSON_PROPERTY = """
            "properties : {%s}
            """;
    String getLabel();

    Geometry getGeometricType();

    String getIconType();

    default String toJSON(){
        return """
                "type : "%s", label : "%s", "marker" : "%s"\s""".formatted(getGeometricType(), getLabel(), getIconType());
    }

    static void printProperties(Mappable mappable){
        System.out.print(JSON_PROPERTY.formatted(mappable.toJSON()));
    }
}
