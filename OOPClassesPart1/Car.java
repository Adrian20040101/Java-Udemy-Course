public class Car {

    //the five variables that we declare are called attributes of the class Car. They are private to ensure encapsulation
    private String make;
    private String model;
    private String color;
    private int doors;
    private boolean isConvertible;

    //getters (useful for accessing the attributes from outside the class)
    public String getMake(){
        return make;
    }

    public String getModel(){
        return model;
    }

    public String getColor(){
        return color;
    }

    public int getDoors(){
        return doors;
    }

    public boolean getIsConvertible(){
        return isConvertible;
    }

    //setters (useful for setting values to the attributes outside of the class)

    public void setMake(String make){
        this.make = make;
    }

    public void setModel(String model){
        this.model = model;
    }

    public void setColor(String color){
        this.color = color;
    }

    public void setDoors(int doors){
        this.doors = doors;
    }

    public void setIsConvertible(boolean isConvertible){
        this.isConvertible = isConvertible;
    }

    //methods of the class (these methods describe the behaviour of the object created by the class)
    //we can also find static methods, that don't require a specific object to perform an action. These methods are called directly using the class name followed by the dot notation

    public void describeCar(){
        System.out.println("The car has the following specs: " +
                color + " " + make + " " + model + " with " + doors + " doors " +
                (isConvertible ? "and is convertible" : "and is not convertible") );
                //we used the ternary operator to check if the car is convertible or not and print only the appropriate message
    }
}
