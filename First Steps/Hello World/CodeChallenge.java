public class CodeChallenge {
    public static void main(String[] args) {
        double var1 = 20.00;
        double var2 = 80.00;
        double var3 = (var1 + var2) * 100.00;
        double remainder = var3 % 40.00;
        boolean isZero = remainder == 0 ? true : false;  //ternary operator used to verify if the remainder is zero or not
        System.out.println(isZero);
        if (!isZero){
            System.out.println("Got some remainder");
        }else{
            System.out.println("Remainder is zero");
        }

    }
}
