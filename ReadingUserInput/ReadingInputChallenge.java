import java.util.Scanner;

public class ReadingInputChallenge {
    public static void main(String[] args) {

        int sum = 0;
        boolean valid;
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++){
            do {
                valid = true;
                System.out.print("Enter number #" + (i + 1) + ": ");
                String input = scanner.nextLine();
                try {
                    int number = Integer.parseInt(input);
                    sum += number;
                } catch (NumberFormatException badUserInput) {
                    System.out.println("You can only type in integer numbers, not characters");
                    valid = false;
                }
            }while(!valid);

        }
        System.out.println("The sum of the given numbers is " + sum);
    }
}
