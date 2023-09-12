//this method is of type void

public class Method1 {
    public static void main(String[] args) {

        calculateScore(true, 800, 100, 5);
        calculateScore(true, 10000, 200, 8);
    }

    public static void calculateScore(boolean gameOver, int score, int bonus, int levelCompleted){
        int finalScore = score;

        if (gameOver){
            finalScore += (levelCompleted * bonus);
            System.out.println("Your final score was " + finalScore);
        }
    }
}
