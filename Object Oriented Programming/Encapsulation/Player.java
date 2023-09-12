//this is a bad example of writing code and should be avoided (it doesn't include the concept of encapsulation

public class Player {

    public String name;
    public int health;
    public String weapon;

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
