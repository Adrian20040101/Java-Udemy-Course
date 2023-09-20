package dev.lpa;

import java.util.ArrayList;
import java.util.List;

public class Main {
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

        //this is the basic declaration of a nested inner class, that is not static
        //first, we create an instance of the outer class using 'new StoreEmployee()'
        //then we concatenate that with a new instance of the comparator class '.new StoreComparator<>()'
        var comparator = new StoreEmployee().new StoreComparator<>();
        storeEmployees.sort(comparator);

        for (StoreEmployee storeEmployee : storeEmployees){
            System.out.println(storeEmployee);
        }

        System.out.println();
        System.out.println("WITH PIG LATIN NAME: ");
        System.out.println();
        addPigLatinName(storeEmployees);
    }

    //pigLatin language cuts the first letter from a word, appends it after the last letter, and then adds 'ay'
    public static void addPigLatinName(List<? extends StoreEmployee> list){

        String lastName = "Piggy"; //local variables can be used in local classes

        //create a local class to handle this concept
        class DecoratedName extends StoreEmployee implements Comparable<DecoratedName> {
            private String pigLatinName;
            private Employee originalInstance;

            public DecoratedName(String pigLatinName, Employee originalInstance) {
                this.pigLatinName = pigLatinName;
                this.originalInstance = originalInstance;
            }

            @Override
            public String toString() {
                return originalInstance.toString() + " " + pigLatinName + " " + lastName;
            }

            //sorts the pig latin names
            @Override
            public int compareTo(DecoratedName o) {
                return pigLatinName.compareTo(o.pigLatinName);
            }
        }

        List<DecoratedName> newList = new ArrayList<>(list.size());

        for (var employee : list){
            String name = employee.getName();
            String pigLatin = name.substring(1) + name.charAt(0) + "ay";
            newList.add(new DecoratedName(pigLatin, employee));
        }

        for (var dEmployee : newList){
            System.out.println(dEmployee.originalInstance + " " + dEmployee.pigLatinName);
        }
    }
}
