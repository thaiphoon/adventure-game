import java.util.Random;

public class Main {
    /**
     * One loop untill dead or quiting
     * 3+ if-else scenarios
     * 2+ variables (e.g. gold, stamina)
     * 2+ methods/functions
     *
     * THEME: Pirate adventure
     * - looking for treasure on a lost island
     * - fighting enemies.
     *
     * Main Class
     * - One main method
     * - A loop with a switch-case structure
     *
     * TODO method createPlayer()
     * TODO method createEnemy()
     * TODO method createTreasure()
     *
     * OBJECTS
     * - Player
     *      Variables
     *          gold int private
     *          stamina int private
     *      Methods
     *          exploreArea public - no arguments (randomise find enemy / treasure)
     *          rest public - no arguments
     *          getStamina public - no arguments
     *          updateStamina public - int stamina (could be negative)
     *          getGold public - no arguments
     *          updateGold Public - int gold
     *
     * - Enemy
     *      Variables
     *          gold int private
     *          stamina int private
     *      Methods
     *          getStamina public - no arguments
     *          updateStamina public - int stamina (could be negative)
     *          getGold public - no arguments
     *
     * - Treasure
     *      Variables
     *          gold int private
     *      Methods
     *          getGold public - no arguments
     *
     * - Weapon
     *      Future release
     *
     * - Fight
     *      Methods
     *          fight public - (Player object, Enemy object) // Could be Array opf Enemies
     */
    private Random rand = new Random();
    public static void main(String[] args){
        // todo Loop with switch-case structure
    }


    private Enemy createEnemy(){

        //assign gold & stamina to Enemy randomly between numbers min-5, max-14 incl
        int stamina = rand.nextInt(5, 15);
        int gold = rand.nextInt(5, 15);

        return new Enemy(gold, stamina);
    }
}

