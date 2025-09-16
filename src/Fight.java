import java.util.Random;

public class Fight{
    /*
     *      Methods
     *          fight public - (Player object, Enemy object) // Could be Array opf Enemies
    */

    private boolean result = false;  // if player win,result = true.
    // private int fightStamina = 1;
    private final int fightStamina;
    private final Player player;
    private final Enemy enemy;

    public Fight(Player player, Enemy enemy, int fightStamina){
        this.player = player;
        this.enemy = enemy;
        this.fightStamina = fightStamina;
    }

    public boolean fightEnemy(Player player, Enemy enemy){
        System.out.println("Fight!");
        Random random = new Random();
        result = random.nextBoolean();
        if (result){
            System.out.println("Player won the game.");
            player.updateStamina(this.fightStamina);
            enemy.updateStamina(-this.fightStamina);
        }else{
            System.out.println("Player lost the game.");
            player.updateStamina(-this.fightStamina);
            enemy.updateStamina(this.fightStamina);
        }
        return result;
    }
}
