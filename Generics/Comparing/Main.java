package dev.lpa;

//this project implements the interface Comparable and lets us explore how this method inside the interface works
//to better understand how and when to use this method

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Integer five = 5;
        Integer[] array = {5, -5, 10, -10, 50, 100};

        //the compareTo method returns either 0 when the values are equal, -1 when the value is less than the
        //value that is passed in as an argument, or 1 otherwise
        for(Integer integer : array){
            System.out.println(five.compareTo(integer) == 0 ? five + " = " + integer :
                    five.compareTo(integer) > 0 ? five + " > " + integer : five + " < " + integer);
        }

        //we can try and compare String literals to see what will get printed out
        String banana = "banana";
        String[] stringArray = {"BANANA", "apple", "peach", "banana"};
        for (String stringValue : stringArray){
            int result = banana.compareTo(stringValue);
            System.out.println(result == 0 ? banana + " = " + stringValue + " result = " + result
                    : result > 0 ? banana + " > " + stringValue + " result = " + result
                    : banana + " < " + stringValue + " result = " + result);

            //in this method, result is not only -1, 0 or 1. It is actually the difference between the ASCII codes
            //of the first different characters in the Strings being compared
        }

        //let's try and compare Student objects
        Student tim = new Student("Tim");
        Student[] students = {new Student("Zack"), new Student("Cody"), new Student("Mary")};
        //we are just sorting them alphabetically
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));  //this initially doesn't work, because Student class cannot be cast to Comparable. To resolve this issue, we must implement Comparable in out Student class

        //the used approach works, but it is discouraged to be used, because the code compiles when we type a String
        //literal as am argument. Although it returns an exception when running, we really don't want anyone to be
        //able to run the code in this way. This is where we have to transform the Comparable interface into a generic one

        // System.out.println("result = " + tim.compareTo("Mary")); we'll get an exception in the current format, but when we specify the Student as the type in the generic interface Comparable, we'll get an error
        System.out.println("result = " + tim.compareTo(new Student("Mary"))); //desired way to work


        //for differences between Comparable and Comparator check out in Java Concepts the file named
        //comparable_vs_comparator. Here you'll also find when to use one or another
        Comparator<Student> gpaSorter = new GPAComparator();
        Arrays.sort(students, gpaSorter);
        System.out.println(Arrays.toString(students));
        //if we want them sorted in reverse order, we can use the method that Comparator provides
        Arrays.sort(students, gpaSorter.reversed());
        System.out.println(Arrays.toString(students));
    }
}

class GPAComparator implements Comparator<Student>{

    public int compare(Student o1, Student o2) {
        return (o1.gpa + o1.name).compareTo(o2.gpa + o2.name);
    }
}

class Student implements Comparable<Student> {
    String name;  //not specifying any access modifiers makes it package private by default
    protected double gpa;
    private int id;
    private static final int LAST_ID = 1000;
    private Random random = new Random();



    public Student(String name) {
        this.name = name;
    }

    public double getRandomGPA(){
        return random.nextDouble(1.0, 4.0);
    }

    private int getRandomId(){
        return random.nextInt(0, 100);
    }

    @Override
    public String toString() {
        return "%d - %s (%.2f)".formatted(getRandomId(), name, getRandomGPA());
    }

    @Override
    public int compareTo(Student o) {
        return Integer.valueOf(id).compareTo(Integer.valueOf(o.id));
    }

//    when adding the generic type Student to the Comparable interface, this provided implementation doesn't work anymore, because we have to specify a Student object, not an Object object
//    @Override
//    public int compareTo(Object o) {
//        Student otherStudent = (Student) o;
//        return name.compareTo(otherStudent.name);
//    }
}
