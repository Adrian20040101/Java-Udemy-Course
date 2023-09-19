package dev.lpa;

import java.util.Comparator;

//while it works, working with a separate class for sorting the employees, we can write in a more simple way
//using nested classes. In addition to that, we won't even need getters anymore, because nested classes
//can access the outer classes private variables. This gives us more flexibility, as we can sort by
//whatever field we'd like
public class Employee {

    public static class EmployeeComparator<T extends Employee> implements Comparator<Employee> {

        private String sortingType;

        public EmployeeComparator() { this("name"); } //when nothing is specified, it will implicitly sort by name

        public EmployeeComparator(String sortingType) {
            this.sortingType = sortingType;
        }

        @Override
        public int compare(Employee o1, Employee o2) {
            if (sortingType.equalsIgnoreCase("EMPLOYEEID")){
                return o1.employeeId - o2.employeeId;
            } else if (sortingType.equalsIgnoreCase("YEARSTARTED")){
                return o1.yearStarted - o2.yearStarted;
            } else {
                return o1.name.compareTo(o2.name);
            }
        }
    }

    private String name;
    private int employeeId;
    private int yearStarted;

    public Employee() {}

    public Employee(int employeeId, String name, int yearStarted) {
        this.name = name;
        this.employeeId = employeeId;
        this.yearStarted = yearStarted;
    }

    //it is not needed anymore when working with nested classes
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "%-8d %-10s %d".formatted(employeeId, name, yearStarted);
    }
}
