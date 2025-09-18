import java.util.Scanner;

public class Game {

    Scanner scanner;
    Map map;
    Player player;
    ShowMap showMap;
    int xPos = 0;
    int yPos = 0;

    public Game() {
        scanner = new Scanner(System.in);
        map = new Map(3, 3, 1, 1, 0.9, 2, 16, 0.9);
        player = new Player(0, 100, 1, 1);
        showMap = new ShowMap();
    }

    public void run() {
        while (true) {
            printDebug();
            showMap.showMap(map.getSquares(), player);

            System.out.println(" 1. Go north");
            System.out.println(" 2. Go east");
            System.out.println(" 3. Go south");
            System.out.println(" 4. Go west");
            System.out.println(" 5. Explore area");
            System.out.println(" 6. Rest");
            System.out.println(" 7. Exit");

            String tmp = scanner.nextLine();

            switch (tmp) {
                case "1":
                    yPos -= 1;
                    player.setyPos(player.getyPos() - 1);
                    break;
                case "2":
                    xPos += 1;
                    player.setxPos(player.getxPos() + 1);
                    break;
                case "3":
                    yPos += 1;
                    player.setyPos(player.getyPos() + 1);
                    break;
                case "4":
                    xPos -= 1;
                    player.setxPos(player.getxPos() - 1);
                    break;
                case "5":
                    exploreArea(player.getxPos(),player.getyPos());
                    break;
                case "6":
                    player.updateStamina(1);
                    break;
                case "7":
                    scanner.close();
                    System.exit(0);
                 }

            }

        }

        public void exploreArea(int xNewPos, int yNewPos){
            Square[][] ss = map.getSquares();
            Square s = ss[xNewPos][yNewPos];
            Enemy[] enemies = s.getEnemies();
            while (enemies.length != 0) {
                Enemy enemy = enemies[0];
                Enemy[] temp = new Enemy[enemies.length - 1];
                for (int i = 0; i < temp.length; i++) {
                    temp[i] = enemies[i + 1];
                }
                enemies = temp;
                // förutsätt att spelaren vinner
                boolean fightOutcome = Fight.fight(player, enemy);
                if (fightOutcome) {
                    map.getSquares()[yNewPos][xNewPos].setEnemies(new Enemy[0]);
                    map.getSquares()[yNewPos][xNewPos].setAllEnemiesKilled();
                } else {
                    System.out.println("Game Over!!!!");
                    System.exit(0);
                }

            }
            if(s.getTreasure().getGold() > 0){
                player.updateGold(s.getTreasure().getGold());
                System.out.println("You found: " + s.getTreasure().getGold() + " Gold");
                map.getSquares()[yNewPos][xNewPos].getTreasure().setGold(0);
            }
            map.getSquares()[yNewPos][xNewPos].setSquareExplored();
        }

    private void printDebug(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append("Square-coord(x, y) = ").append(j).append(" ").append(i).append(" ").
                        append("nrEnemies = ").append(printNrEnemies(map.getSquares()[i][j])).append(" ").
                        append("Treasure = ").append(printTreasure(map.getSquares()[i][j].getTreasure()));
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

/*
- Game
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
     *                  int gold (0)
     *                  int positionX
     *                  int positionY
     *
     *          exploreArea() - (int xNewPos, int yNewPos)
 */