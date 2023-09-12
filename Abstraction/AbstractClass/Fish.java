package dev.lpa;

public class Fish extends Animal{

    public Fish(String type, String size, double weight){
        super(type, size, weight);
    }

    public void move(String speed){
        if (speed.equals("slow")){
            System.out.print(getExplicitType() + " is swimming slow. ");
        } else {
            System.out.print(getExplicitType() + " is swimming fast. ");
        }
    }

    public void makeNoise(){
        if (type.equals("Goldfish")){
            System.out.println("splish");
        } else {
            System.out.println("splash");
        }
    }
}
