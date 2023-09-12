package dev.lpa;

public class Main {

    public static void main(String... args) {  //we can also place '...' instead of '[]'

        System.out.println("Hello World");
        String[] splitString = "Hello World".split(" "); //splits the string into words and stores them as array in the variable to which it is assigned
        printText(splitString);

        System.out.println("-".repeat(20));
        printText("Hello"); //works with String literals as well

        System.out.println("-".repeat(20));
        printText("Hello", "World");

        System.out.println("-".repeat(20));
        printText();

        String[] stringArray = {"first", "second", "third", "fourth", "fifth"};
        System.out.println(String.join(", ", stringArray));  //this method takes five separate strings and joins them into one single string
    }

    private static void printText(String... textList){   //here we must use ... instead of [], otherwise we couldn't have called the method printText on the string "Hello"
        for (String t : textList){
            System.out.println(t);
        }
    }
}
