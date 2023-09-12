public class SecondsAndMinutesChallenge {
    public static void main(String[] args) {

        getDurationString(3945);
        getDurationString(45, 65);
    }

    public static void getDurationString(int seconds){
        if (seconds <= 0){
            System.out.println("Invalid Input");
        } else {
            int hours = seconds / 3600;
            seconds -= hours * 3600;
            int minutes = seconds / 60;
            seconds -= minutes * 60;
            System.out.println(hours + "h " + minutes + "m " + seconds + "s ");
        }
    }

    public static void getDurationString(int seconds, int minutes){
        if (seconds <= 0 || seconds >= 60 || minutes <= 0){
            System.out.println("Invalid Input");
        } else {
            seconds += minutes * 60;
            getDurationString(seconds);
        }
    }
}
