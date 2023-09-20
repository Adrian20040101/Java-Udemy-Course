package dev.lpa;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Tim", "Butcher", "10/12/2021"));
        employees.add(new Employee("Andrew", "Tate", "04/02/2010"));
        employees.add(new Employee("Tristan", "Tate", "01/09/2010"));
        employees.add(new Employee("John", "Wick", "09/10/2015"));
        employees.add(new Employee("Leo", "Messi", "30/06/2017"));

        for (var employee : employees){
            System.out.println(employee);
        }
        System.out.println();

        employeeAdditionalInformation(employees, "fullname");


    }

    public static void employeeAdditionalInformation(List<Employee> employeeList, String sortType) {

        class EmployeeInformation {
            private String fullName;
            private int yearsWorked;

            public EmployeeInformation(Employee employee) {
                this.fullName = String.join(" ", employee.firstName(), employee.lastName());
                this.yearsWorked = 2023 - Integer.parseInt(employee.hireDate().substring(6));
            }

            @Override
            public String toString() {
                return "%s has been an employee for %d years".formatted(fullName, yearsWorked);
            }
        }

        List<EmployeeInformation> detailedEmployees = new ArrayList<>(employeeList.size());
        for (var dEmployee : employeeList) {
            detailedEmployees.add(new EmployeeInformation(dEmployee));
        }

        //anonymous class to sort employees by full name or years worked
        var sorted = new Comparator<EmployeeInformation>() {

            @Override
            public int compare(EmployeeInformation o1, EmployeeInformation o2) {
                if (sortType.equalsIgnoreCase("FULLNAME")){
                    return o1.fullName.compareTo(o2.fullName);
                } else if (sortType.equalsIgnoreCase("YEARSWORKED")){
                    return o1.yearsWorked - o2.yearsWorked;
                }
                return 0;
            }
        };

        //detailedEmployees.sort(nameSorted);
        detailedEmployees.sort(sorted);
        for (var employee : detailedEmployees) {
            System.out.println(employee.toString());
        }
    }
}
