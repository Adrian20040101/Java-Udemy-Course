public class SwitchChallenge {
    public static void main(String[] args) {
        // challenge consists in printing the word that has been associated to each letter in the NATO alphabet
        //for simplicity, we'll be only considering the letters A-E

        char letter = 'E';
        switch(letter){
            case 'A' : System.out.println("Able");
                       break;
            case 'B' : System.out.println("Baker");
                       break;
            case 'C' : System.out.println("Charlie");
                       break;
            case 'D' : System.out.println("Dog");
                       break;
            case 'E' : System.out.println("Easy");
                       break;
            default: System.out.println(letter + " is not a valid letter");
                       break;
        }
    }
}
