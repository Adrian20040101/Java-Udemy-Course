package src.dev.lpa.model;

public class LPAStudent extends Student{

    private double percentageComplete;

    public LPAStudent() {
        this.percentageComplete = random.nextDouble(0, 100.001); //100.001 to make sure 100.00 is included
    }

    public double getPercentageComplete() {
        return percentageComplete;
    }

    @Override
    public String toString() {
        return "%s %8.1f%%".formatted(super.toString(), percentageComplete);
    }

    @Override
    public boolean matchFieldValue(String fieldName, String value) {
        if (fieldName.equals("PercentageComplete")){
            return percentageComplete <= Integer.parseInt(value);
        }
        return super.matchFieldValue(fieldName, value);

    }
}
