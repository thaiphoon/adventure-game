import java.util.Random;

public class Fight{
    /*
     *      Methods
     *          fight public - (Player object, Enemy object) // Could be Array opf Enemies
    */

    private boolean result = false;  // if player win,result = true.
    private int fightStamina = -1;

    public void fight (Player player, Enemy enemy){
        System.out.println("Fight!");
        Random random = new Random();
        result = random.nextBoolean();
        if (result){
            System.out.println("Player won the fight.");
            enemy.updateStamina(-fightStamina);
        }else{
            System.out.println("Player lost the fight.");
            player.updateStamina(-fightStamina);
        }
    }
}
