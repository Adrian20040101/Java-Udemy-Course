public class OverloadedMethodsChallenge {
    public static void main(String[] args) {
        double height = convertToCentimeters(5,7);
        System.out.println("Tim's height measured in cm is " + height + " cm");
        height = convertToCentimeters(68);
        System.out.println("John's height measured in cm is " + height + " cm");
    }

    public static double convertToCentimeters(int height){
        return height * 2.54;
    }

    public static double convertToCentimeters(int heightInFeet, int heightInInches){
        double totalHeight = heightInFeet * 12 + heightInInches;
        return convertToCentimeters((int)totalHeight);
    }
}
