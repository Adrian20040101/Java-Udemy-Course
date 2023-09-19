package dev.lpa;

import java.util.Comparator;

public class EmployeeComparator<T extends Employee> implements Comparator<Employee> {

    //sorts the employees in ascending order based on their name
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
