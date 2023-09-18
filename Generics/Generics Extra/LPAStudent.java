package dev.lpa.model;

public class LPAStudent extends Student{

    private double percentageComplete;

    public LPAStudent() {
        this.percentageComplete = random.nextDouble(0, 100.001); //100.001 to make sure 100.00 is included
    }

    @Override
    public String toString() {
        return "%s %8.1f%%".formatted(super.toString(), percentageComplete);
    }
}
