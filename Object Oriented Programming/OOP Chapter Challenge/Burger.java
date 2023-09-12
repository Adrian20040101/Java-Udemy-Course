public class Burger extends Item{

    private Item topping1;
    private Item topping2;
    private Item topping3;

    public Burger(String name, double price) {
        super("Burger", name, price);
    }

    public String getName(){
        return super.getName() + " burger";
    }

    //get the price including the price of the toppings
    public double getAdjustedPrice(){
        return getPrice() +
                ((topping1 == null) ? 0 : topping1.getAdjustedPrice()) +
                ((topping2 == null) ? 0 : topping2.getAdjustedPrice()) +
                ((topping3 == null) ? 0 : topping3.getAdjustedPrice());
    }

    public double getToppingsPrice(String toppingName){
        return switch(toppingName){
            case "ketchup", "mayo", "mustard" -> 0.49;
            case "bacon", "cheese", "ham" -> 1.49;
            case "fries", "salad" -> 1.99;
            default -> 0.0;
        };
    }

    public void addToppings (String topping1, String topping2, String topping3){
        this.topping1 = new Item("topping", topping1, getToppingsPrice(topping1));
        this.topping2 = new Item("topping", topping2, getToppingsPrice(topping2));
        this.topping3 = new Item("topping", topping3, getToppingsPrice(topping3));
    }

    public void printItemizedList(){
        printItem("base burger", getPrice());
        if (topping1 != null) topping1.printItem();
        if (topping2 != null) topping2.printItem();
        if (topping3 != null) topping3.printItem();
    }

    public void printItem(){
        printItemizedList();
        System.out.println("-".repeat(30));
        super.printItem();
    }
}

//the deluxe burger subclass refers to a special meal
//it contains a burger, a drink and a side, plus 5 max toppings with no extra fee
class DeluxeBurger extends Burger{

    private Item extraTopping1;
    private Item extraTopping2;

    public DeluxeBurger(String name, double price) {
        super(name, price);
    }

    public void addToppings(String topping1, String topping2, String topping3,
                            String topping4, String topping5) {
        super.addToppings(topping1, topping2, topping3);
        extraTopping1 = new Item("topping", topping4, 0);
        extraTopping2 = new Item("topping", topping5, 0);
    }

    @Override
    public void printItemizedList() {
        super.printItemizedList();
        if (extraTopping1 != null) extraTopping1.printItem();
        if (extraTopping2 != null) extraTopping2.printItem();
    }

    @Override
    public double getToppingsPrice(String toppingName) {
        return 0;  //because we said that it requires no additional fee
    }
}
