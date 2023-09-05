package dev.lpa;

//print an array in descending order

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int[] array = getRandomArray(7);
        System.out.println("Initial Array: " + Arrays.toString(array));
        Arrays.sort(array);
        int[] sortedArray = new int[array.length];

        for(int i = array.length - 1; i >= 0; i--){
            sortedArray[i] = array[(array.length - 1) - i];
        }

        System.out.println("Sorted Array In Descending Order: " + Arrays.toString(sortedArray));
        System.out.println(Arrays.toString(getIntegers(5)));
    }

    public static int[] getRandomArray(int length){
        Random random = new Random();
        int[] myArray = new int[length];
        for (int i = 0; i < length; i++){
            myArray[i] = random.nextInt(0, 100);
        }
        return myArray;
    }
    public static int[] getIntegers(int length){
        Scanner scanner = new Scanner(System.in);
        int[] myArray = new int[length];
        for (int i = 0; i < length; i++){
            myArray[i] = scanner.nextInt();
        }
        return myArray;
    }
}

//this is part of a coding challenge and not the arrays challenge from the course
//it is written for testing purposes
class SortedArray {
    // write code here

    public static int[] getIntegers(int length){
        Scanner scanner = new Scanner(System.in);
        int[] myArray = new int[length];
        for (int i = 0; i < length; i++){
            myArray[i] = Integer.parseInt(scanner.nextLine());
        }
        return myArray;
    }

    public static void printArray(int[] array){
        for (int i = 0; i < array.length; i++){
            System.out.println("Element " + i + " contents " + array[i]);
        }
    }

    public static int[] sortIntegers(int[] unsortedArray){
        Arrays.sort(unsortedArray);
        int[] sortedArray = Arrays.copyOf(unsortedArray, unsortedArray.length);

        for (int i = sortedArray.length - 1; i >= 0; i--){
            sortedArray[i] = unsortedArray[(unsortedArray.length - 1) - i];
        }

        return sortedArray;
    }
}
