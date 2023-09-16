package dev.lpa;

import java.util.ArrayList;
import java.util.List;

public abstract class Line implements Mappable{

    protected List<Double> coordinates = new ArrayList<>();

    public Line(List<Double> coordinates) {
        if (coordinates.size() != 6) System.out.println("There must be exactly 6 coordinates");
        else this.coordinates = coordinates;
    }

    public abstract void render();
}
