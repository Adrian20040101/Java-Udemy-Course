public class Fish extends Animal{
    private int gills;
    private int fins;

    public Fish(String type, String size, double weight, int gills, int fins) {
        super(type, size, weight);
        this.gills = gills;
        this.fins = fins;
    }

    @Override
    public String toString() {
        return "Fish{" +
                "gills=" + gills +
                ", fins=" + fins +
                "} " + super.toString();
    }

    @Override
    public void doAnimalStuff() {
        System.out.println(type +" is swimming");
    }

    public void location(){
        System.out.println(type + " lies in the ocean");
    }
}
