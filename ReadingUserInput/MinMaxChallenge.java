import java.util.Scanner;

public class MinMaxChallenge {
    public static void main(String[] args) {

        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.print("Type a number; to quit type a non-numerical value, like a character: ");
            String input = scanner.nextLine();
            try{
                double number = Double.parseDouble(input);
                if (number < min) min = number;
                if (number > max) max = number;
            } catch (NumberFormatException badUserInput){
                break;
            }
        }
        System.out.println();
        if (min == Double.MAX_VALUE && max == Double.MIN_VALUE){
            System.out.println("No valid data has been entered");
        } else {
            System.out.println("The maximum number you have typed is " + max);
            System.out.println("The minimum number you have typed is " + min);
        }

        inputThenPrintSumAndAverage();
    }

    //this code below is part of a coding exercise from udemy; it is therefore not part of the CodeChallenge that this class was made for
    public static void inputThenPrintSumAndAverage(){
        Scanner scanner = new Scanner(System.in);
        long average = 0;
        long sum = 0;
        long counter = 0;
        while (true){
            String input = scanner.nextLine();
            try{
                long number = Long.parseLong(input);
                sum += number;
                counter++;
            } catch (NumberFormatException badUserInput){
                break;
            }
        }
        average = Math.round((double)sum / counter);
        if (counter == 0){
            System.out.println("SUM = 0 AVG = 0");
        } else {
            System.out.println("SUM = " + sum + " AVG = " + average);
        }
    }
}
