import java.util.Random;

public class Fight{
    /*
     *      Methods
     *          fight public - (Player object, Enemy object) // Could be Array opf Enemies
    */

    private static int fightStamina = 1;

    public static boolean fight (Player player, Enemy enemy){
        System.out.println("Fight!");
        Random random = new Random();
        // if player win,result = true.
        boolean result = true;
        if (result){
            System.out.println("Player won the fight.");
            enemy.updateStamina(-fightStamina);
        }else{
            System.out.println("Player lost the fight.");
            player.updateStamina(-fightStamina);
        }
        return result;
    }
}