package dev.lpa;

//we can further customize an enum by adding methods for example.
//if we decide to further customize the enum, then we must follow the list of enumerated values with a ';'
public enum Topping {

    BACON, CHEESE, PICKLES, HAM, TOMATO, KETCHUP, MUSTARD;

    public double getPrice(){
        return switch (this){  //we can also use the 'this' keyword when working with switch statements
            case BACON -> 1.0;
            case CHEESE -> 1.5;
            default -> 0.5;
        };
    }
}
