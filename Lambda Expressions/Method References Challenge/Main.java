package dev.lpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

record Person(String first){
    public String last(String s){
        return first + " " + s.substring(0, s.indexOf(" "));
    }
}

public class Main {
    public static void main(String[] args) {

        String[] names = {"Ann", "Bob", "Charlie", "Hannah"};
        Person person = new Person("Tim");
        List<Function<String, String>> operations = new ArrayList<>(List.of(
                String::toUpperCase,
                s -> s + " " + getRandomChar(),
                s -> s + " " + reverseName(s.split(" ")[0]),
                s -> "Hello " + s,
                String::toLowerCase,
                s -> s + " Location: " + appendLocation("Anonymous Street"),
                String::valueOf,
                person::last,  //person is instance, last is method, check out Java Concepts folder for more information on this
                (new Person("Mary"))::last  //not something very useful but helps understand method reference better
        ));

        applyFunction(names, operations);
    }

    public static void applyFunction(String[] array, List<Function<String, String>> operations){
        List<String> arrayCopy = Arrays.asList(array);
        for (Function<String, String> operation : operations){
            arrayCopy.replaceAll(s -> s.transform(operation));
            System.out.println(Arrays.toString(array));
        }
    }

    public static String getRandomChar(){
        return ((char) (new Random().nextInt(65, 91)) + ".");
    }

    public static String reverseName(String name){
        return new StringBuilder(name).reverse().toString();
    }

    public static String appendLocation(String location){
        return location;
    }
}
