package dev.lpa;

public class Horse extends Mammal{

    public Horse(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public void makeNoise() {
        System.out.println("*Makes some horse noise*");
    }

    public void shedHair(){
        System.out.println(getExplicitType() + " shed hair in the spring");
    }
}
