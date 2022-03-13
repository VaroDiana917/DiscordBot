package RPGDungeon;

import java.util.Random;

public class Enemy {
    //private int maxEnemyHealth = 100;

    private Integer enemyAttackDamage;
    private Integer enemyHealth;
    private String enemy;

    public Enemy(Integer enemyHealth, Integer enemyAttackDamage, Difficulty difficulty) {
        Random random = new Random();

        String[] easyEnemies = {"Animated Armor", "Archer", "Ash Zombie", "Avatar of Death", "Awakened Tree", "Bandit", "Black Bear", "Black Viper", "Ghost"};
        String[] mediumEnemies = {"Animated Statue", "Archmage", "Beholder", "Iron Golem","Necromancer", "Nightwalker", "Troll", "Vampire"};
        String[] hardEnemies = {"Ancient Black Dragon", "Death Knight","Demogorgon", "Elder Tempest", "Kraken", "Leviathan", "Warforged Colossus"};

        if (difficulty==Difficulty.HARD) this.enemy = hardEnemies[random.nextInt(hardEnemies.length)];
        else if (difficulty==Difficulty.EASY) this.enemy = easyEnemies[random.nextInt(easyEnemies.length)];
        else this.enemy = mediumEnemies[random.nextInt(mediumEnemies.length)];
        //this.enemyHealth = random.nextInt(maxEnemyHealth);
        this.enemyHealth = enemyHealth;
        this.enemyAttackDamage = enemyAttackDamage;
    }

    public Integer getEnemyAttackDamage() {
        return enemyAttackDamage;
    }

    public void setEnemyAttackDamage(Integer enemyAttackDamage) {
        this.enemyAttackDamage = enemyAttackDamage;
    }

    public Integer getEnemyHealth() {
        return enemyHealth;
    }

    public void setEnemyHealth(Integer enemyHealth) {
        this.enemyHealth = enemyHealth;
    }

    public String getEnemy() {
        return enemy;
    }

    public void setEnemy(String enemy) {
        this.enemy = enemy;
    }
}
