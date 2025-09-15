public class Enemy{

  private int gold;
  private int stamina;

  public Enemy(int gold, int stamina) {
    this.gold = gold;
    this.stamina = stamina;
  }

  public int getGold() {
    return gold;
  }

  public int getStamina() {
    return stamina;
  }

  public void updateStamina(int stamina) {
    this.stamina += stamina;
  }
}
