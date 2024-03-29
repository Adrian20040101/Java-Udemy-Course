package dev.lpa;

public class Jet implements FlightEnabled, Trackable{

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

    @Override
    public FlightStages transition(FlightStages stage) {
        FlightStages nextStage = stage.getNextStage();
        System.out.println(getClass().getSimpleName() + " is transitioning from " + stage + " to " +
                nextStage);
        return nextStage;
    }
}
