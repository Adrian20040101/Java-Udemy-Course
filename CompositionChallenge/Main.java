public class Main {
    public static void main(String[] args) {

        Refrigerator refrigerator = new Refrigerator(false);
        CoffeeMaker coffeeMaker = new CoffeeMaker(false);
        DishWasher dishWasher = new DishWasher(false);
        SmartKitchen kitchen = new SmartKitchen(refrigerator, coffeeMaker, dishWasher);

        kitchen.getBrewMaster().brewCoffee();
        kitchen.getDishWasher().doDishes();
        kitchen.getIceBox().orderFood();

        kitchen.setKitchenState(true, false, true);
        kitchen.doKitchenWork();
    }
}
