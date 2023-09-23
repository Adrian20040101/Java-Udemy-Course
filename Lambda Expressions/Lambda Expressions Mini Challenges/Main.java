package dev.lpa;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {
        //Lambda Mini Challenge 1
        System.out.println("First Lambda Mini Challenge");
        System.out.println("-".repeat(30));
        Consumer<String> printThePartsLambda1 = (s -> {
            String[] parts = s.split(" ");
            for (String part : parts) {
                System.out.println(part);
            }
        });
        printThePartsLambda1.accept("This is an example sentence");

        //alternative solution
        Consumer<String> printThePartsLambda2 = (s -> {
            String[] parts = s.split(" ");
            Arrays.asList(parts).forEach(word -> System.out.println(word));
        });
        printThePartsLambda2.accept("This is an example sentence");

        //best lambda solution for this problem - written in a single line of code
        Consumer<String> printThePartsLambda3 = (s ->
                Arrays.asList(s.split(" ")).forEach(word -> System.out.println(word)));
        printThePartsLambda3.accept("This is an example sentence");

        //Lambda Mini Challenge 2
        System.out.println();
        System.out.println("Second Lambda Mini Challenge");
        System.out.println("-".repeat(30));

        UnaryOperator<String> everySecondChar = (source -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < source.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(source.charAt(i));
                }
            }
            return returnVal.toString();
        });

        System.out.println(everySecondChar.apply("1234567890"));

        //Lambda Mini Challenge 3
        System.out.println();
        System.out.println("Third Lambda Mini Challenge");
        System.out.println("-".repeat(30));

        System.out.println("This was just printing the result that has been returned in previous " +
                "Challenge. Already done that");

        //Lambda Mini Challenge 4
        System.out.println();
        System.out.println("Fourth Lambda Mini Challenge");
        System.out.println("-".repeat(30));

        System.out.println("Another way to get the same result using a helper method");
        System.out.println(everySecondCharacter(everySecondChar, "1234567890"));

        //Lambda Mini Challenge 5
        System.out.println();
        System.out.println("Fifth Lambda Mini Challenge");
        System.out.println("-".repeat(30));

        System.out.println("This was just printing the result that has been returned in previous " +
                "Challenge. Already done that");

        //Lambda Mini Challenge 6
        System.out.println();
        System.out.println("Sixth Lambda Mini Challenge");
        System.out.println("-".repeat(30));

        Supplier<String> iLoveJava = () -> "I love Java";
        //return is implied in first example, but can also be written like this for more clarity
        Supplier<String> iLoveJava2 = () -> {return "I love Java";};

        //Lambda Mini Challenge 7
        System.out.println();
        System.out.println("Seventh Lambda Mini Challenge");
        System.out.println("-".repeat(30));

        var supplierResult = iLoveJava;
        System.out.println(supplierResult.get());
        System.out.println(iLoveJava2.get());  //same result

    }

    //helper method for Challenge 4
    public static String everySecondCharacter(UnaryOperator<String> source, String string){
        return source.apply(string);

    }
}