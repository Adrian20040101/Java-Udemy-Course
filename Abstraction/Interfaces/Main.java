package dev.lpa;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Bird bird = new Bird();
        Animal animal = bird;
        FlightEnabled flier = bird;
        Trackable tracked = bird;

        bird.move();
        animal.move();  //these are two valid callings
//        flier.move();
//        tracked.move();   -> these are two NON-valid callings, since the method move isn't declared in the class from which they were instanced from
        flier.takeOff();
        flier.fly();
        flier.land();
        //flier.track();  -> causes a compile error, since the method 'track' has been declared only in the interface 'Trackable'
        tracked.track();  //the correct calling for that method

        System.out.println("-".repeat(30));
        System.out.println("Calling the inFlight method");
        inFlight(flier);

        System.out.println();

        System.out.println("Testing the Jet methods");
        inFlight(new Jet());  //is accepted since Jet implements FlightEnabled interface

        System.out.println();

        System.out.println("Testing the Truck methods");
        //inFlight(new Truck());  -> this is not working, because the class Truck only implements the interface Trackable, and not FlightEnabled
        new Truck().track();  //this is allowed, because Truck implements the method from the Trackable interface

        System.out.println();

        System.out.println("Trying to modify km to miles");

        double kmTraveled = 100;
        double milesTraveled = kmTraveled * FlightEnabled.KM_TO_MILES;
        System.out.printf("The truck traveled approximately %.2f miles%n%n", milesTraveled);

        //we can even use it as List types
        //in general, when using a List of interfaces, it is better to use the type List, instead of ArrayList or LinkedList etc.
        //this is because with each change, we'd have to manually change the type of the list for the specific variable
        //but with a list, we won't have to do that, as a List includes ArrayList, LinkedList and so on

        ArrayList<FlightEnabled> fliers = new ArrayList<>();
        fliers.add(bird);
        List<FlightEnabled> betterFliers = new ArrayList<>();
        betterFliers.add(bird);

        triggerFlier(fliers);
        flyFlier(fliers);
        landFlier(fliers);
    }

    public static void inFlight(FlightEnabled flier){
        flier.takeOff();
        flier.fly();
        if (flier instanceof Trackable tracked){
            tracked.track();
        }
        flier.land();
    }

    //if the parameter was declared for example as an ArrayList and we'd change the type of the array in the main method to a LinkedList for example, there would have been a compile error
    //but if we use List as shown below in the parameters of the methods, there will be no problems
    private static void triggerFlier(List<FlightEnabled> fliers){
        for (var flier : fliers){
            flier.takeOff();
        }
    }

    private static void flyFlier(List<FlightEnabled> fliers){
        for (var flier : fliers){
            flier.fly();
        }
    }

    private static void landFlier(List<FlightEnabled> fliers){
        for (var flier : fliers){
            flier.land();
        }
    }
}
