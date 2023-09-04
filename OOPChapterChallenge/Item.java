//this class includes the drink and the side

public class Item {

    private String type;
    private String name;
    private String size = "medium";
    private double price;

    public Item(String type, String name, double price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        if (type.equals("drink") || type.equals("side"))
            return size + " " + name;
        return name;
    }

    public double getPrice() {
        return price;  //returns the price of a medium-sized item
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getAdjustedPrice(){
        return switch(size.toLowerCase()){
            case "small" -> getPrice() - 1;
            case "large" -> getPrice() + 1;
            default -> getPrice();
        };
    }

    public static void printItem(String name, double price){
        System.out.printf("%s : $%.2f%n", name, price);
    }

    public void printItem(){
        printItem(getName(), getAdjustedPrice());
    }

}
