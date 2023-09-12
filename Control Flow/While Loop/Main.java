public class Main {
    public static void main(String[] args) {

        int number = 5;
        int even = 0;
        int odd = 0;
        while (number <= 20){
            if (isEvenNumber(number)){
                even++;
                System.out.println("The number " + number + " is even");
            } else {
                odd++;
            }
            number++;
            if (even == 5){
                break;
            }
        }
        System.out.println("There are " + even + " even numbers and " + odd + " odd numbers");
    }
    public static boolean isEvenNumber(int number){
        return number % 2 == 0;
    }
}
