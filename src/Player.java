public class Player{

    private int gold;
    private int stamina;

    public Player(int gold, int stamina){
        this.gold = gold;
        this.stamina = stamina;
    }

    public int getGold(){ return this.gold; }
    public int getStamina(){ return this.stamina; }
    public void updateStamina(int value){ this.stamina += value; }
    public void updateGold(int value){ this.gold += value; }
    public void rest(){ this.stamina++; }

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
