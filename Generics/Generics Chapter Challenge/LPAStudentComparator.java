package src.dev.lpa.model;

import java.util.Comparator;

public class LPAStudentComparator implements Comparator<LPAStudent> {
    @Override
    public int compare(LPAStudent o1, LPAStudent o2) {
        return (int) (o1.getPercentageComplete() - o2.getPercentageComplete());
    }
}
