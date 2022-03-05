package RPGDungeon;

import java.util.Random;

public class Enemy {
    //private int maxEnemyHealth = 100;

    private Integer enemyAttackDamage;
    private Integer enemyHealth;
    private String enemy;

    public Enemy(Integer maxEnemyHealth, Integer enemyAttackDamage) {
        Random random = new Random();
        String[] enemies = {"Skeleton", "Zombie", "Warrior", "Assassin"};

        this.enemy = enemies[random.nextInt(enemies.length)];
        this.enemyHealth = random.nextInt(maxEnemyHealth);
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
