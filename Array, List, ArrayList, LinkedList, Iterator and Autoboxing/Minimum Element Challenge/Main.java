package dev.lpa;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int[] findMinInArray = readIntegers();
        System.out.println("The minimum value in the given array is: " + findMin(findMinInArray));
    }

    private static int[] readIntegers(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a list of integer numbers, separated by commas: ");

        String input = scanner.nextLine();
        String[] actualValues = input.split(",");
        int[] myArray = new int[actualValues.length];

        for (int i = 0; i < actualValues.length; i++){
            myArray[i] = Integer.parseInt(actualValues[i]);
        }

        return myArray;
    }

    public static int findMin(int[] array){
        int minimum = Integer.MAX_VALUE;
        for (int element : array){
            if (element < minimum){
                minimum = element;
            }
        }
        return minimum;
    }
}
