package dev.lpa.burger;

public class BurgerStore {
    public static void main(String[] args) {
        Meal regularMeal = new Meal();
        System.out.println(regularMeal);
        regularMeal.addToppings("HAM", "KETCHUP", "CHEDDAR", "CHILLI");

        Meal romanianRegularMeal = new Meal(4.6);
        System.out.println(romanianRegularMeal);



    }
}
