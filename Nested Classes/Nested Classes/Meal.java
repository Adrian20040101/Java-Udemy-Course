package dev.lpa.burger;

//revisiting the Bill's Burger Challenge with a different approach

import java.util.ArrayList;
import java.util.List;

public class Meal {
    private Burger burger;
    private Item drink;
    private Item side;
    private double price = 4.99;
    private double conversionRate;

    //create a basic meal
    public Meal() {
        this(1);
    }

    public Meal(double conversionRate) {
        this.conversionRate = conversionRate;
        this.burger = new Burger("regular", "burger");
        this.drink = new Item("coke", "drink", 3.99);
        this.side = new Item("fries", "side", 1.99);
    }

    public Meal(Burger burger, Item drink, Item side, double price) {
        this.burger = burger;
        this.drink = drink;
        this.side = side;
        this.price = price;
    }

    @Override
    public String toString() {
        return "%s%n%s%n%s%n%26s$%.2f%n".formatted(burger, drink, side, "Total amount due: ",
                getTotalPrice());
    }

    public double getTotalPrice(){
        double total = (burger.price + burger.getPrice()) + drink.price + side.price;
        return Item.getPrice(total, conversionRate);
    }

    public void addToppings(String... toppings){
        burger.addToppings(toppings);
    }

    public class Item {
        private String name;
        private String type;
        protected double price;

        public Item(String name, String type) {
            this(name, type, type.equals("burger") ? Meal.this.price : 0);
        }

        public Item(String name, String type, double price) {
            this.name = name;
            this.type = type;
            this.price = price;
        }

        @Override
        public String toString() {
            return "%10s%15s $%.2f".formatted(type, name, getPrice(price, conversionRate));
        }

        public static double getPrice(double price, double rate){
            return price * rate;
        }
    }

    private enum Toppings{KETCHUP, MUSTARD, SPICY_SAUCE, CHILLI, HAM, CHEESE;

        private double getPrice(){
            return switch (this){
                case SPICY_SAUCE -> 0.99;
                case CHILLI -> 1.49;
                case HAM, CHEESE -> 1.99;
                default -> 0.0;
            };
        }
    }
    public class Burger extends Item{

        List<Item> toppings;

        public Burger(String name, String type) {
            super(name, type);
            this.toppings = new ArrayList<>();
        }

        public Burger(String name, String type, double price) {
            super(name, type, price);
            this.toppings = new ArrayList<>();
        }

        public Burger(String name, double price, List<Item> toppings) {
            super(name, "burger", price);
            this.toppings = toppings;
        }

        @Override
        public String toString() {
            StringBuilder item = new StringBuilder(super.toString());
            for (Item topping : toppings){
                item.append("\n");
                item.append(topping);
            }
            return item.toString();
        }

        public double getPrice(){
            double total = super.price;
            for (Item topping : toppings){
                total += topping.price;
            }
            return total;
        }

        public void addToppings(String... selectedToppings){
            for (String selectedTopping : selectedToppings){
                try {
                    Toppings topping = Toppings.valueOf(selectedTopping.toUpperCase());
                    toppings.add(new Item(topping.name(), "topping", topping.getPrice()));
                }catch(IllegalArgumentException iae){
                    System.out.println(selectedTopping + " is not available");
                }
            }
        }
    }
}
