package dev.lpa;

import java.util.ArrayList;

//using a record lets us also type in a default constructor without initialising fields for it
record GroceryItem(String name, String type, int quantity){
    public GroceryItem(String name){
        this(name, "dairy", 1);
    }
}

public class Main {
    public static void main(String[] args) {
        Object[] groceryArray = new Object[3];
        groceryArray[0] = new GroceryItem("milk");
        groceryArray[1] = new GroceryItem("apples", "fruit", 10);
        groceryArray[2] = "5 oranges";  //this is allowed if we are using an array of type Object

        //but what if we use an array of type GroceryItem?

        GroceryItem[] groceryItems = new GroceryItem[3];
        groceryItems[0] = new GroceryItem("milk");
        groceryItems[1] = new GroceryItem("apples", "fruit", 10);
        //groceryItems[2] = "5 oranges";  -> this is no longer allowed, since it is a string and not a GroceryItem

        //for a better way to store a list of objects of type GroceryItem, we can use an ArrayList

        ArrayList<GroceryItem> groceryList = new ArrayList<>();  //standard declaration using the diamond operator '<>'
        groceryList.add(new GroceryItem("yogurt"));
        //groceryList.add("banana");  -> not allowed since we need to add only objects of type GroceryItem
        groceryList.add(new GroceryItem("stuffed animal", "toy", 2));

        //we can also set the value of an element to something else or remove elements
        groceryList.set(0, new GroceryItem("greek yogurt"));
        groceryList.remove(0);
        System.out.println(groceryList);

    }
}
