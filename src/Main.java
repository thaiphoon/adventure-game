import java.io.IOException;
import java.util.Scanner;

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
     * DONE MOVED method createPlayer() - Could be local in the Main class or part of a Game Class
     * DONE MOVED method createEnemy() - Enemies are now instead generated in the Square object
     * DONE MOVED method createTreasure() - Treasures are now instead generated in the Square object
     *
     * OBJECTS
     * - Player
     *      Variables
     *          gold int private
     *          stamina int private
     *      Methods
     *          // DONE REMOVED exploreArea public - no arguments (randomise find enemy / treasure)
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
     *
     *  // TODO Class Game with methods createPlayer(), run(), and exploreArea()
     *  - Game
     *      Methods
     *          public run() - no arguments // Main menu with actions
     *
     *              PSEUDO CODE SUGGESTION - Game class and run() method
     *
     *              Game game = new Game;
     *
     *              game.run(){
     *                  Player player = new Player(someVars...)
     *                  Explore explore;
     *                  while(true){
     *                      explore = new Explore(xSize = 0, ySize = 0, ......)
     *                      explore -> fetch square from map
     *                      actions -> fight, flee....
     *
     *                      main switch(actions){
     *                      case 1: explore
     *                      case 0: end game
     *                      }
     *                  }
     *              }
     *
     *          public createPlayer() - no arguments
     *              Variables
     *                  int stamina (some fixed value starting out)
     *                  int gald (0)
     *                  int positionX
     *                  int positionY
     *
     *          exploreArea() - (int xNewPos, int yNewPos)
     *
     * Added Classes
     * - Explore (see Class)
     * - Map (see Class)
     * - Square (see Class)
     */

    public static void main(String[] args){
        Game game = new Game();
        game.run();

/*
>>>>>>> dd30ff522d23f6a1d5632f0eee8c24e569df64ac
        Explore explore = new Explore(9, 9, 1, 4, 0.3,
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
        ShowMap showMap = new ShowMap();
<<<<<<< HEAD
        showMap.showMap(explore.getMap().getSquares(), new Player(10, 10, 4, 4));
=======
        showMap.showMap(explore.getMap().getSquares(), new Player(0, 10, 4, 4));
        */
    }

    private static int printNrEnemies(Square square){
        return square.getEnemies().length;
    }

    private static int printTreasure(Treasure treasure){
        return treasure.getGold();
    }
}

