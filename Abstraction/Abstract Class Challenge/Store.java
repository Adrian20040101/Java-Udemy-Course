package dev.lpa;

import java.util.ArrayList;

public class Store {

    private static ArrayList<ProductForSale> products = new ArrayList<>();

    public static void main(String[] args) {

        products.add(new Toy("Stuffed", 19.99, "Suitable for kids aged 4 - 10"));
        products.add(new Toy("Puzzle", 24.99, "Suitable for kids aged 7 - 14"));
        products.add(new KitchenTool("Blender", 59.99, "Make the best Smoothies!"));
        products.add(new Clothing("T-Shirt", 12.99, "Get that summer outfit today!"));
        listProducts();

        var order1 = new ArrayList<OrderItem>();
        addToOrder(order1, 1, 3);
        addToOrder(order1, 2, 1);
        printOrderedItems(order1);

    }

    public static void listProducts(){

        for (ProductForSale product : products){
            product.showDetails();
        }
    }

    public static void addToOrder(ArrayList<OrderItem> order, int productIndex, int quantity){
       order.add(new OrderItem(quantity, products.get(productIndex)));
    }

    public static void printOrderedItems(ArrayList<OrderItem> order){
        System.out.println("------------ Order Summary ------------");
        double totalPrice = 0;
        for (int i = 0; i < order.size(); i++){
            System.out.println("Product [" + (i + 1) + "]");
            order.get(i).getProduct().pricedLineItem(order.get(i).getQuantity());
            order.get(i).getProduct().showDetails();
            totalPrice += order.get(i).getProduct().getSalesPrice(order.get(i).getQuantity());
        }
        System.out.println("Total amount due: $" + totalPrice);
    }

}
