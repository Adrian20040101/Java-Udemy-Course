public class SmartKitchen {

    private Refrigerator iceBox;
    private CoffeeMaker brewMaster;
    private DishWasher dishWasher;

    public SmartKitchen(Refrigerator iceBox, CoffeeMaker brewMaster, DishWasher dishWasher) {
        this.iceBox = iceBox;
        this.brewMaster = brewMaster;
        this.dishWasher = dishWasher;
    }

    public Refrigerator getIceBox() {
        return iceBox;
    }

    public CoffeeMaker getBrewMaster() {
        return brewMaster;
    }

    public DishWasher getDishWasher() {
        return dishWasher;
    }

    public void setKitchenState(boolean coffeeFlag, boolean refrigeratorFlag, boolean dishWasherFlag){
        brewMaster.setHasWorkToDo(coffeeFlag);
        iceBox.setHasWorkToDo(refrigeratorFlag);
        dishWasher.setHasWorkToDo(dishWasherFlag);
    }

    public void addWater(){
        brewMaster.brewCoffee();
    }

    public void loadDishWasher(){
        dishWasher.doDishes();
    }

    public void pourMilk(){
        iceBox.orderFood();
    }

    public void doKitchenWork(){
        addWater();
        loadDishWasher();
        pourMilk();
    }
}

class Refrigerator{

    private boolean hasWorkToDo;

    public Refrigerator(boolean hasWorkToDo){
        this.hasWorkToDo = hasWorkToDo;
    }

    public void setHasWorkToDo(boolean hasWorkToDo) {
        this.hasWorkToDo = hasWorkToDo;
    }

    public void orderFood(){
        if (!hasWorkToDo)
            System.out.println("Food is being ordered...");
        else
            System.out.println("It already is working on that");

        hasWorkToDo = true;
    }
}

class DishWasher{

    private boolean hasWorkToDo;
    public DishWasher(boolean hasWorkToDo){
        this.hasWorkToDo = hasWorkToDo;
    }

    public void setHasWorkToDo(boolean hasWorkToDo) {
        this.hasWorkToDo = hasWorkToDo;
    }

    public void doDishes(){
        if (!hasWorkToDo)
            System.out.println("Dishes are being washed...");
        else
            System.out.println("It already is working on that");

        hasWorkToDo = true;
    }
}

class CoffeeMaker{

    private boolean hasWorkToDo;
    public CoffeeMaker(boolean hasWorkToDo){
        this.hasWorkToDo = hasWorkToDo;
    }

    public void setHasWorkToDo(boolean hasWorkToDo) {
        this.hasWorkToDo = hasWorkToDo;
    }

    public void brewCoffee(){
        if (!hasWorkToDo)
            System.out.println("Coffee is being prepared...");
        else
            System.out.println("It already is working on that");

        hasWorkToDo = true;
    }

}