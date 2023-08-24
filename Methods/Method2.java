//this method is of type int (returns the value that we want to calculate)

public class Method2 {
    public static void main(String[] args) {

        int highScore = calculateScore(true, 800, 100, 5);
        System.out.println("Your highScore is " + highScore);
        //this is allowed since the method call is being interpreted as an integer value
        System.out.println("Your final score was: " + calculateScore(true, 10000, 200, 8));
    }

    public static int calculateScore(boolean gameOver, int score, int bonus, int levelCompleted){
        int finalScore = score;

        if (gameOver){
            finalScore += (levelCompleted * bonus);
        }
        return finalScore;
    }
}
