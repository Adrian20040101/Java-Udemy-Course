public class EnhancedSwitchChallenge {
    public static void main(String[] args) {

        printDayOfWeek(4);
        printWeekDay(0);
        printNumberInWord(5);
        System.out.println("There are " + getDaysInMonth(2, 2000) + " days in the selected month of the selected year");
    }

    public static void printDayOfWeek(int day){
        String dayOfWeek = switch (day){
            case 0 -> "Sunday";
            //we can also type it inside curly braces, but then we would need to use the 'yield' keyword
            //e.g. case 0 -> { yield "Sunday"; }  this is commonly used when performing calculations, not needed here
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            default -> "Invalid Day";
        };

        System.out.println("The number " + day + " corresponds to " + dayOfWeek);
    }

    //bonus part -> an if statement that achieves the same result as the enhanced switch statement from above
    public static void printWeekDay(int day){
        String dayOfWeek = "Invalid Day";
        if (day == 0){
            dayOfWeek = "Sunday";
        } else if (day == 1){
            dayOfWeek = "Monday";
        } else if (day == 2) {
            dayOfWeek = "Tuesday";
        } else if (day == 3){
            dayOfWeek = "Wednesday";
        } else if (day == 4){
            dayOfWeek = "Thursday";
        } else if (day == 5){
            dayOfWeek = "Friday";
        } else if (day == 6) {
            dayOfWeek = "Saturday";
        }
        System.out.println("The number " + day + " corresponds to " + dayOfWeek);
    }

    //The methods from below are actually part of a coding exercise in udemy, but i just wanted to test the code here (so these two methods below weren't part of the CodeChallenge for which this class was actually created - nothing really important, just a quick note)
    public static void printNumberInWord(int number){
        String word = switch(number){
            case 0 -> "ZERO";
            case 1 -> "ONE";
            case 2 -> "TWO";
            case 3 -> "THREE";
            case 4 -> "FOUR";
            case 5 -> "FIVE";
            case 6 -> "SIX";
            case 7 -> "SEVEN";
            case 8 -> "EIGHT";
            case 9 -> "NINE";
            default -> "OTHER";
        };

        System.out.println(word);
    }

    public static boolean isLeapYear(int year){
        if(year < 1 || year > 9999){
            return false;
        }
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0){
            return true;
        }
        return false;
    }

    public static int getDaysInMonth(int month, int year){
        if ((month < 1 || month > 12) || (year < 1 || year > 9999)){
            return -1;
        }

        int totalDays;
        switch(month){
            case 1, 3, 5, 7, 8, 10, 12: totalDays = 31; break;
            case 2 : totalDays = isLeapYear(year) ? 29 : 28; break;
            case 4, 6, 9, 11: totalDays = 30; break;
            default: totalDays = -1; break;
        }

        return totalDays;
    }
}
