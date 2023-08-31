//this is a good example of writing the same code, but using encapsulation

public class EnhancedPlayer {

    private String name;
    private int health;
    private String weapon;

    public EnhancedPlayer(String name, int health, String weapon) {
        this.name = name;
        this.health = health;
        this.weapon = weapon;
    }

    public EnhancedPlayer(String name) {
        this(name, 100, "Sub-Machine Gun");
    }

    public String getName(){
        return name;
    }

    public void loseHealth(int damage){
        health -= damage;
        if (health <= 0){
            System.out.println(name + " is dead");
        } else {
            System.out.println(name + " has lost " + damage + " HP");
        }
    }

    public void restoreHealth(int extraHealth) {
        health += extraHealth;
        if (health >= 100) {
            System.out.println(name + "'s health is fully restored");
            health = 100;
        } else {
            System.out.println(name + " has gained " + extraHealth + " HP");
        }
    }

    public int remainingHealth(){
        return health;
    }
}
