//overloaded methods must contain different parameter data types or a different number of parameters

public class OverloadedMethods {
    public static void main(String[] args) {

        calculateScore("Tim", 100);
        calculateScore(20);
    }

    public static int calculateScore(String playerName, int score){
        System.out.println(playerName + " has scored " + score + " points");
        return score * 100;
    }

    public static int calculateScore (int score){
        System.out.println("Anonymous player has scored " + score + " points");
        return score * 100;
    }
}
