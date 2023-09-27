package dev.lpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//enum Topping{CHEESE, BACON, HAM, KETCHUP, MUSTARD, MAYO, CHILLI}  -> not needed when running this project as an application
public class Burger {

    private String type;
    private double price;
    private List<String> toppings = new ArrayList<>();

    public Burger(String type, double price) {
        this.type = type;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public List<String> getToppings() {
        return toppings;
    }

    public double getToppingPrice(String topping){
        return switch(topping){
            case "Cheese", "Bacon", "Ham" -> 1.49;
            case "Chilli" -> 0.99;
            case "Mayo" -> 0.49;
            default -> 0.0;
        };
    }

    public double getBurgerPrice(){
        double totalBurgerPrice = price;
        for (String topping : toppings){
            totalBurgerPrice += getToppingPrice(topping);
        }
        return totalBurgerPrice;
    }

    public void addToppings(String[] toppings){
        if (toppings.length > 3)
            this.toppings.addAll(Arrays.asList(toppings).subList(0, 3));  //add only the first three toppings
        else
            this.toppings.addAll(Arrays.asList(toppings));
    }
}

class DeluxeBurger extends Burger{

    public DeluxeBurger() {
        super("Deluxe", 24.99);
    }

    public void addToppings(String[] toppings){
        if (toppings.length > 5)
            getToppings().addAll(Arrays.asList(toppings).subList(0, 5));  //add only the first five toppings
        else
            getToppings().addAll(Arrays.asList(toppings));
    }

    public double getBurgerPrice(){
        return getPrice();
    }
}
