package dev.lpa;

public class OrderItem {

    private int quantity;
    private ProductForSale product;

    public OrderItem(int quantity, ProductForSale product) {
        this.quantity = quantity;
        this.product = product;
    }

    public ProductForSale getProduct() {
        return product;
    }

    public int getQuantity(){
        return quantity;
    }
}
