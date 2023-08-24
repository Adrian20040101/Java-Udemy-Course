public class Main {
    public static void main(String[] args) {

        //classic if-statement
        int value = 1;
        if (value == 1){
            System.out.println("Value was 1");
        } else if (value == 2){
            System.out.println("Value was 2");
        } else {
            System.out.println("Value was not 1 or 2");
        }

        //traditional switch statement
        int switchValue = 3;
        switch(switchValue){
            case 1: System.out.println("Value was 1");
                    break;
            case 2: System.out.println("Value was 2");
                    break;
            case 3: case 4: case 5: System.out.println("It was 3, 4 or 5");
                                    System.out.println("The actual value was " + switchValue);
                                    break;
            default: System.out.println("Value was not 1, 2, 3, 4 or 5");
                     break;
        }

        String month = "April";
        System.out.println(month + " is in the " + getQuarterOfTheYear(month) + " of the year");
    }

    //enhanced switch statement -> much more readable than the traditional one and also doesn't require to explicitly include the break after each case, nut the traditional one is still being used by some companies, so it is still good to know how the traditional one is written as well
    public static String getQuarterOfTheYear(String month){
        return switch(month){
            case "January", "February", "March" -> "1st quarter";
            case "April", "May", "June" -> "2nd quarter";
            case "July", "August", "September" -> "3rd quarter";
            case "October", "November", "December" -> "4th quarter";
            default -> "Invalid Month Input";
        };
    }
}
