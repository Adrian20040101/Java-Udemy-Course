package dev.lpa;

import java.util.List;

public class River extends Line{

    private String name;

    public River(String name, List<Double> coordinates) {
        super(coordinates);
        this.name = name;
    }

    @Override
    public void render() {
        System.out.println("Render " + name + " as " + getClass().getSimpleName() + "[" +
                "[" + coordinates.get(0) + ", " + coordinates.get(1) + "], " +
                "[" + coordinates.get(2) + ", " + coordinates.get(3) + "], " +
                "[" + coordinates.get(4) + ", " + coordinates.get(5) + "]" +
                "]");

    }
}
