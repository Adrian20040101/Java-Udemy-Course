package dev.lpa;

//interfaces lets us take objects, that may have almost nothing in common and write reusable code, so we can process them all in a like manner
//for example, a jet, a bird and a dragonfly have very little in common, but because they all implement FlightEnabled methods, we can treat them as the same type
//even say a truck class. It obviously doesn't fly, but it can implement the method from the Trackable interface

public class Bird extends Animal implements FlightEnabled, Trackable{

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " is flapping its wings");
    }

    @Override
    public void takeOff() {
        System.out.println(getClass().getSimpleName() + " is taking off");
    }

    @Override
    public void land() {
        System.out.println(getClass().getSimpleName() + " is landing");
    }

    @Override
    public void fly() {
        System.out.println(getClass().getSimpleName() + " is flying");
    }

    @Override
    public void track() {
        System.out.println(getClass().getSimpleName() + "'s coordinates are being tracked");
    }
}
