public class SumOfDigitsChallenge {
    public static void main(String[] args) {

        System.out.println("Sum of the digits for the input number is " + sumDigits(147));
    }

    public static int sumDigits(int number){
        int sum = 0;
        if (number < 0) return -1;
        while (number > 0){
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
