package dev.lpa.model;

import dev.lpa.util.QueryItem;

import java.util.Random;

public class Student implements QueryItem {

    private static String[] firstNames = {"Ann", "Jack", "John", "Tim", "Josh"};
    private static String[] availableCourses = {"C++", "Python", "Java"};
    private String name;
    private String course;
    private int yearEnrolled;
    protected Random random = new Random();

    public Student() {
        name = firstNames[random.nextInt(5)] + " " + (char) (random.nextInt(65, 91));
        course = availableCourses[random.nextInt(3)];
        yearEnrolled = random.nextInt(2018, 2024);
    }

    @Override
    public String toString() {
        return "%-15s %-15s %d".formatted(name, course ,yearEnrolled);  //the '-' means the string is left justified, leaving spaces (in this case 15) to the left of the string
    }

    public int getYearEnrolled() {
        return yearEnrolled;
    }

    @Override
    public boolean matchFieldValue(String fieldName, String value) {
        String fName = fieldName.toUpperCase();
        return switch (fName){
            case "NAME" -> name.equalsIgnoreCase(value);
            case "COURSE" -> course.equalsIgnoreCase(value);
            case "YEARENROLLED" -> yearEnrolled == Integer.parseInt(value);
            default -> false;
        };
    }
}
