public class NumberToWordsChallenge {
    public static void main(String[] args) {

        numberToWords(200);
    }

    public static void numberToWords(int number){
        if (number < 0) System.out.println("Invalid Value");

        int reverseNumber = reverse(number);

        for (int i = 0; i < getDigitCount(number); i++) {
            if (reverseNumber % 10 == 0) {
                System.out.print("Zero ");
            } else if (reverseNumber % 10 == 1) {
                System.out.print("One ");
            } else if (reverseNumber % 10 == 2) {
                System.out.print("Two ");
            } else if (reverseNumber % 10 == 3) {
                System.out.print("Three ");
            } else if (reverseNumber % 10 == 4) {
                System.out.print("Four ");
            } else if (reverseNumber % 10 == 5) {
                System.out.print("Five ");
            } else if (reverseNumber % 10 == 6) {
                System.out.print("Six ");
            } else if (reverseNumber % 10 == 7) {
                System.out.print("Seven ");
            } else if (reverseNumber % 10 == 8) {
                System.out.print("Eight ");
            } else {
                System.out.print("Nine ");
            }
            reverseNumber /= 10;
        }
    }

    public static int reverse(int number){
        int reverse = 0;
        while (Math.abs(number) > 0) {
            reverse = reverse * 10 + number % 10;
            number /= 10;
        }
        return reverse;
    }

    public static int getDigitCount(int number){
        if (number < 0) return -1;
        if (number == 0) return 1;
        int digits = 0;
        while (number > 0){
            digits ++;
            number /= 10;
        }
        return digits;
    }
}
