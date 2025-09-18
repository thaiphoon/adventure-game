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
        map = new Map(9, 9, 1, 1, 0.2, 2, 16, 0.2);
        player = new Player(0, 100, 4, 4);
        showMap = new ShowMap();
    }

/*    public boolean testGame(){
        player.setyPos(player.getyPos() - 1);
        exploreArea(player.getxPos(), player.getyPos());

        player.setxPos(player.getxPos() - 1);
        exploreArea(player.getxPos(), player.getyPos());

        player.setyPos(player.getyPos() + 1);
        exploreArea(player.getxPos(), player.getyPos());

        player.setyPos(player.getyPos() + 1);
        exploreArea(player.getxPos(), player.getyPos());

        player.setxPos(player.getxPos() + 1);
        exploreArea(player.getxPos(), player.getyPos());

        player.setxPos(player.getxPos() + 1);
        exploreArea(player.getxPos(), player.getyPos());

        player.setyPos(player.getyPos() - 1);
        exploreArea(player.getxPos(), player.getyPos());

        player.setyPos(player.getyPos() - 1);
        exploreArea(player.getxPos(), player.getyPos());

        int goldTmp = 0;
        int enemyTmp = 0;
        boolean[] checkStatus = new boolean[9];

        for(int i = 0; i < map.getSquares().length; i++){
            for(int j = 0; j < map.getSquares()[i].length; j++){
                goldTmp += map.getSquares()[i][j].getTreasure().getGold();
                enemyTmp += map.getSquares()[i][j].getEnemies().length;
                checkStatus[j] = map.getSquares()[i][j].checkIfEnemiesKilled() && map.getSquares()[i][j].checkIfSquareExplored();
            }
        }

        int flagtest = 0;

        for(int k = 0; k < checkStatus.length; k++){
            if(checkStatus[k]){
                flagtest++;
            }
        }

        return ((goldTmp + enemyTmp) > 0) && (flagtest == 9);
    }*/

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
                    if(!checkIfInsideWorld(player.getxPos(), player.getyPos() - 1)){
                        System.out.println("Yaw mate stay on the island!!!");
                    }
                    else{
                        yPos -= 1;
                        player.setyPos(player.getyPos() - 1);
                    }
                    break;
                case "2":
                    if(!checkIfInsideWorld(player.getxPos() + 1, player.getyPos())){
                        System.out.println("Yaw mate stay on the island!!!");
                    }
                    else{
                        xPos += 1;
                        player.setxPos(player.getxPos() + 1);
                    }
                    break;
                case "3":
                    if(!checkIfInsideWorld(player.getxPos(), player.getyPos() + 1)){
                        System.out.println("Yaw mate stay on the island!!!");
                    }
                    else{
                        yPos += 1;
                        player.setyPos(player.getyPos() + 1);
                    }
                    break;
                case "4":
                    if(!checkIfInsideWorld(player.getxPos() - 1, player.getyPos())){
                        System.out.println("Yaw mate stay on the island!!!");
                    }
                    else{
                        xPos -= 1;
                        player.setxPos(player.getxPos() - 1);
                    }
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
            Square s = map.getSquares()[yNewPos][xNewPos];
            Enemy[] enemies = map.getSquares()[yNewPos][xNewPos].getEnemies();
            while (enemies.length != 0) {
                Enemy enemy = enemies[0];
                Enemy[] temp = new Enemy[enemies.length - 1];
                for (int i = 0; i < temp.length; i++) {
                    temp[i] = enemies[i + 1];
                }
                enemies = temp;
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
            map.getSquares()[player.getyPos()][player.getxPos()].setSquareExplored();
        }

    private boolean checkIfInsideWorld(int x, int y){
        return checkIfInsideWorldX(x) && checkIfInsideWorldY(y);
    }

    private boolean checkIfInsideWorldX(int x){
        return (x < this.map.getSquares()[0].length) && (x >= 0);
    }

    private boolean checkIfInsideWorldY(int y){
        return (y < this.map.getSquares().length) && (y >= 0);
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