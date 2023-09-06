package dev.lpa;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        menu();
    }

    private static void addItemsToList(ArrayList<String> groceryList){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Add items to the list (comma delimited list): ");
        String[] input = scanner.nextLine().split(",");
        //groceryList.addAll(List.of(input));  -> because we need to check for duplicates, this cannot be compiled as well
        for (String element : input){
            String trimmedElement = element.trim();  //trim the element to remove whitespaces
            if (!groceryList.contains(trimmedElement)){  //check for duplicates
                groceryList.add(trimmedElement);
            }
        }
        groceryList.sort(Comparator.naturalOrder());
        System.out.println("Updated grocery list sorted alphabetically: " + groceryList + "\n");
    }

    private static void removeItemsFromList(ArrayList<String> groceryList){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Remove items from the list (comma delimited list): ");
        String[] input = scanner.nextLine().trim().split(",");
        groceryList.removeAll(List.of(input));
        groceryList.sort(Comparator.naturalOrder());
        System.out.println("Updated grocery list sorted alphabetically: " + groceryList + "\n");
    }

    private static void menu(){
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> groceryList = new ArrayList<>();
        int choice = 0;
        do {
            System.out.println("Available actions");
            System.out.println("0 - to shutdown ");
            System.out.println("1 - to add item(s) to the list (comma delimited list) ");
            System.out.println("2 - to remove item(s) from the list (comma delimited list) ");
            System.out.print("Enter a number for which action you want to do: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < 0 || choice > 2) {
                    System.out.println();
                    System.out.println("Enter a number between 0 - 2");
                    System.out.println();
                } else {
                    if (choice == 0) {
                        System.out.println("Bye Bye...\n");
                        break;
                    } else if (choice == 1) {
                        addItemsToList(groceryList);
                    } else {
                        removeItemsFromList(groceryList);
                    }
                }
            } catch (NumberFormatException e){
                System.out.println("You have typed a character instead of an integer\n");
            }
        }while(choice != 0);
    }

}
