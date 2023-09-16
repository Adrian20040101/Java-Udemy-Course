package dev.lpa;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Park park1 = new Park("Yosemite", 34.232, 55.213);
        Park park2 = new Park("Yellowstone", 57.232, 51.213);
        Park park3 = new Park("National Park",14.212, 85.123);
        River river1 = new River("Mississippi",
                List.of(12.34, 34.21, 34.12, 12.32, 43.21, 34.54));
        River river2 = new River("Niagara Falls",
                List.of(12.34, 34.21, 34.12, 12.32, 43.21, 34.54));
        River river3 = new River("Amazon",
                List.of(12.34, 34.21, 34.12, 12.32, 43.21, 34.54));
        Layer<Park> parks = new Layer<>();
        parks.addElement(park1);
        parks.addElements(park2, park3);
        parks.addElement(new Park("Central Park",23.456, 32.135));
        parks.renderLayer();

        Layer<River> rivers = new Layer<>();
        rivers.addElement(river1);
        rivers.addElement(river2);
        rivers.addElement(river3);
        rivers.addElement(new River("Nile", List.of(12.34, 34.21, 34.12, 12.32, 43.21, 34.54)));
        rivers.renderLayer();
    }
}
