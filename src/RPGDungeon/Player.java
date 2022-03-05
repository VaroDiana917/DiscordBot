package RPGDungeon;

public class Player {
    public boolean playerDead;
    private int playerHealth;
    private int playerAttackDamage;

    public Player(int playerHealth, int playerAttackDamage) {
        this.playerDead = false;
        this.playerHealth = playerHealth;
        this.playerAttackDamage = playerAttackDamage;
    }

    public boolean isPlayerDead() {
        return playerDead;
    }

    public void setPlayerDead(boolean playerDead) {
        this.playerDead = playerDead;
    }

    public int getPlayerHealth() {
        return playerHealth;
    }

    public void setPlayerHealth(int playerHealth) {
        this.playerHealth = playerHealth;
    }

    public int getPlayerAttackDamage() {
        return playerAttackDamage;
    }

    public void setPlayerAttackDamage(int playerAttackDamage) {
        this.playerAttackDamage = playerAttackDamage;
    }
}
