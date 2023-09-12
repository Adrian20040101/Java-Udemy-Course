public class MealOrder {

    private Burger burger;
    private Item drink;
    private Item side;

    public MealOrder(String burgerType, String drinkType, String sideType){
        if (burgerType.equalsIgnoreCase("deluxe")){
            this.burger = new DeluxeBurger("Bill's Speciality", 16.99);
        } else {
            this.burger = new Burger(burgerType, 5.99);
        }
        this.drink = new Item("drink", "pepsi", 2.99);
        this.side = new Item("side", "fries", 1.49);
    }

    public MealOrder(){
        this("regular", "coke", "fries");
    }

    public double getTotalPrice(){
        if (burger instanceof DeluxeBurger) return burger.getAdjustedPrice();
        return burger.getAdjustedPrice() + drink.getAdjustedPrice() + side.getAdjustedPrice();
    }

    public void printItemizedList(){
        burger.printItem();
        if (burger instanceof DeluxeBurger){
            Item.printItem(drink.getName(), 0);
            Item.printItem(side.getName(), 0);
        } else {
            drink.printItem();
            side.printItem();
        }
        System.out.println("-".repeat(30));
        Item.printItem("Total amount due: ", getTotalPrice());
    }

    //customization methods to be able to add toppings or change the drink size

    public void addBurgerToppings(String topping1, String topping2, String topping3){
        burger.addToppings(topping1, topping2, topping3);
    }

    public void addBurgerToppings(String topping1, String topping2, String topping3,
                                  String topping4, String topping5){
        if (burger instanceof DeluxeBurger){  //could have also used a binding variable instead of casting
            ((DeluxeBurger) burger).addToppings(topping1, topping2, topping3, topping4, topping5);
        } else {
            burger.addToppings(topping1, topping2, topping3);
        }
    }

    public void changeDrinkSize(String size){
        drink.setSize(size);
    }
}
