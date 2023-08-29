public class Dog extends Animal{

    private String speed;
    private String earShape;
    private String tailShape;

    public Dog(String type, double weight, String speed, String earShape, String tailShape) {
        //with 'super' we are calling the superclasses constructor
        super(type, weight < 25 ? "small" : (weight < 50 ? "medium" : "large"), weight);
        this.speed = speed;
        this.earShape = earShape;
        this.tailShape = tailShape;
    }

    public Dog(String type, double weight){
        this(type, weight, "fast", "Perky", "Curled");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "speed='" + speed + '\'' +
                ", earShape='" + earShape + '\'' +
                ", tailShape='" + tailShape + '\'' +
                "} " + super.toString();
    }

    @Override
    public void doAnimalStuff() {
        if (speed == "fast"){
            run(); bark();
        } else {
            walk();
        }
    }

    public void playing() {
        System.out.println( type + " is playing in the yard");
    }

    @Override
    public void makeNoise() {
        System.out.println("Woof Woof!");
    }

    private void bark(){
        System.out.println(type + " is barking");
    }

    private void run(){
        System.out.println(type + " is running");
    }

    private void walk(){
        System.out.println(type + " is walking");
    }
}
