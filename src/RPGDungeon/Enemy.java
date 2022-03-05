package RPGDungeon;

import java.util.Random;

public class Enemy {
    //private int maxEnemyHealth = 100;

    private int enemyAttackDamage;
    private int enemyHealth;
    private String enemy;

    public Enemy(int maxEnemyHealth, int enemyAttackDamage) {
        Random random = new Random();
        String[] enemies = {"Skeleton", "Zombie", "Warrior", "Assassin"};

        this.enemy = enemies[random.nextInt(enemies.length)];
        this.enemyHealth = random.nextInt(maxEnemyHealth);
        this.enemyAttackDamage = enemyAttackDamage;
    }

    public int getEnemyAttackDamage() {
        return enemyAttackDamage;
    }

    public void setEnemyAttackDamage(int enemyAttackDamage) {
        this.enemyAttackDamage = enemyAttackDamage;
    }

    public int getEnemyHealth() {
        return enemyHealth;
    }

    public void setEnemyHealth(int enemyHealth) {
        this.enemyHealth = enemyHealth;
    }

    public String getEnemy() {
        return enemy;
    }

    public void setEnemy(String enemy) {
        this.enemy = enemy;
    }
}
