package dev.lpa;

public class Item {

    private String type;
    private String name;
    private String size;
    private double basePrice;

    public Item(String type, String name, String size, double price) {
        this.type = type;
        this.name = name;
        this.size = size;
        this.basePrice = price;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public String getSize() {
        return size;
    }

    //setter for size, since the drink size is changeable
    public void setSize(String size) {
        this.size = size;
    }

    public double adjustPrice(String size){
        return switch(size){
            case "small" -> basePrice - 0.99;
            case "large" -> basePrice + 0.49;
            default -> basePrice;
        };
    }
}
