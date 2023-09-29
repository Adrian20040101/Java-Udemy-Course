package dev.lpa;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        MealOrder order1 = new MealOrder(
//                new DeluxeBurger()
//        );
//        order1.addBurgerToppings(Topping.KETCHUP, Topping.CHEESE, Topping.HAM, Topping.CHILLI, Topping.MAYO, Topping.MUSTARD);
//        order1.changeDrinkSize("small");
//        System.out.println(order1);
//
//        MealOrder order2 = new MealOrder(
//                new Burger("Regular", 8.99),
//                new Item("Drink", "Coke", "medium", 3.99),
//                new Item("Side", "Fries", "large", 1.99)
//        );
//        order2.addBurgerToppings(Topping.KETCHUP, Topping.CHEESE, Topping.HAM, Topping.CHILLI, Topping.MAYO, Topping.MUSTARD);
//        order2.changeDrinkSize("large");
//        System.out.println(order2);
//
//        MealOrder order3 = new MealOrder();
//        order3.addBurgerToppings(Topping.KETCHUP, Topping.CHEESE, Topping.HAM, Topping.CHILLI, Topping.MAYO, Topping.MUSTARD);
//        order3.changeDrinkSize("small");
//        System.out.println(order3);

        composeMeal();

    }

    public static void composeMeal(){
        System.out.println("-".repeat(20) + " Bill's Burger " + "-".repeat(20));
        System.out.print("Choose the type of meal you'd like to add (regular/deluxe/default): ");
        Scanner scanner = new Scanner(System.in);
        String mealType = scanner.nextLine();
        if (mealType.equalsIgnoreCase("deluxe")) {
            MealOrder deluxeMeal = new MealOrder(new DeluxeBurger());
            System.out.print("Would you like to add toppings to the Burger? (max 5)\n" +
                    "Here are the available options: Cheese, Bacon, Ham, Ketchup, Chilli, Mayo, Mustard ");
            if (scanner.nextLine().equalsIgnoreCase("yes")) {
                System.out.print("Choose the toppings you'd like to add, delimited by a comma: ");
                String choice = scanner.nextLine();
                String[] selectedToppings = choice.trim().split(",");
                deluxeMeal.addBurgerToppings(selectedToppings);
            }

            System.out.print("Would you like to change the default size for the drink on this menu? ");
            if (scanner.nextLine().equalsIgnoreCase("yes")){
                System.out.print("Select the new size for the drink in your order: ");
                String choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("small") ||
                    choice.equalsIgnoreCase("medium") ||
                    choice.equalsIgnoreCase("large")){
                    deluxeMeal.changeDrinkSize(choice);
                }
            }
            System.out.println(deluxeMeal);
        } else if(mealType.equalsIgnoreCase("regular")){
            System.out.print("Enter the drink you'd like to add to the meal: ");
            String drinkName = scanner.nextLine();
            System.out.print("Enter the size for the selected drink: ");
            String drinkSize = scanner.nextLine();
            System.out.print("Enter the side you'd like to add to the meal: ");
            String sideName = scanner.nextLine();
            System.out.print("Enter the size for the selected side: ");
            String sideSize = scanner.nextLine();

            MealOrder regularMeal = new MealOrder(
                    new Burger("Regular", 8.99),
                    new Item("Drink", drinkName, drinkSize, 1.99),
                    new Item("Side", sideName, sideSize, 0.99)
            );

            System.out.print("Would you like to add toppings to the Burger? (max 3)\n" +
                    "Here are the available options: Cheese, Bacon, Ham, Ketchup, Chilli, Mayo, Mustard ");
            if (scanner.nextLine().equalsIgnoreCase("yes")) {
                System.out.print("Choose the toppings you'd like to add, delimited by a comma: ");
                String choice = scanner.nextLine();
                String[] selectedToppings = choice.trim().split(",");
                regularMeal.addBurgerToppings(selectedToppings);
            }

            System.out.print("Would you like to change the size for the drink on this menu? ");
            if (scanner.nextLine().equalsIgnoreCase("yes")) {
                System.out.print("Select the new size for the drink in your order: ");
                String choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("small") ||
                        choice.equalsIgnoreCase("medium") ||
                        choice.equalsIgnoreCase("large")) {
                    regularMeal.changeDrinkSize(choice);
                }
            }
            System.out.println(regularMeal);
        } else if (mealType.equalsIgnoreCase("default")){
            MealOrder defaultMeal = new MealOrder();
            System.out.print("Would you like to add toppings to the Burger? (max 3)\n" +
                    "Here are the available options: Cheese, Bacon, Ham, Ketchup, Chilli, Mayo, Mustard ");
            if (scanner.nextLine().equalsIgnoreCase("yes")) {
                System.out.print("Choose the toppings you'd like to add, delimited by a comma: ");
                String choice = scanner.nextLine();
                String[] selectedToppings = choice.trim().split(",");
                defaultMeal.addBurgerToppings(selectedToppings);
            }

            System.out.print("Would you like to change the size for the drink on this menu? ");
            if (scanner.nextLine().equalsIgnoreCase("yes")) {
                System.out.print("Select the new size for the drink in your order: ");
                String choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("small") ||
                        choice.equalsIgnoreCase("medium") ||
                        choice.equalsIgnoreCase("large")) {
                    defaultMeal.changeDrinkSize(choice);
                }
            }
            System.out.println(defaultMeal);
        }
    }
}
