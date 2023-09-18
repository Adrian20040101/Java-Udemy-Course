package dev.lpa;

import dev.lpa.model.LPAStudent;
import dev.lpa.model.Student;
import dev.lpa.util.QueryItem;
import dev.lpa.util.QueryList;

import java.util.ArrayList;
import java.util.List;

record Employee(String name) implements QueryItem{

    @Override
    public boolean matchFieldValue(String fieldName, String value) {
        return false;
    }
}

public class Main {
    public static void main(String[] args) {

        int studentCount = 10;
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < studentCount; i++){
            students.add(new Student());
        }
        printMoreLists(students);

        List<LPAStudent> lpaStudents = new ArrayList<>();
        for (int i = 0; i < studentCount; i++){
            students.add(new LPAStudent());
        }
        printMoreLists(lpaStudents);    //we can see that it doesn't work, even if LPAStudent is a subclass of Student. That is because we use this class as reference type and it is not the same thing as inheritance
                                   //a container of one type has no relationship with a container of another type, even if the contained classes do have a relationship
                                   //to make this work, we need to include generic methods

        testList(new ArrayList<>(List.of("Barry", "John", "Mary")));
        testList(new ArrayList<>(List.of(1, 2, 3)));

        var queryList = new QueryList<>(lpaStudents);
        var matches = queryList.getMatches("Course", "Java");
        printMoreLists(matches);

        var students2020 = QueryList.getMatches(students, "YearEnrolled", "2020");
        printMoreLists(students2020);

        //QueryList<Employee> employeeList = new QueryList<>();  -> error because Employee only implements QueryItem, but for this to work, it has to be a subclass of Student as well, which it isn't

    }

    //this is called a wildcard. '?' is used instead of a generic type T. More on this can be found in Java concepts under wildcard
    public static void printMoreLists(List<? extends Student> students){  //super is also allowed, but it would specify only a lower bound. So it would still not make this work
        for (var student : students){
            System.out.println(student.getYearEnrolled() + ": " + student);
        }
        System.out.println();
    }

    public static void testList(List<?> list){
        for (var element : list){
            if (element instanceof String string){
                System.out.print("String: " + string.toUpperCase());
            } else if (element instanceof Integer integer){
                System.out.print("Integer: " + integer.intValue());
            }
            System.out.println();
        }
    }

//    type erasure -> see more on this in Java concepts, under type_erasure

//    public static void testList(List<String> list){  ->we get an error that both methods have the same type erasure, but we can solve this using a wildcard. See method testList above for this
//        for (var element : list){
//            System.out.println("String: " + element.toUpperCase());
//        }
//    }
//
//    public static void testList(List<Integer> list){
//        for (var element : list){
//            System.out.println("Integer: " + element.intValue());
//        }
//    }

//    we can specify a generic method by placing the type argument before the return type of the method
//    we can also specify upper bounds, like in a generic class
//    while this works great, there is another way we can handle this situation, see method printMoreLists above

//    public static <T extends Student> void printList(List<T> students){
//        for (var student : students){
//            System.out.println(student.getYearEnrolled() + ": " + student);
//        }
//        System.out.println();
//    }

//    basic way to print elements that are specific for Student objects only

//    public static void printList(List<Student> students){
//        for (var student : students){
//            System.out.println(student);
//        }
//        System.out.println();
//    }
}
