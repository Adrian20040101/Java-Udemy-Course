package dev.lpa;

public class MealOrder {

    private Burger burger;
    private Item drink;
    private Item side;

    //default meal
    public MealOrder(){
        this.burger = new Burger("Regular", 4.99);
        this.drink = new Item("Drink", "Coke", "medium", 1.99);
        this.side = new Item("Side", "Fries", "medium", 0.99);
    }

    //user chosen meal
    public MealOrder(Burger burger, Item drink, Item side) {
        this.burger = burger;
        this.drink = drink;
        this.side = side;
    }

    //deluxe meal - toppings, drinks and sides are all free included in the meal
    public MealOrder(DeluxeBurger deluxeBurger) {
        this.burger = deluxeBurger;
        this.drink = new Item("drink", "Lemonade", "large", 0.0);
        this.side = new Item("side", "Mixed Salad", "large", 0.0);
    }

    public double getTotalPrice(){
        if (burger instanceof DeluxeBurger)
            return burger.getBurgerPrice() + drink.getBasePrice() + side.getBasePrice();
        else
            return burger.getBurgerPrice() + drink.adjustPrice(drink.getSize()) + side.adjustPrice(side.getSize());
    }

    public void addBurgerToppings(String[] toppings){
        burger.addToppings(toppings);
    }

    public void changeDrinkSize(String newSize){
        drink.setSize(newSize);
    }

    @Override
    public String toString() {
        return """
                %s Burger:
                      Price: $%.2f
                      Extra Toppings: %s
                      Burger Total: $%.2f
                ---------------------------------
                Drink:
                      Name: %s
                      Size: %s
                      Price: $%.2f
                ---------------------------------
                Side:
                      Name: %s
                      Size: %s
                      Price: $%.2f
                ---------------------------------
                Total due amount: $%.2f
                ---------------------------------""".formatted(burger.getType(),
                burger.getPrice(), burger.getToppings().isEmpty() ? "none" : burger.getToppings(),
                burger.getBurgerPrice(),
                drink.getName(), drink.getSize(),
                burger instanceof DeluxeBurger ? 0.0 : drink.adjustPrice(drink.getSize()),
                side.getName(), side.getSize(),
                burger instanceof DeluxeBurger ? 0.0 :side.adjustPrice(side.getSize()),
                getTotalPrice());
    }
}
