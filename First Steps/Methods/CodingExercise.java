public class CodingExercise {
    public static void main(String[] args) {

    }
    public static long toMilesPerHour(double kilometersPerHour) {
        long roundedMilesPerHour;
        if (kilometersPerHour < 0) {
            return -1;
        } else {
            double milesPerHour = kilometersPerHour / 1.609;
            roundedMilesPerHour = Math.round(milesPerHour);
        }
        return roundedMilesPerHour;
    }

    public static void printConversion(double kilometersPerHour){
        double milesPerHour = toMilesPerHour(kilometersPerHour);
        if (kilometersPerHour < 0){
            System.out.println("Invalid Value");
        } else{
            System.out.println(kilometersPerHour + " km/h = " + milesPerHour + " mi/h");
        }
    }
}
