package dev.lpa;

public abstract class Point implements Mappable{

    protected double latitude;
    protected double longitude;

    public Point(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public abstract void render();
}
