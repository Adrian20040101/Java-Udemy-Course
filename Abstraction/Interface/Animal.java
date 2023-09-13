package dev.lpa;

enum FlightStages implements Trackable {GROUNDED, LAUNCH, CRUISE, DATA_COLLECTION;

    @Override
    public void track() {
        if (this != GROUNDED){
            System.out.println("Monitoring" + this);
        }
    }
}

record DragonFly(String name, String type) implements FlightEnabled{
    @Override
    public void takeOff() {
        //some code
    }

    @Override
    public void land() {
        //some code
    }

    @Override
    public void fly() {
        //some code
    }
}

class Satellite implements OrbitEarth{
    public void achieveOrbit(){
        System.out.println("Orbit achieved");
    }

    @Override
    public void takeOff() {
        //some code
    }

    @Override
    public void land() {
        //some code
    }

    @Override
    public void fly() {
        //some code
    }
}

interface OrbitEarth extends FlightEnabled{
    void achieveOrbit();
}
interface FlightEnabled{

    public static final double MILES_TO_KM = 1.6;  //public, static and final are redundant, since we only declare constants, and by naming convention they are written in only caps
    double KM_TO_MILES = 0.6;

    //these methods are only declared in the interface and will be implemented in the bird CONCRETE class
    public abstract void takeOff(); //public access modifier and abstract keyword are redundant, they are implicitly declared
    abstract void land();  //abstract is redundant
    void fly();
}

interface Trackable{

    void track();
}
public abstract class Animal {

    public abstract void move();
}
