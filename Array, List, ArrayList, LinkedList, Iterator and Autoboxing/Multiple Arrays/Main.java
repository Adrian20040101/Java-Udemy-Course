package dev.lpa;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[][] matrix = new int[4][4];  //standard declaration of a 4x4 matrix

        //there are many different ways we can traverse and/or populate the matrix

        for (int[] outer : matrix){
            System.out.println(Arrays.toString(matrix)); //this prints the address of each element in the matrix
        }

        //to print actual values, we can iterate through each element using nested loops

        for (int i = 0; i < matrix.length; i++){
            var innerIndex = matrix[i];
            for (int j = 0; j < innerIndex.length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
        //or we can do that without needing to specify a local variable at all

        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
        //we can also achieve the same result using nested enhanced for loops

        for (int[] outer : matrix){
            for (int inner : outer){
                System.out.print(inner + " ");
            }
            System.out.println();
        }

        System.out.println();
        //the easiest way is to use another Arrays method

        System.out.println(Arrays.deepToString(matrix)); //this will print the matrix on a single line

        System.out.println();
        //we can create multidimensional arrays

        Object[] multiArray = new Object[3];
        System.out.println(Arrays.toString(multiArray));  //prints 3 null values in an array

        //we can now assign each element in the array to be an array on its own
        multiArray[0] = new String[] {"a", "b", "c"};
        System.out.println(Arrays.deepToString(multiArray));  //first element is set to the array just created

        multiArray[1] = new String[][] {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};
        System.out.println(Arrays.deepToString(multiArray));

        multiArray[2] = new int[2][2][2]; //assigning to the third element a three-dimensional array
        System.out.println(Arrays.deepToString(multiArray));
    }
}
