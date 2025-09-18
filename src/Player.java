public class Player{

    private int gold;
    private int stamina;
    private int xPos;
    private int yPos;

    public Player(int gold, int stamina, int xPos, int yPos){
        this.gold = gold;
        this.stamina = stamina;
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public int getGold(){ return this.gold; }
    public int getStamina(){ return this.stamina; }
    public void updateStamina(int value){ this.stamina += value; }
    public void updateGold(int value){ this.gold += value; }
    public void rest(){ this.stamina++; }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }
    /*
     *      Variables
     *          gold int private
     *          stamina int private
     *      Methods
     *          rest public - no arguments
     *          getStamina public - no arguments
     *          updateStamina public - int stamina (could be negative)
     *          getGold public - no arguments
     *          updateGold Public - int gold
     */
}
