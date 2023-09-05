package dev.lpa;

import java.util.Arrays;  //there are many useful tools in this package, we are going to discuss some of them
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int[] firstArray = getRandomArray(10);
        System.out.println("First Array Unsorted: " + Arrays.toString(firstArray));
        Arrays.sort(firstArray);   //sorts the given array in ascending order
        System.out.println("First Array Sorted: " + Arrays.toString(firstArray));

        int[] secondArray = new int[10];
        System.out.println("Second Array: " + Arrays.toString(secondArray));  //it will print the default value for each element, in this case 0
        Arrays.fill(secondArray, 10);  //fills all the elements in the array with values of 10
        System.out.println("Second Array After Fill(): " + Arrays.toString(secondArray));  //it will print the value 10 for each element

        int[] thirdArray = Arrays.copyOf(firstArray, firstArray.length);  //copies the content of the firstArray in the thirdArray. Any changes made to thirdArray won't impact firstArray
        Arrays.fill(thirdArray, 5);  //fills only the third array with 5's
        //we can check the difference between the two
        System.out.println("First Array: " + Arrays.toString(firstArray));
        System.out.println("Third Array: " + Arrays.toString(thirdArray));

        int[] smallerArray = Arrays.copyOf(firstArray,5); //it only copies the first 5 elements
        int[] largerArray = Arrays.copyOf(firstArray, 15); //it copies all the elements in the firstArray and adds 0's after it exceeds the length of the original array

        //matching values in an array can be found. When dealing with a sorted array, it is best to use the provided binarySearch method, because it is more efficient than a linear search
        //the binarySearch method returns the position at which the searched key is found or -1 if it is not found
        String[] sortedArray = {"Abel", "Jade", "Jane", "John", "Ralph"};
        if (Arrays.binarySearch(sortedArray, "John") >= 0 ){
            System.out.println("John was found in the array at position " +
                    (Arrays.binarySearch(sortedArray, "John") + 1));
        }

        //we can also check if two arrays are identical, meaning the number, order and values of the elements match exactly

        int[] fourthArray = {1, 2, 3, 4, 5};
        int[] fifthArray = {1, 2, 3, 4, 5, 0};  //without the 0 at the end it would've returned that they are identical

        if (Arrays.equals(fourthArray, fifthArray)){
            System.out.println("The arrays are identical");
        } else {
            System.out.println("The arrays are not identical");
        }

    }

    public static int[] getRandomArray(int length){   //method that returns an array filled with random values
        Random random = new Random();
        int[] newInt = new int[length];
        for (int i = 0; i < length; i++){
            newInt[i] = random.nextInt(0, 100);
        }
        return newInt;
    }
}



