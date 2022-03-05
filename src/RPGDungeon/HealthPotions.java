package RPGDungeon;

public class HealthPotions {
    private Integer numHealthPotions;
    private Integer healthPotionHealAmount;
    private Integer healthPotionDropChance;

    public HealthPotions(Integer numHealthPotions, Integer healthPotionHealAmount, Integer healthPotionDropChance) {
        this.numHealthPotions = numHealthPotions;
        this.healthPotionHealAmount = healthPotionHealAmount;
        this.healthPotionDropChance = healthPotionDropChance;
    }

    public Integer getNumHealthPotions() {
        return numHealthPotions;
    }

    public void setNumHealthPotions(Integer numHealthPotions) {
        this.numHealthPotions = numHealthPotions;
    }

    public Integer getHealthPotionHealAmount() {
        return healthPotionHealAmount;
    }

    public void setHealthPotionHealAmount(Integer healthPotionHealAmount) {
        this.healthPotionHealAmount = healthPotionHealAmount;
    }

    public Integer getHealthPotionDropChance() {
        return healthPotionDropChance;
    }

    public void setHealthPotionDropChance(Integer healthPotionDropChance) {
        this.healthPotionDropChance = healthPotionDropChance;
    }
}
