package src.dev.lpa;

import src.dev.lpa.model.LPAStudent;
import src.dev.lpa.model.LPAStudentComparator;
import src.dev.lpa.model.Student;
import src.dev.lpa.util.QueryList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        Student tim = new Student();
        for (int i = 0; i < 10; i++){
            students.add(new Student());
        }

        QueryList<LPAStudent> queryList = new QueryList<>();
        for(int i = 0; i < 25; i++){
            queryList.add(new LPAStudent());
        }

        System.out.println("Ordered");
        queryList.sort(Comparator.naturalOrder());

        printMoreLists(queryList);

        System.out.println("Matches");
        var matches = queryList.getMatches("PercentageComplete", "50");
        printMoreLists(matches);

        System.out.println("Sorted by Percentage Complete");
        matches.sort(new LPAStudentComparator());
        printMoreLists(matches);
    }

    public static void printMoreLists(List<? extends Student> students){
        for (var student : students){
            System.out.println(student);
        }
        System.out.println();
    }

}

