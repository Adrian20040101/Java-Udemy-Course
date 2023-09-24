package dev.lpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

class PlainOld{
    private int id;
    private static int LAST_ID = 1;

    public PlainOld() {
        this.id = LAST_ID++;
        System.out.println("Creating a PlainOld object with id = " + id);
    }
}

public class Main {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>(List.of(
                "Anna", "Bob", "Chuck", "Dave"
        ));

        list.forEach(System.out::println);  //method reference for printing the items from the list

        calculator((a, b) -> a + b, 12, 57);  //standard lambda declaration
        calculator(Integer::sum, 12, 57);  //method reference declaration

        //calculator method references work the same for Double too, i.e.
        calculator(Double::sum, 12.5, 56.5);

        Supplier<PlainOld> reference1 = () -> new PlainOld();  //although we are calling the PlainOld constructor, this is not going to display the message from the constructor, because lambda expressions are not invoked at this point
        Supplier<PlainOld> reference2 = PlainOld::new;  //constructor reference using new as the method

        //to get the message from the constructor printed, we have to call the get method on the reference

        reference2.get();

        //the constructor reference is especially useful, when creating an array of objects
        System.out.println("Getting Array of Objects");
        PlainOld[] pojoArray = seedArray(PlainOld::new, 10);  //creating 10 new PlainOld objects and assigning them to the pojoArray

        //pass strings to the calculator method
        calculator((string1, string2) -> string1 + string2, "Hello ", "World");
        calculator((string1, string2) -> string1.concat(string2), "Hello ", "World"); //alternative
        calculator(String::concat, "Hello ", "World"); //method reference

        BinaryOperator<String> b1 = String::concat; //that's effectively what's being used when specifying String::concat
        BiFunction<String, String, String> b2 = String::concat; //alternative
        //UnaryOperator<String> u1 = (s1, s1) -> s1.concat(s2);  -> invalid syntax, since it accepts one argument and two are needed for a concatenation
        //UnaryOperator<String> u1 = String::concat;  -> also invalid for the same reason
        //but, we can use the UnaryOperator functional interface when for example converting a string to uppercase
        UnaryOperator<String> u1 = String::toUpperCase;

        //check the results out - first two lines concatenate the two strings passed in, and the third one converts the string to uppercase
        System.out.println(b1.apply("Hello ", "World"));
        System.out.println(b2.apply("Hello ", "World"));
        System.out.println(u1.apply("Hello "));

        //let's check out now the method on the String called "transform"
        //this method takes a Function with a String type, as an argument, and returns an object (not necessarily a string)
        String result = "Hello".transform(u1);
        System.out.println("Result = " + result); //in this case, it will apply the function implemented on u1 to the string "Hello", making it uppercase in our example

        result = result.transform(String::toLowerCase);
        System.out.println("Result = " + result); //this will take the result string and make it all lowercase

        //this isn't limited to only strings
        Function<String, Boolean> string = String::isEmpty;  //this function takes a string as parameter and returns a boolean, in our case true or false whether result is empty or not
        boolean resultBool = result.transform(string);
        //boolean resultBool = result.transform(String::isEmpty);  -> alternative one-liner
        System.out.println("Result = " + resultBool);

    }

    private static <T> void calculator(BinaryOperator<T> function, T value1, T value2){
        T result = function.apply(value1, value2);
        System.out.println("Result of the operation = " + result);
    }

    private static PlainOld[] seedArray(Supplier<PlainOld> reference, int count){
        PlainOld[] newArray = new PlainOld[count];
        Arrays.setAll(newArray, (i) -> reference.get());
        return newArray;
    }
}
