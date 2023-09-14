package dev.lpa;

enum FlightStages implements Trackable {GROUNDED, LAUNCH, CRUISE, DATA_COLLECTION;

    @Override
    public void track() {
        if (this != GROUNDED){
            System.out.println("Monitoring" + this);
        }
    }

    public FlightStages getNextStage(){
        FlightStages[] stages = values();
        return stages[(ordinal() + 1) % stages.length];
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

    FlightStages stage = FlightStages.GROUNDED;
    public void achieveOrbit(){
        transition("Orbit achieved");
    }

    @Override
    public void takeOff() {
        transition("Taking off");
    }

    @Override
    public void land() {
        transition("Landing");
    }

    @Override
    public void fly() {
        achieveOrbit();
        transition("Data Collection while Orbiting");
    }

    public void transition(String description){
        System.out.println(description);
        stage = transition(stage);
        stage.track();
    }
}

interface OrbitEarth extends FlightEnabled{
    void achieveOrbit();

    private static void log(String description){   //only available to be used by interface's concrete methods
        var today = new java.util.Date();
        System.out.println(today + ": " + description);
    }

    private void logStage(FlightStages stage, String description){
        description = stage + ": " + description;
        log(description);
    }

    @Override
    default FlightStages transition(FlightStages stage) {
        FlightStages nextStage = FlightEnabled.super.transition(stage);
        logStage(stage, "Beginning Transition to " + nextStage);
        return nextStage;
    }
}
interface FlightEnabled{

    public static final double MILES_TO_KM = 1.6;  //public, static and final are redundant, since we only declare constants, and by naming convention they are written in only caps
    double KM_TO_MILES = 0.6;

    //these methods are only declared in the interface and will be implemented in the bird CONCRETE class
    public abstract void takeOff(); //public access modifier and abstract keyword are redundant, they are implicitly declared
    abstract void land();  //abstract is redundant
    void fly();

    default FlightStages transition (FlightStages stage){   // this is called an extension method
        System.out.println("Transition not implemented on " + this.getClass().getSimpleName());
        return null;
    }
}

interface Trackable{

    void track();
}
public abstract class Animal {

    public abstract void move();
}
