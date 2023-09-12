package dev.lpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MoreLists {
    public static void main(String[] args) {

        String[] items = {"apples", "ketchup", "slippers", "cereal"};
        List<String> list = List.of(items); //list is immutable, meaning it cannot be changed
        System.out.println(list);

        //list.add("yogurt");  -> provides an exception, since we are trying to add something

        //instead, we can try to assign the elements of the list to an ArrayList, which is mutable

        ArrayList<String> groceries = new ArrayList<>(list);
        groceries.add("yogurt");
        System.out.println(groceries);

        //we can even get the contents of two ArrayLists into one

        ArrayList<String> nextList = new ArrayList<>(List.of("pickles", "mayo", "cheese")); //here we are creating an ArrayList with the contents of a List, in which we directly specified the content
        groceries.addAll(nextList);  //add all elements from the newly created ArrayList to the initial ArrayList
        System.out.println(groceries);

        //get the position of a specified parameter

        System.out.println("Third item = " + groceries.get(2));

        //check if the list contains a specified element

        if (groceries.contains("cheese")){
            System.out.println("List contains cheese");
        }

        //check the index of the first appearance or the last appearance of a certain element

        groceries.add("yogurt");
        System.out.println(groceries);
        System.out.println("First appearance of yogurt = " + groceries.indexOf("yogurt"));
        System.out.println("Last appearance of yogurt = " + groceries.lastIndexOf("yogurt"));

        System.out.println(groceries);
        groceries.remove(1);
        System.out.println(groceries);
        groceries.remove("yogurt");  //removes the first appearance of yogurt in the list
        System.out.println(groceries);

        //we can remove multiple elements at once using removeAll

        groceries.removeAll(List.of("pickles", "apples"));
        System.out.println(groceries);

        //we can specify what items we'd like to keep and remove the rest

        groceries.retainAll(List.of("cereal", "cheese", "mayo"));
        System.out.println(groceries);

        //we can delete all elements by using clear method

        groceries.clear();
        System.out.println(groceries);
        System.out.println("Empty grocery list? " + groceries.isEmpty());

        //add some elements back to the grocery list

        groceries.addAll(List.of("apples", "bananas", "ketchup"));
        groceries.addAll(Arrays.asList("eggs", "ham", "milk"));  //both determine the same output
        System.out.println(groceries);

        //we can sort the items in out grocery list

        groceries.sort(Comparator.naturalOrder()); //orders the items in ascending order (here alphabetically)
        System.out.println(groceries);
        groceries.sort(Comparator.reverseOrder()); //orders items in reverse order alphabetically
        System.out.println(groceries);

        //we can create a 'wrapper' for an array to make it behave like a list
        //we'd want to do that to be able to access the lists methods, like Comparator.naturalOrder();

        String[] originalArray = new String[] {"First", "Second", "Third"};
        var originalList = Arrays.asList(originalArray);  //noe the originalList is treated like a list

        originalList.set(0, "One");
        System.out.println("List: " + originalList);
        System.out.println("Arrays: " + Arrays.toString(originalArray));  //although they have the same content, their functionality differs

        originalList.sort(Comparator.naturalOrder());
        System.out.println("Array: " + Arrays.toString(originalArray));

        //originalList.add("Fourth");  -> this is not allowed because lists are immutable

        //we can create a list by declaring it in the following way as well:

        List<String> newList = Arrays.asList("Sunday", "Monday", "Tuesday");
        System.out.println(newList);

        //in summary, we can create Lists in two ways and with different functionality:

        //1. String[] days = new Arrays.asList("Sunday", "Monday", "Tuesday");
        //   List<String> newList = Arrays.asList(days);
        //these lines of code declare a list that is NOT resizeable, but is mutable

        //2. String[] days = new Arrays.asList("Sunday", "Monday", "Tuesday");
        //   List<String> newList = List.of(days);
        //these lines of code declare a list that is IMMUTABLE

        //also creating an array from ArrayList can be done in the following way

        //ArrayList<String> stringLists = new ArrayList<>(List.of("Jan", "Feb", "Mar"));
        //String[] stringArray = stringLists.toArray(new String[0]);
    }
}
