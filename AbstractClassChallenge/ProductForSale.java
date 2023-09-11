package dev.lpa;

public abstract class ProductForSale{

    private String type;
    private double price;
    private String description;

    public ProductForSale(String type, double price, String description) {
        this.type = type;
        this.price = price;
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public double getSalesPrice(int quantity){
        return quantity * price;
    }

    public void pricedLineItem(int quantity){
        System.out.println("Priced Item: " + quantity + " pcs at $" + price + " each");
        System.out.println("-".repeat(30));
    }

    public abstract void showDetails();

    public String getExplicitType(){
        return getClass().getSimpleName() + " (" + type + ")";
    }
}
