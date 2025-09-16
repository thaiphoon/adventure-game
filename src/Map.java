public class Map {

    private final Square[][] squares;

    /**
     * Constructor for building a new square map.
     * @param xSize : The xSize of the map.
     * @param ySize : The ySize of the map.
     * @param enemyMin : The minimum amount of enemies to generate.
     * @param enemyMax : The maximum amount of enemies to generate.
     * @param enemyChance : The chance of generating enemies.
     * @param treasureMin : The minimum amount of treasure to generate.
     * @param treasureMax : The maximum amount of treasure to generate.
     * @param treasureChance : The chance to generate any treasure.
     */
    public Map(int xSize, int ySize, int enemyMin, int enemyMax, double enemyChance, int treasureMin,
               int treasureMax, double treasureChance){
        this.squares = generateSquares(xSize, ySize, enemyMin, enemyMax, enemyChance, treasureMin, treasureMax, treasureChance);
    }

    /**
     *
     * @param xSize : The xSize of the map to be generated.
     * @param ySize : The ySize of the map to be generated.
     * @param enemyMin : The minimum amount of enemies to generate.
     * @param enemyMax : The maximum amount of enemies to generate.
     * @param enemyChance : The chance to generate any enemies.
     * @param treasureMin : The minimum amount of treasure to generate.
     * @param treasureMax : The maximum amount of treasure to generate.
     * @param treasureChance : The of generating any treasure.
     * @return : A complete map
     */
    private Square[][] generateSquares(int xSize, int ySize, int enemyMin, int enemyMax, double enemyChance,
                                       int treasureMin, int treasureMax, double treasureChance){
        Square[][] squares = new Square[ySize][xSize];
        for(int i = 0; i < squares.length; i++){
            for(int j = 0; j < squares[i].length; j++){
                if(!((i == ((squares.length - 1) / 2)) && (j == ((squares[i].length - 1) / 2)))){
                    squares[i][j] = new Square(enemyMin, enemyMax, enemyChance, treasureMin, treasureMax, treasureChance);
                }
                else{
                    squares[i][j] = new Square(0, 0, 0, 0, 0, 0);
                }
            }
        }
        return squares;
    }

    public Square[][] getSquares(){ return this.squares; }
}
