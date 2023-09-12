public class Main {
    public static void main(String[] args) {

//        Item drink = new Item("drink", "water", 1.99);
//        drink.setSize("large");
//        Item.printItem(drink.getName(), drink.getAdjustedPrice());
//        Item side = new Item("side", "fries", 2.99);
//        Item.printItem(side.getName(), side.getAdjustedPrice());
//        Burger burger = new Burger("regular", 5.99);
//        burger.addToppings("bacon", "ketchup", "mustard");
//        burger.printItem();

        MealOrder meal = new MealOrder();  //this should return a default meal consisting of a regular burger, a coke and fries
        //meal.printItemizedList();

        //now add some toppings

        meal.addBurgerToppings("bacon", "cheese", "mustard");
        meal.printItemizedList();

        MealOrder secondMeal = new MealOrder("hamburger", "pepsi", "salad");
        secondMeal.addBurgerToppings("bacon", "cheese", "mustard");
        secondMeal.changeDrinkSize("large");
        secondMeal.printItemizedList();

        MealOrder deluxeMeal = new MealOrder("deluxe", "Mountain-Dew", "chilli");
        deluxeMeal.addBurgerToppings("cheese", "mayo", "ketchup",
                "salad", "garlic sauce");
        deluxeMeal.changeDrinkSize("large");
        deluxeMeal.printItemizedList();
    }
}
