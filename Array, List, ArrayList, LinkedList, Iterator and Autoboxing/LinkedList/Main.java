package dev.lpa;

import java.util.LinkedList;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {

//      LinkedList<String> placesToVisit = new LinkedList<>();
        var placesToVisit = new LinkedList<String>();  //this declaration requires us to specify the type of data that the LinkedList stores in the diamond operator

        placesToVisit.add("Sydney");
        placesToVisit.add(0, "Canberra");
        System.out.println(placesToVisit);

        addMoreElements(placesToVisit);
        System.out.println(placesToVisit);

//        removeElements(placesToVisit);
//        System.out.println(placesToVisit);

//        getElements(placesToVisit);
//        printRoadTrip1(placesToVisit);
//        printRoadTrip2(placesToVisit);
//        printRoadTrip3(placesToVisit);
        testIterator(placesToVisit);
    }

    private static void addMoreElements(LinkedList<String> list) {

        list.addFirst("Darwin");
        list.addLast("Hobart");
        // Queue methods
        list.offer("Melbourne");
        list.offerFirst("Brisbane");
        list.offerLast("Toowoomba");
        // Stack Methods
        list.push("Alice Springs");

    }

    private static void removeElements(LinkedList<String> list) {

        list.remove(4);
        list.remove("Brisbane");

        System.out.println(list);
        String s1 = list.remove(); // removes first element
        System.out.println(s1 + " was removed");

        String s2 = list.removeFirst(); // removes first element
        System.out.println(s2 + " was removed");

        String s3 = list.removeLast(); // removes last element
        System.out.println(s3 + " was removed");
        // Queue/Deque poll methods
        String p1 = list.poll();  // removes first element
        System.out.println(p1 + " was removed");
        String p2 = list.pollFirst();  // removes first element
        System.out.println(p2 + " was removed");
        String p3 = list.pollLast();  // removes last element
        System.out.println(p3 + " was removed");

        list.push("Sydney");
        list.push("Brisbane");
        list.push("Canberra");
        System.out.println(list);

        String p4 = list.pop();  // removes first element
        System.out.println(p4 + " was removed");
    }

    private static void getElements(LinkedList<String> list){
        //we can use the methods from the list to retrieve elements
        System.out.println("Retrieved Element = " + list.get(4));

        System.out.println("First Element = " + list.getFirst());
        System.out.println("Last Element = " + list.getLast());

        System.out.println("Darwin is at position " + list.indexOf("Darwin"));
        System.out.println("Melbourne is at position " + list.lastIndexOf("Melbourne"));

        //Queue retrieval methods

        System.out.println("First Element = " + list.element());  //returns the head of the queue

        //Stack retrieval methods

        System.out.println("First Element = " + list.peek());  //peek and peekFirst return both the head of the stack
        System.out.println("First Element = " + list.peekFirst());
        System.out.println("Last Element = " + list.peekLast());
    }

    private static void printRoadTrip1(LinkedList<String> list){
        System.out.println("Trip starts at " + list.getFirst());

        //now print all the cities that have been visited in this road-trip
        //we'll do it in three ways

        //1. Traditional For Loop

        for (int i = 1; i < list.size(); i++){
            System.out.println("--> From " + list.get(i - 1) + " to " + list.get(i));
        }

        System.out.println("Trip ends at " + list.getLast());

    }

    private static void printRoadTrip2(LinkedList<String> list){
        System.out.println("Trip starts at " + list.getFirst());

        //2. Enhanced For Loop
        //problem that the first trip will get printed from city to city itself

        String prevCity = list.getFirst();
        for (String city : list){
            System.out.println("--> From " + prevCity + " to " + city);
        }

        System.out.println("Trip ends at " + list.getLast());
    }

    private static void printRoadTrip3(LinkedList<String> list){
        System.out.println("Trip starts at " + list.getFirst());

        //3. LinkedList Iterator
        //problem that the first trip will get printed from city to city itself

        String prevCity = list.getFirst();
        ListIterator<String> iterator =list.listIterator(1);  //we start at one to avoid the same issue as the second variant to print the road-trip
        while (iterator.hasNext()){
            var city = iterator.next();
            System.out.println("--> From " + prevCity + " to " + city);
            prevCity = city;
        }

        System.out.println("Trip ends at " + list.getLast());
    }

    //bonus - achieve the same result but using only an iterator for traversing the linkedList
    //AND also modifying elements (add, remove or set operations)

    private static void testIterator (LinkedList<String> list){
        var iterator = list.listIterator();
        while (iterator.hasNext()){
            //not that only method can be used at a time
            if (iterator.next().equals("Brisbane")){  //this statement removes every appearance of Brisbane
                iterator.remove();
            }

            //add an element right after a specified element
            if (iterator.next().equals("Darwin")){
                iterator.add("Adelaide");
            }
        }
        System.out.println(list);

        //the iterator can also go backwards
        //here we print the list of cities in reverse order

        while (iterator.hasPrevious()){
            System.out.println(iterator.previous());
        }
    }
}
