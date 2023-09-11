package dev.lpa;

// NOTE: if we wanted the class Dog to inherit from Mammal instead of Animal, we would have had to also
//       implement the shedHair() abstract method from the Mammal class

public class Dog extends Animal{

    public Dog(String type, String size, double weight){
        super(type, size, weight);
    }

    @Override
    public void move(String speed){
        if (speed.equals("slow")){
            System.out.print(getExplicitType() + " is walking. ");
        } else {
            System.out.print(getExplicitType() + " is running. ");
        }
    }

    @Override
    public void makeNoise(){
        if (type.equals("Wolf")){
            System.out.println("Howling!");
        } else {
            System.out.println("Woof!");
        }
    }
}
