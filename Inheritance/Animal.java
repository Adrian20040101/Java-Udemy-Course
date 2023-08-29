public class Animal {

    protected String type;
    private String size;
    private double weight;

    public Animal(String type, String size, double weight) {
        this.type = type;
        this.size = size;
        this.weight = weight;
    }

    public Animal(){
        this("Generic Animal", "Medium", 50.0);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "type='" + type + '\'' +
                ", size='" + size + '\'' +
                ", weight=" + weight +
                '}';
    }

    public void doAnimalStuff(){
        System.out.println(type + " does some animal stuff");
    }

    public void makeNoise(){
        System.out.println(type + " makes some kind of noise");
    }
}
