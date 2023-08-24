//words that are BY DEFAULT colored in orange in the IntelliJ IDE are named keywords

public class Main {
    public static void main(String[] args) {
        int highscore = 50;
        if (highscore > 25){
            highscore += 1000;  //add some bonus points
        }

        //an expression is the result of manipulation of a variable, so for example, in the example below, "int health = 100;", the expression is just the part "health = 100"
        //in the following block of code there are 6 expressions to be found
        int health = 100;
        if ((highscore < 1000) && (health < 25)){
            highscore -= 1000;  //subtract points for having low health
        }
    }
}
