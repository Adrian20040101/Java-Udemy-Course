public class Car {

    private String description;

    public Car(String description){
        this.description = description;
    }

    public Car(){}

    public void startEngine(){
        System.out.println("VROOM VROOM");
    }

    public void drive(){
        System.out.println("Driving... Pay attention to the road ahead!");
    }

    protected void runEngine(){
        System.out.println("Engine running...");
    }

    //this is known as the factory method - a well known pattern design in OOP. It is a method that creates objects of various types
    public static Car getCarType(String description){
        return switch(description.toUpperCase().charAt(0)){
            case 'G' -> new GasPoweredCar(421.56, 12);
            case 'E' -> new ElectricCar(300.54, 20000);
            case 'H' -> new HybridCar(503.43, 10000, 8);
            default -> new Car();
        };
    }

}
