import java.util.Random;

public class Fight{
    /*
     *      Methods
     *          fight public - (Player object, Enemy object) // Could be Array opf Enemies
    */

    private boolean result = false;  // if player win,result = true.
    private Player player;
    private Enemy enemy;
    private int stamina = 1;

    public boolean fight(Player player, Enemy enemy){
        System.out.println("Fight!");
        Random random = new Random();
        result = random.nextBoolean();
        if (result){
            System.out.println("Player won the game.");
            player.updateStamina(this.stamina);
            enemy.updateStamina(-this.stamina);
        }else{
            System.out.println("Player lost the game.");
            player.updateStamina(-this.stamina);
            enemy.updateStamina(this.stamina);
        }
        return result;
    }
}
