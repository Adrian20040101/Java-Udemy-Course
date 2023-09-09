package dev.lpa;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        var roadTrip = new LinkedList<>(List.of(new Town("Adelaide", 1374),
                new Town("Alice Springs", 2771),
                new Town("Brisbane", 917),
                new Town("Darwin", 3972),
                new Town("Melbourne", 877),
                new Town("Perth", 3923)));

        var iterator = roadTrip.listIterator();
        menu(roadTrip, iterator);
    }

    public static void moveForward(ListIterator<Town> iterator){
        if (iterator.hasNext()){
            System.out.println("You have reached " + iterator.next());
        } else {
            System.out.println("You have reached the end of the trip");
        }
    }

    public static void moveBackward(ListIterator<Town> iterator){
        if (iterator.hasPrevious()){
            System.out.println("You have reached " + iterator.previous());
        } else {
            System.out.println("You are back at the starting point");
        }
    }

    public static void printRoadTrip(LinkedList<Town> list){
        var iterator = list.listIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    public static void menu(LinkedList<Town> roadTrip, ListIterator<Town> iterator){
        Scanner scanner = new Scanner(System.in);
        String choice;
        do {
            System.out.println("Available actions, select the word or the Capital letter corresponding to it");
            System.out.println("(F)orward");
            System.out.println("(B)ackward");
            System.out.println("(L)ist Places");
            System.out.println("(M)enu");
            System.out.println("(Q)uit");
            System.out.print("Choose what you would like to do: ");

            choice = scanner.nextLine();
            if (choice.equals("Forward")) moveForward(iterator);
            else if (choice.equals("Backward")) moveBackward(iterator);
            else if (choice.equals("List")) printRoadTrip(roadTrip);
            else if (choice.equals("Menu")) menu(roadTrip, iterator);
            else if (choice.equals("Quit")) break;
            else System.out.println("Invalid option");

        }while(!choice.contains("Quit"));
    }
}

class Town {
    private String name;
    private int distanceFromSydney;

    public Town(String name, int distanceFromSydney){
        this.name = name;
        this.distanceFromSydney = distanceFromSydney;
    }

    @Override
    public String toString() {
        return name + ", which is " + distanceFromSydney + " km away from Sydney";
    }
}