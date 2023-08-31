public class Main {
    public static void main(String[] args) {

        //this is bad practice, explained why in the encapsulation.txt file

//        Player player = new Player();
//        player.name = "Captain Price";
//        player.health = 57;
//        player.weapon = "AK-47";
//
//        player.loseHealth(10);
//        System.out.println(player.name + " has got " + player.remainingHealth() + " HP left");
//        player.restoreHealth(54);
//        player.health = 200;
//        System.out.println(player.name + " has got " + player.remainingHealth() + " HP left");

        //this is how it should be done

        EnhancedPlayer player = new EnhancedPlayer("Ghost");
        player.loseHealth(20);
        System.out.println(player.getName() + " has got " + player.remainingHealth() + " HP left");
        player.restoreHealth(30);
        System.out.println(player.getName() + " has got " + player.remainingHealth() + " HP left");
        //player.health = 200;  a direct assignment like this one does not compile anymore, therefore encapsulation gives us more control over the code
    }
}
