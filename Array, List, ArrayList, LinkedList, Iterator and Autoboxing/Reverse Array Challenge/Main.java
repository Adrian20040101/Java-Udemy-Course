package dev.lpa;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] myArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        reverse(myArray);
        System.out.println("The reversed array is: " + Arrays.toString(myArray));
    }

    private static void reverse(int[] array){
        int temporaryValue;
        for (int i = 0; i < array.length / 2; i++){
            temporaryValue = array[i];
            array[i] = array[(array.length - 1) - i];
            array[(array.length - 1) - i] = temporaryValue;
        }
    }
}

