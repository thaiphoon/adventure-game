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
    public static void main(String[] args) {

        Explore explore = new Explore(9, 9, 1, 4, 0.8,
                0, 101, 0.8);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                    sb.append("Square-coord(x, y) = ").append(j).append(" ").append(i).append(" ").
                            append("nrEnemies = ").append(printNrEnemies(explore.exploreSquare(j, i))).append(" ").
                            append("Treasure = ").append(printTreasure(explore.exploreSquare(j, i).getTreasure()));
                    System.out.println(sb.toString());
                    sb  = new StringBuilder();
            }
        }
    }

    private static int printNrEnemies(Square square){
        return square.getEnemies().length;
    }

    private static int printTreasure(Treasure treasure){
        return treasure.getGold();
    }
}

