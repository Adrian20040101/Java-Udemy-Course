package dev.lpa;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Mappable> pointsOfInterest = new ArrayList<>();
        pointsOfInterest.add(new Building("Sydney Opera House", BuildingUsage.ENTERTAINMENT));
        pointsOfInterest.add(new Building("Camp Nou", BuildingUsage.SPORT));
        pointsOfInterest.add(new Building("Babes Bolyai University", BuildingUsage.EDUCATION));
        pointsOfInterest.add(new UtilityLine("Kogalniceanu Str.", LineUsage.ELECTRICAL));
        pointsOfInterest.add(new UtilityLine("Constanta Str.", LineUsage.FIBER_OPTIC));

        for (Mappable pointOfInterest : pointsOfInterest){
            Mappable.printData(pointOfInterest);
        }
    }
}
