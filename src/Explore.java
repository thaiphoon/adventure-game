public class Explore {

    private final Map map;

    public Explore(int xSize, int ySize, int enemyMin, int enemyMax, double enemyChance, int treasureMin,
                   int treasureMax, double treasureChance){
        this.map = new Map(xSize, ySize, enemyMin, enemyMax, enemyChance, treasureMin, treasureMax, treasureChance);
    }

    /**
     *
     * @param x : The xPosition of the square to be explored.
     * @param y : The yPosition of the square to be explored.
     * @return : The square if it is inside the map and not the starting position, otherwise null.
     */
    public Square exploreSquare(int x, int y){
        if(checkIfInsideWorld(x, y)) {
            if (checkIfSingleSquare()) {
                return this.map.getSquares()[0][0];
            } else{
                return this.map.getSquares()[y][x];
            }
        }
        return null;
    }

    public Map getMap(){ return this.map; }

    private boolean checkIfSingleSquare(){ return (checkIfSingleSquareY() && checkIfSingleSquareX()); }

    private boolean checkIfSingleSquareX(){ return (this.map.getSquares()[0].length == 1); }

    private boolean checkIfSingleSquareY(){ return (this.map.getSquares().length == 1); }

    private boolean checkIfInsideWorld(int x, int y){
        return checkIfInsideWorldX(x) && checkIfInsideWorldY(y);
    }

    private boolean checkIfInsideWorldX(int x){
        return (x < this.map.getSquares()[0].length) && (x >= 0);
    }

    private boolean checkIfInsideWorldY(int y){
        return (y < this.map.getSquares().length) && (y >= 0);
    }
}
