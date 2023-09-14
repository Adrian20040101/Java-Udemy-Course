package dev.lpa;

//obviously a truck isn't going to be flying so this class only implements the Trackable interface
public class Truck implements Trackable{

    @Override
    public void track() {
        System.out.println(getClass().getSimpleName() + "'s coordinates are being tracked");
    }
}
