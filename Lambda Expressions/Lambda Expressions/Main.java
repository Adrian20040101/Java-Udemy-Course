package dev.lpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

    //create a local record
    record Person(String firstName, String lastName){
        @Override
        public String toString() {
            return firstName + " " + lastName;
        }
    }
    public static void main(String[] args) {

        List<Person> people = new ArrayList<>(Arrays.asList(
                new Person("John", "Cena"),
                new Person("Nazario", "Ronaldo"),
                new Person("Leo", "Messi"),
                new Person("Cristiano", "Ronaldo"),
                new Person("Eden", "Hazard")
        ));

        //need a way to sort them by last name
        //first, we are doing it using an anonymous class
        var comparator = new Comparator<Person>() {

            @Override
            public int compare(Person o1, Person o2) {
                return o1.lastName.compareTo(o2.lastName);
            }
        };

        //now do it using a lambda expression
        people.sort(((o1, o2) -> o1.lastName.compareTo(o2.lastName)));

        //now lets see if we want to add another interface, that also extends the Comparator interface
        interface EnhancedComparator<T> extends Comparator<T>{
            int secondLevel(T o1, T o2);
        }

        //create first another anonymous class for this interface
        var enhancedComparator = new EnhancedComparator<Person>(){

            @Override
            public int compare(Person o1, Person o2) {
                int result = o1.lastName.compareTo(o2.lastName);
                //this executes the second level only if last names match
                return (result == 0 ? secondLevel(o1, o2) : result);
            }

            //second level refers to comparing the first names of people that share the same last name
            @Override
            public int secondLevel(Person o1, Person o2) {
                return o1.firstName.compareTo(o2.firstName);
            }
        };

        people.sort(enhancedComparator);
        //but if we try to sort the list using the enhanced comparator, we'll get an error because there are two abstract methods and only one is allowed, meaning that the newly created interface is no longer a functional interface
        System.out.println(people);
    }
}
