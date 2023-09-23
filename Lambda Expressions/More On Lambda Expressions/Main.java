package dev.lpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        List<String> natoAlphabet = new ArrayList<>(List.of("alpha", "bravo", "charlie", "delta"));

        //traditional way to display the content of natoAlphabet list
        for (int i = 0; i < natoAlphabet.size(); i++){
            System.out.println(natoAlphabet.get(i));
        }

        System.out.println("-".repeat(20));

        //enhanced for loop method
        for (String word : natoAlphabet){
            System.out.println(word);
        }

        System.out.println("-".repeat(20));

        //enhanced method using lambdas
        natoAlphabet.forEach((word) -> System.out.println(word));

        System.out.println("-".repeat(20));

        //add some statements in the lambda part
        String prefix = "NATO";
        natoAlphabet.forEach((var word) -> {   //not necessary to include the var keyword
            char first = word.charAt(0);
            System.out.println(prefix + " " + word + " stands for " + first);
        });

        System.out.println("-".repeat(20));
        System.out.println("Testing the calculate method:\n");

        //test the calculate method
        int result1 = calculate((number1, number2) -> number1 + number2, 5, 8);
        var result2 = calculate((number1, number2) -> number1 / number2, 10.0, 1.25);
        //calculate even works with String. In fact, calculate, as any generic method, doesn't accept primitive types. So when we pass integers or doubles etc. we are passing the wrapper class for that primitive type and let Java do the autoboxing
        var result3 = calculate((var1, var2) -> var1 + var2, "Java ", "is fun");

        System.out.println("-".repeat(20));
        //testing Consumer functional interface and performing some actions on the list
        System.out.println("Testing the Consumer Functional Interface:");
        System.out.println();

        //creating some coordinates to demonstrate the Consumer Java interface
        var coords = new ArrayList<>(Arrays.asList(
                new double[]{49.233, 56.383},
                new double[]{12.545, -34.234},
                new double[]{-108.323, 90.324}
        ));

        //print these coords
        coords.forEach(coord -> System.out.println(Arrays.toString(coord)));

        //create a nice format for the latitude and longitude
        BiConsumer<Double, Double> p1 = (lat, lon) -> System.out.printf("lat: %.3f lon: %.3f%n", lat, lon);
        var firstPoint = coords.get(0);
        //display the nicely formatted lat and lon
        processPoint(firstPoint[0], firstPoint[1], p1);
        System.out.println("-".repeat(20));
        //display all the coordinates in the same way
        coords.forEach(s -> processPoint(s[0], s[1], p1));

        //we can even use nested lambda expressions. Although it is going to be harder to read the code, it definitely is an option and you'll have to write less code
        coords.forEach(s -> processPoint(s[0], s[1],
                (lat, lon) -> System.out.printf("lat: %.3f lon: %.3f%n", lat, lon)));

        //now testing Predicate functional interface and performing some actions on the list
        System.out.println("-".repeat(20));
        System.out.println("Testing the Predicate Functional Interface:");
        System.out.println();
        natoAlphabet.removeIf(s -> s.equalsIgnoreCase("delta"));  //removes delta from natoAlphabet
        natoAlphabet.forEach(s -> System.out.println(s));

        //next, let's create some additional scenarios
        natoAlphabet.addAll(List.of("echo", "each", "easy"));
        natoAlphabet.removeIf(s -> s.startsWith("ea"));  //removes all items starting with "ea", in our case "each" and "easy"
        natoAlphabet.forEach(s -> System.out.println(s));  //should print the alphabet without "delta", since we deleted it, but add "echo"

        //now testing Function functional interface and performing some actions on the list
        System.out.println("-".repeat(20));
        System.out.println("Testing the Function Functional Interface:");
        System.out.println();

        natoAlphabet.replaceAll(s -> s.charAt(0) + " - " + s);  //this replaces all lines with this newly formatted line
        natoAlphabet.forEach(s -> System.out.println(s));

        String[] emptyStrings = new String[10];
        System.out.println(Arrays.toString(emptyStrings)); //it will print out 10 null values
        Arrays.fill(emptyStrings, "");   //filling the String array with empty strings
        System.out.println(Arrays.toString(emptyStrings));
        Arrays.setAll(emptyStrings, (i) -> "" + (i + 1) + ". ");
        System.out.println(Arrays.toString(emptyStrings)); //it will print out 1., 2., 3. etc. to 10.

        //let's make the first three numbers in the array as a String, i.e. one, two, three etc.

        Arrays.setAll(emptyStrings, (i) -> "" + (i + 1) + ". " + switch (i){
            case 0 -> "one";
            case 1 -> "two";
            case 2 -> "three";
            //etc.
            default -> "";
        });
        System.out.println(Arrays.toString(emptyStrings));

        //now testing Supplier functional interface and performing some actions on the list
        System.out.println("-".repeat(20));
        System.out.println("Testing the Supplier Functional Interface:");
        System.out.println();

        String[] names = {"Ann", "Bob", "Charlie", "David", "Ed", "Fred", "George"};
        String[] randomValues = randomlySelectedValues(15, names,
                () -> new Random().nextInt(0, names.length));

        System.out.println(Arrays.toString(randomValues));

    }

//    public static <T> T calculate(Operation<T> function, T value1, T value2){
//        T result = function.operate(value1, value2);
//        System.out.println("Result = " + result);
//        return result;
//    }

    //using some of Java's built-in functional interfaces
    //in this case, the BinaryOperator, which does the same thing as our self defined functional interface. Note that method 'apply' must be used
    public static <T> T calculate(BinaryOperator<T> function, T value1, T value2){
        T result = function.apply(value1, value2);
        System.out.println("Result = " + result);
        return result;
    }

    //next, let's look at one of the four categories of Java's functional interfaces - the Consumer/BiConsumer
    public static <T> void processPoint(T t1, T t2, BiConsumer<T, T> consumer){
        consumer.accept(t1, t2);
    }

    //method used to demonstrate the Supplier functional interface
    public static String[] randomlySelectedValues(int count, String[] values, Supplier<Integer> s){
        String[] selectedValues = new String[count];
        for (int i = 0; i < count; i++){
            selectedValues[i] = values[s.get()];  //we populate the local array with values from the values array, however, the index is taken from the supplier argument, the lambda expression in other words, that gets passed
        }
        return selectedValues;
    }


}
