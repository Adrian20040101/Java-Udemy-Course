package dev.lpa;

public class Park extends Point{
    private String name;
    private Point point;

    public Park(String name, double latitude, double longitude){
        super(latitude, longitude);
        this.name = name;
    }

    @Override
    public void render() {
        System.out.println("Render " + name + " as " + super.getClass().getSimpleName() +
                " at coordinates " + latitude + "," + longitude);
    }
}
