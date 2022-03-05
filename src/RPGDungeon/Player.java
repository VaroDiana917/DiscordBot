package RPGDungeon;

public class Player {
    public boolean playerDead;
    private Integer playerHealth;
    private Integer playerAttackDamage;

    public Player(Integer playerHealth, Integer playerAttackDamage) {
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

    public Integer getPlayerHealth() {
        return playerHealth;
    }

    public void setPlayerHealth(Integer playerHealth) {
        this.playerHealth = playerHealth;
    }

    public Integer getPlayerAttackDamage() {
        return playerAttackDamage;
    }

    public void setPlayerAttackDamage(Integer playerAttackDamage) {
        this.playerAttackDamage = playerAttackDamage;
    }
}
