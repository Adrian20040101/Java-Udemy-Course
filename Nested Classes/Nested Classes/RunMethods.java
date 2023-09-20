package dev.lpa;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RunMethods {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>(List.of(
                new Employee(23, "Ralph", 2018),
                new Employee(56, "Mary", 2017),
                new Employee(15, "Josh", 2016),
                new Employee(67, "John", 2020),
                new Employee(57, "Tim", 2021)
        ));

//        var comparator = new EmployeeComparator<>();
//        employees.sort(comparator);

        employees.sort(new Employee.EmployeeComparator<>()); //static nested method basic call, which doesn't egt any parameters and therefore sorts by name
        employees.sort(new Employee.EmployeeComparator<>("YEARSTARTED")); //sorts by whatever is specified

        for (Employee employee : employees){
            System.out.println(employee);
        }

        System.out.println();
        System.out.println("STORE MEMBERS");
        System.out.println();

        List<StoreEmployee> storeEmployees = new ArrayList<>(List.of(
                new StoreEmployee(234, "Marty", 2013, "Walmart"),
                new StoreEmployee(542, "Jim", 2021, "Target"),
                new StoreEmployee(132, "Tom", 2017, "CVS"),
                new StoreEmployee(643, "Jack", 2011, "Walmart"),
                new StoreEmployee(324, "Lily", 2020, "Lowes")
        ));

        var c0 = new EmployeeComparator<StoreEmployee>();
        var c1 = new Employee.EmployeeComparator<StoreEmployee>();
        var c2 = new StoreEmployee().new StoreComparator<>();

        class NameSort<T> implements Comparator<StoreEmployee>{

            @Override
            public int compare(StoreEmployee o1, StoreEmployee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        }

        var c3 = new NameSort<StoreEmployee>();
        //c4 is the standard declaration of an anonymous class that sorts by name
        var c4 = new Comparator<StoreEmployee>(){

            @Override
            public int compare(StoreEmployee o1, StoreEmployee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };

        sortIt(storeEmployees, c0);
        sortIt(storeEmployees, c1);
        sortIt(storeEmployees, c2);
        sortIt(storeEmployees, c3);
//      sortIt(storeEmployees, c4);
        //we can also pass the anonymous class as a parameter
        sortIt(storeEmployees, new Comparator<StoreEmployee>() {  //JVM suggests a lambda expression
            @Override
            public int compare(StoreEmployee o1, StoreEmployee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        //here is the lambda expression format of the anonymous class in this example
        sortIt(storeEmployees, (o1, o2) -> o1.getName().compareTo(o2.getName()));
    }

    public static <T> void sortIt(List<T> list, Comparator<? super T> comparator){
        System.out.println("Sorting with comparator: " + comparator.toString());
        list.sort(comparator);
        for (var employee : list){
            System.out.println(employee);
        }
    }
}
