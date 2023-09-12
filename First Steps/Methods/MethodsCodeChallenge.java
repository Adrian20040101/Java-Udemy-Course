public class MethodsCodeChallenge {
    public static void main(String[] args) {

        int position = calculateHighScorePosition(1500);
        displayHighScorePosition("Tim", position);
        position = calculateHighScorePosition(1000);
        displayHighScorePosition("Alex", position);
        position = calculateHighScorePosition(500);
        displayHighScorePosition("John", position);
        position = calculateHighScorePosition(100);
        displayHighScorePosition("Chris", position);
        position = calculateHighScorePosition(25);
        displayHighScorePosition("Jimmy", position);

    }

    public static void displayHighScorePosition(String playerName, int playerPosition){
        System.out.println(playerName + " managed to get into position " + playerPosition + " on the" +
                " high score list");
    }

    public static int calculateHighScorePosition(int playerScore){
        if (playerScore >= 1000){
            return 1;
        } else if (playerScore >= 500){
            return 2;
        } else if (playerScore >= 100){
            return 3;
        }
        return 4;
    }
}
