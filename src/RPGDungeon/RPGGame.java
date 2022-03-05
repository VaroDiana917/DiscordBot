package RPGDungeon;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;

import java.util.Random;

public class RPGGame {
    private Difficulty difficulty;
    private Player player;
    private Enemy enemy;
    private HealthPotions healthPotions;

//    public RPGGame(Difficulty difficulty) {
//        this.difficulty = difficulty;
//        if(difficulty == Difficulty.MEDIUM){
//            this.player = new Player(100, 50);
//            this.enemy = new Enemy(75, 25);
//            this.healthPotions = new HealthPotions(3,25,50);
//        }
//    }


    public RPGGame() {}

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
        if(difficulty == Difficulty.MEDIUM){
            this.player = new Player(100, 50);
            this.enemy = new Enemy(75, 25);
            this.healthPotions = new HealthPotions(3,25,50);
        }
    }

    public Player getPlayer() {
        return player;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public HealthPotions getHealthPotions() {
        return healthPotions;
    }

    public void playGame(MessageReactionAddEvent event){
        if (enemy.getEnemyHealth()>0 && player.getPlayerHealth()>0){
            EmbedBuilder embedBuilder = new EmbedBuilder();


            embedBuilder.setTitle("A wild "+enemy.getEnemy()+" has appeared!", "");
            embedBuilder.addField("Your HP: "+ player.getPlayerHealth().toString()+ "♥️","", false);
            embedBuilder.addField("Your AD: "+ player.getPlayerAttackDamage().toString()+ ":crossed_swords: ","", false);
            embedBuilder.addField("You have "+ healthPotions.getNumHealthPotions().toString()+ " potions that will heal you " + healthPotions.getHealthPotionHealAmount().toString()+ "HP","", false);
            embedBuilder.addField("Enemy's HP "+ enemy.getEnemyHealth().toString()+ ":black_heart: ","", false);
            embedBuilder.addField("Enemy's AD "+ enemy.getEnemyAttackDamage().toString()+ ":crossed_swords: ","", false);
            embedBuilder.addField("","", false);
            embedBuilder.addField("What do you wish to do?",":crossed_swords: Attack!\n♥️Drink health potion\n:dash: Run!", false);


            event.getChannel().sendMessageEmbeds(embedBuilder.build()).queue(message -> {
                message.addReaction("⚔️").queue();
                message.addReaction("♥️").queue();
                message.addReaction("\uD83D\uDCA8").queue();
            });

            embedBuilder.clear();
        }
        else if (enemy.getEnemyHealth()<=0){
            EmbedBuilder embedBuilder = new EmbedBuilder();
            embedBuilder.setTitle("Congrats! You won!", "");
            embedBuilder.setDescription("You defeated the "+enemy.getEnemy());
            event.getChannel().sendMessageEmbeds(embedBuilder.build()).queue();
            embedBuilder.clear();
        }
        else if (player.getPlayerHealth()<=0){
            EmbedBuilder embedBuilder = new EmbedBuilder();
            embedBuilder.setTitle("You lost!", "");
            embedBuilder.setDescription("The "+enemy.getEnemy()+" has defeated you...");
            event.getChannel().sendMessageEmbeds(embedBuilder.build()).queue();
            embedBuilder.clear();
        }
    }

    public void attack(MessageReactionAddEvent event){
        EmbedBuilder embedBuilder = new EmbedBuilder();
        Random random = new Random();
        Integer damageDealt = random.nextInt(player.getPlayerAttackDamage());
        Integer damageTaken = random.nextInt(enemy.getEnemyAttackDamage());

        enemy.setEnemyHealth(enemy.getEnemyHealth()-damageDealt);
        player.setPlayerHealth(player.getPlayerHealth()-damageTaken);

        embedBuilder.addField("You strike the "+enemy.getEnemy()+" for "+damageDealt,"", false);
        embedBuilder.addField("The "+ enemy.getEnemy()+ " strikes back for "+damageTaken,"", false);
        event.getChannel().sendMessageEmbeds(embedBuilder.build()).queue();
        //embedBuilder.clear();
        playGame(event);

    }
}
