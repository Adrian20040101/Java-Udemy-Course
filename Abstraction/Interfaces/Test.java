package dev.lpa;

public class Test {
    public static void main(String[] args) {

        //before we override the transition method on Jet class, it will display the message
        inFlight(new Jet());

        // OrbitEarth.log("Testing" + new Satellite());

        orbit(new Satellite());
    }

    public static void inFlight(FlightEnabled flier){
        flier.takeOff();
        flier.fly();
        flier.transition(FlightStages.LAUNCH);
        if (flier instanceof Trackable tracked){
            tracked.track();
        }
        flier.land();
    }

    public static void orbit(OrbitEarth flier){
        flier.takeOff();
        flier.fly();
        flier.land();
    }
}
