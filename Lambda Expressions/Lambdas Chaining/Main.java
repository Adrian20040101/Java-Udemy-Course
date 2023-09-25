package dev.lpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        //here we'll be reviewing convenience methods. These are default methods on some of the functional
        //interfaces covered so far. The Consumer, Predicate and Function interfaces all come with these
        //methods, as does the Comparator

        String name = "John";
        Function<String, String> uCase = String::toUpperCase;
        System.out.println(uCase.apply(name));  //prints the name in all upperCase

        Function<String, String> lastName = s -> s.concat(" Stones");
        //lambda chaining to get the first and last name, using the method andThen
        Function<String, String> uCaseLastName = uCase.andThen(lastName);
        System.out.println(uCaseLastName.apply(name));

        //we can use compose to reverse the order in which operations are executed, meaning that the last name will also be printed in uppercase
        //compose method can be used on lambda expression that either target the Function or the UnaryOperator interfaces
        //BiFunction, BinaryOperator or any other function category interfaces that take a primitive, don't support the compose method
        uCaseLastName = uCase.compose(lastName);
        System.out.println(uCaseLastName.apply(name));

        //lambdas or method references, don't have to return the same type within the chain
        //it is important that the last lambda expression in the chain respects the return type of the interface
        Function<String, String[]> f0 = uCase
                .andThen(s -> s.concat(" Stones"))  //this returns a String, and the return type needs to be a String Array, but it works because the last lambda in the chain returns an array
                .andThen(s -> s.split(" "));
        System.out.println(Arrays.toString(f0.apply(name)));

        //let's explore some more examples that demonstrate how the andThen method works
        Function<String, String> f1 = uCase
                .andThen(s -> s.concat(" Stones"))  //this returns a String, and the return type needs to be a String Array, but it works because the last lambda in the chain returns an array
                .andThen(s -> s.split(" "))
                .andThen(s -> s[1].toUpperCase() + " " + s[0]);  //here we print out the last and first name in uppercase
        System.out.println(f1.apply(name));

        //works even with Integer return type
        Function<String, Integer> f2 = uCase
                .andThen(s -> s.concat(" Stones"))
                .andThen(s -> s.split(" "))
                .andThen(s -> String.join(" ", s))
                .andThen(String::length);  //finally prints the length of the whole name
        System.out.println(f2.apply(name) - 1);

        String[] names = {"Ann", "Bob", "Conor"};
        Consumer<String> s0 = s -> System.out.print(s.charAt(0));
        Consumer<String> s1 = System.out::println;
        //manipulate the Strings and print the result at the same time
        Arrays.asList(names).forEach(s0
                .andThen(s -> System.out.print(" - "))
                .andThen(s1)
        );

        //let's check out some Predicate interface logical operators like 'and', 'or' and 'negate'
        Predicate<String> p0 = s -> s.equals("JOHN");
        Predicate<String> p1 = s -> s.equalsIgnoreCase("John");
        Predicate<String> p2 = s -> s.startsWith("J");
        Predicate<String> p3 = s -> s.endsWith("m");

        //now create some test scenarios using the logical operators
        Predicate<String> test1 = p0.or(p1);
        System.out.println("Test 1 = " + test1.test(name));  //in this case both are correct, but in general for the 'or' operator it is enough if only one expression evaluates to true for the whole result to be true

        Predicate<String> test2 = p2.and(p3);
        System.out.println("Test 2 = " + test2.test(name)); //this will fail because both statements need to be true in order to have the whole result as true. In this case, only the first statement evaluates to true, since John starts with J, but it doesn't end with m

        Predicate<String> test3 = p2.and(p3).negate();  //this will flip the actual result
        System.out.println("Test 3 = " + test3.test(name));  //it originally evaluated to false, but since we added the negate() method, it flipped the result to being true

        //let's finally take a look at useful Comparator methods
        record Person(String firstName, String lastName){}

        List<Person> people = new ArrayList<>(List.of(
                new Person("Peter", "Parker"),
                new Person("Mickey", "Mouse"),
                new Person("Minnie", "Mouse"),
                new Person("Sadio", "Mane")
        ));

        //sort the list of people using lambdas
        people.sort(((o1, o2) -> o1.lastName.compareTo(o2.lastName)));  //comparing by lastName
        people.forEach(System.out::println);

        System.out.println("-".repeat(50));
        //another way to sort these people is by using the static comparing method on Comparator
        people.sort(Comparator.comparing(Person::lastName));  //the argument inside the method is a Person record field
        people.forEach(System.out::println);

        //we can even chain comparisons to achieve a multilevel sorting
        System.out.println("-".repeat(50));
        //the below call will create two separate lists, first one sorted by last name, the second one by first name
        people.sort(Comparator.comparing(Person::lastName)
                .thenComparing(Person::firstName));
        people.forEach(System.out::println);

        //also, chaining further the thenComparing method is also possible, i.e. with reversed() call
        System.out.println("-".repeat(50));
        people.sort(Comparator.comparing(Person::lastName)
                .thenComparing(Person::firstName).reversed());
        people.forEach(System.out::println);
    }
}
