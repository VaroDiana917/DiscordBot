package RPGDungeon;

public class HealthPotions {
    private int numHealthPotions;
    private int healthPotionHealAmount;
    private int healthPotionDropChance;

    public HealthPotions(int numHealthPotions, int healthPotionHealAmount, int healthPotionDropChance) {
        this.numHealthPotions = numHealthPotions;
        this.healthPotionHealAmount = healthPotionHealAmount;
        this.healthPotionDropChance = healthPotionDropChance;
    }

    public int getNumHealthPotions() {
        return numHealthPotions;
    }

    public void setNumHealthPotions(int numHealthPotions) {
        this.numHealthPotions = numHealthPotions;
    }

    public int getHealthPotionHealAmount() {
        return healthPotionHealAmount;
    }

    public void setHealthPotionHealAmount(int healthPotionHealAmount) {
        this.healthPotionHealAmount = healthPotionHealAmount;
    }

    public int getHealthPotionDropChance() {
        return healthPotionDropChance;
    }

    public void setHealthPotionDropChance(int healthPotionDropChance) {
        this.healthPotionDropChance = healthPotionDropChance;
    }
}
