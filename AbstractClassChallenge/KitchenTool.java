package dev.lpa;

public class KitchenTool extends ProductForSale{
    public KitchenTool(String type, double price, String description) {
        super(type, price, description);
    }

    public void showDetails() {
        System.out.println("Displaying Product Details");
        System.out.println("Type: " + getExplicitType());
        System.out.println("Description: " + getDescription());
        System.out.println("Price: $" + getPrice());
        System.out.println("-".repeat(30));
    }
}
