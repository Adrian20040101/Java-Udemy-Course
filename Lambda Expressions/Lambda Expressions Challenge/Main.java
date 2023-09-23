package dev.lpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        String[] names = {"Anna", "Bob", "Charlie", "Greg", "John", "Joshua"};

        //1st part - convert all names to uppercase using a lambda expression
        Arrays.asList(names).replaceAll(s -> s.toUpperCase());
        Arrays.asList(names).forEach(s -> System.out.println(s));
        System.out.println("-".repeat(30));

        //2nd part - add a random middle name initial
        Arrays.asList(names).replaceAll(s -> s + " " + getRandomInitial());
        Arrays.asList(names).forEach(s -> System.out.println(s));
        System.out.println("-".repeat(30));

        //3rd part - add the last name which is the reverse of the first name
        //format what to keep from the reversal of the first name, because it reverses the name plus middle name as well
        Arrays.asList(names).replaceAll(s -> s +
                getLastName(s.substring(0, s.indexOf(' ') + 1)));

        //Tim's solution to this part (much easier and logical than what I've done but yeah)
        //Arrays.asList(names).replaceAll(s -> s + " " + getLastName(s.split(" ")[0])); //essentially taking only the first name and not including the middle name
        Arrays.asList(names).forEach(s -> System.out.println(s));
        System.out.println("-".repeat(30));

        //4th part - create a new array that contains only names in which first/last name are not equal
        List<String> differentNames = new ArrayList<>(List.of(names));
        differentNames.removeIf(s -> {
            String[] nameParts = s.split(" ");
            return nameParts[0].equalsIgnoreCase(nameParts[2]);
        });
        differentNames.forEach(s -> System.out.println(s));
    }

    public static String getRandomInitial(){
        Random random = new Random();
        char value = (char)random.nextInt(65, 91);
        return value + ".";
    }

    public static String getLastName(String name){
        //last name is considered for this challenge the reversed format of the first name
        StringBuilder reversedName = new StringBuilder(name);
        return reversedName.reverse().toString();
        //one-liner would be : return new StringBuilder(name).reverse().toString();
    }
}
