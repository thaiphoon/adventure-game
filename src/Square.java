import java.util.Random;

public class Square {

    private Enemy[] enemies;
    private final Treasure treasure;
    private boolean enemiesKilled;
    private boolean squareExplored;

    /**
     * Contstructor for building a square
     * @param enemyMin : The minimum nr of enemies generated.
     * @param enemyMax : The maximum nr of enemies generated.
     * @param enemyChance : The chance of any enemies being generated.
     * @param treasureMin : The minimum amount of treasure generated.
     * @param treasureMax : The maximum amount of treasure generated.
     * @param treasureChance : The chance of any treasure being generated.
     */
    public Square(int enemyMin, int enemyMax, double enemyChance, int treasureMin, int treasureMax, double treasureChance){
        enemies = generateEnemies(enemyMin, enemyMax, enemyChance);
        treasure = generateTreasure(treasureMin, treasureMax, treasureChance);
    }

    /**
     *
     * @param enemyMin : The minimum amount of enemies generated.
     * @param enemyMax : The maximum amount of enemies generated.
     * @param enemyChance : The chance to generate enemies in the given square.
     * @return : An array of the enemies generated or an empty array if no enemies where generated.
     */
    private Enemy[] generateEnemies(int enemyMin, int enemyMax, double enemyChance){
        Random random = new Random();
        if((random.nextInt(0, 101) * 0.01) <= enemyChance){
            return populateEnemies(new Enemy[random.nextInt(enemyMin, enemyMax + 1)]);
        }
        enemiesKilled = true;
        return new Enemy[0];
    }

    /**
     *
     * @param enemies : The array to be populated by enemies.
     * @return : The array with enemies generated.
     */
    private Enemy[] populateEnemies(Enemy[] enemies){
        for(int i = 0; i < enemies.length; i++){
            enemies[i] = new Enemy(0, 10);
        }
        return enemies;
    }

    /**
     *
     * @param treasureMin : The minimum amount of tresaure to generate.
     * @param treasureMax : The maximum amount of treasure to generate.
     * @param treasureChance : The chance of any tresure being generated.
     * @return : The treasure generated, a treasure with no gold if no treasure where generated.
     */
    private Treasure generateTreasure(int treasureMin, int treasureMax, double treasureChance){
        Random random = new Random();
        if((random.nextInt(0, 101) * 0.01) <= treasureChance){
            return new Treasure(random.nextInt(treasureMin, treasureMax + 1));
        }
        return new Treasure(0);
    }

    public Enemy[] getEnemies(){ return this.enemies; }
    public void setEnemies(Enemy[] value){ this.enemies = value; }
    public Treasure getTreasure(){ return this.treasure; }
    public boolean checkIfEnemiesKilled(){ return this.enemiesKilled; }
    public void setAllEnemiesKilled(){ this.enemiesKilled = true; }
    public boolean checkIfSquareExplored(){ return this.squareExplored; }
    public void setSquareExplored(){ this.squareExplored = true; }
}
