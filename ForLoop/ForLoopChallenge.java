//CodeChallenge - print prime numbers from a range of number 0 - 1000.
//For simplicity, break out of the loop after 3 prime numbers that have been found

public class ForLoopChallenge {
    public static void main(String[] args) {
        //using the ternary operator to print out the results
        System.out.println("The number 1 is " + (isPrime(1) ? "" : "not " ) + "a prime number" );
        System.out.println("The number 2 is " + (isPrime(2) ? "" : "not " ) + "a prime number" );
        System.out.println("The number 8 is " + (isPrime(8) ? "" : "not " ) + "a prime number" );
        System.out.println("The number 17 is " + (isPrime(17) ? "" : "not " ) + "a prime number" );
        System.out.println("The number 24 is " + (isPrime(24) ? "" : "not " ) + "a prime number" );

        int counter = 0;
        for (int i = 0; i < 1000; i++){
            if (isPrime(i)){
                System.out.println(i + " is a prime number");
                counter++;
            }
            if (counter > 3){
                break;
            }
        }
    }

    public static boolean isPrime(int number){
        if (number <= 2){
            return (number == 2);
        }
        for (int divisor = 2; divisor <= number / 2; divisor++){
            if (number % divisor == 0){
                return false;
            }
        }
        return true;
    }
}
