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
        map = new Map(9, 9, 1, 8, 0.1, 2, 16, 0.1);
        player = new Player(0, 100, 4, 4);
        showMap = new ShowMap();
    }

    public void run() {
        while (true) {
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
                    exploreArea(xPos,yPos);
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

                } else {
                    System.exit(0);
                }

            }
            Treasure booty = s.getTreasure();
            player.updateGold(booty.getGold());
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