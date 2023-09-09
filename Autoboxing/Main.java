package dev.lpa;

//background information about the concepts of boxing, unboxing and autoboxing

//some primitive values (like int) can't be used when working with java collections, like ArrayList or LinkedList
//java provides wrapper classes for each primitive type (e.g. Integer for int)
//we can go from a primitive to a wrapper -> this is called boxing
//we can go from a wrapper to a primitive -> this is called unboxing
//each data type has a wrapper class
//each wrapper class has a static overloaded method, valueOf() which takes a primitive and returns an instance of the wrapper class
//primitive types and their respective wrapper class can almost be used interchangeably


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //manually boxing an integer
        Integer boxedInteger = Integer.valueOf(15);  //works but is unnecessary

        //another manual boxing, which has been deprecated since JDK 9, goes like this
        //although Java marks it as an error, the code will still compile, but it is not recommended to use this format
        Integer integer = new Integer(15);

        //a preferred code for manual boxing
        Integer boxedInt = 15;  //allowing Java to autobox is preferred to any other method, because Java will provide the best mechanism to do it

        //example of automatic unboxing, actually preferred way to unbox a wrapper instance
        Integer boxed = 15;
        int unboxed = boxed;

        Double resultBoxed = getDoubleLiteralPrimitive();
        double resultUnboxed = getDoubleObject();

        //this time, the empty positions won't be filled be 0's, as for the int type, but rather with null
        Integer[] wrapperArray = new Integer[5];
        wrapperArray[0] = 10;
        System.out.println(Arrays.toString(wrapperArray));

        Character[] charArray = {'a', 'b', 'c', 'd'};
        System.out.println(Arrays.toString(charArray));

        var ourList = getList(1, 2, 3, 4, 5);
        System.out.println(ourList);

        //or we can also type that in the following way:

        var ourOtherList = List.of(6, 7, 8, 9, 10);
        System.out.println(ourOtherList);
    }

    public static Double getDoubleObject(){
        return Double.valueOf(100.00);
    }

    public static double getDoubleLiteralPrimitive(){
        return 100.00;
    }

    //we can even use the primitive type and the wrapper interchangeably
    private static int returnAnInt(Integer i){
        return i;
    }

    private static Integer returnAnInteger(int i){
        return i;
    }

    //but where the autoboxing really shows its meaning, is when we deal with a collection that doesn't support primitive data types
    //for example, when we want to store integers into an ArrayList, we cannot store values of type int
    //but we can use the wrapper Integer to achieve that

    private static ArrayList<Integer> getList(int... varargs) {  //'...' represents 0 or many arguments
        ArrayList<Integer> aList = new ArrayList<>();
        for (int i: varargs){
            aList.add(i);
        }
        return aList;
    }

}
