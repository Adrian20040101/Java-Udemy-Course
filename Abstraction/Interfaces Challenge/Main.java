package dev.lpa;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Mappable> mappables = new ArrayList<>();
        mappables.add(new Building("Town Hall", Usage.GOVERNMENT));
        mappables.add(new Building("Disco", Usage.ENTERTAINMENT));
        mappables.add(new Building("Stadium", Usage.SPORTS));
        mappables.add(new UtilityLine("Internet Provider", Utility.FIBER_OPTIC));
        mappables.add(new UtilityLine("Water line", Utility.WATER));

        //print the mappables
        for (Mappable mappable : mappables){
            Mappable.printProperties(mappable);
        }
    }
}
