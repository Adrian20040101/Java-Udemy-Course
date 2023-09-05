package dev.lpa;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] myIntArray = new int[10];  //basic declaration of an array in Java
        myIntArray[1] = 4;  //assigning the second element in the array the value 4 (it is the second element because indexing starts at 0)
        System.out.println("The second value in the array is " + myIntArray[1]);  //printing the actual value

        double[] array2 = new double[] {1.0, 2.7, 3.2, 4.0, 5.1, 6.1, 7.23, 8.3, 9.1, 10.2};  //better way to initialize an array if the values are known from the beginning
        String[] array3 = {"first", "second", "third"};  //shorter form of the above line

        //we can access the length of the array

        System.out.println("There are " + array3.length + " elements in the array");
        System.out.println("The last element is " + array3[array3.length - 1]);

        //we can also declare and assign values on separate lines

        int[] array4;
        array4 = new int[] {1, 2, 3, 4, 5};

        //use a for loop to print all the elements in the array

        for (int i = 0; i < array4.length; i++){
            System.out.print(array4[i] + " ");
        }

        System.out.println();

        //we can also use a for each loop (enhanced for loop) to print the elements in an array
        //this for loop doesn't use indexes and stores the values in the arrays in a declared variable

        for (int element : array4){
            System.out.print(element + " ");
        }

        System.out.println();

        //we can print the elements in the array without needing to loop over the array

        System.out.println(Arrays.toString(array4));

        //assigning the array to an object variable is also a possibility

        Object objectVariable = array4;
        if (objectVariable instanceof int[]){
            System.out.println("objectVariable is really just an int array");
        }

        //we can create an array of elements of type Object and create nested arrays
        //it also lets us store elements of different types in the same array

        Object[] objectArray = new Object[3];
        objectArray[1] = "Hello";
        objectArray[2] = 1;
        objectArray[0] = array4;  //nested array
        System.out.println(Arrays.toString(objectArray));
    }
}
