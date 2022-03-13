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

    public RPGGame() {
        this.player = new Player(100, 50);
        this.healthPotions = new HealthPotions(3,25,30);
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
        if(difficulty == Difficulty.EASY){
            this.enemy = new Enemy(75, 25, this.difficulty);
        }
        if(difficulty == Difficulty.MEDIUM){
            this.enemy = new Enemy(100, 50, this.difficulty);
        }
        if(difficulty == Difficulty.HARD){
            this.enemy = new Enemy(125, 50, this.difficulty);
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
                message.addReaction("\uD83D\uDC96").queue();
                message.addReaction("\uD83D\uDCA8").queue();
            });

            embedBuilder.clear();
        }
        else if (enemy.getEnemyHealth()<=0){
            EmbedBuilder embedBuilder = new EmbedBuilder();
            embedBuilder.setTitle("Congrats! You won!", "");
            embedBuilder.setDescription("You defeated the "+enemy.getEnemy());
            Random random = new Random();
            if(random.nextInt(100)<healthPotions.getHealthPotionDropChance()) {
                embedBuilder.addField("", "The " + enemy.getEnemy() + " dropped a health potion!", false);
                healthPotions.setNumHealthPotions(healthPotions.getNumHealthPotions()+1);
            }


            event.getChannel().sendMessageEmbeds(embedBuilder.build()).queue();
            embedBuilder.clear();


            EmbedBuilder embedBuilderPlayAgain = new EmbedBuilder();

            embedBuilderPlayAgain.setTitle("Play Again?");

            embedBuilderPlayAgain.addField("Easy", "Press \uD83C\uDDEA", false);
            embedBuilderPlayAgain.addField("Medium", "Press Ⓜ️", false);
            embedBuilderPlayAgain.addField("Hard", "Press \uD83C\uDDED", false);

            event.getChannel().sendMessageEmbeds(embedBuilderPlayAgain.build()).queue(message -> {
                message.addReaction("\uD83C\uDDEA").queue();
                message.addReaction("Ⓜ️").queue();
                message.addReaction("\uD83C\uDDED").queue();
            });
            embedBuilderPlayAgain.clear();
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
        embedBuilder.clear();
        playGame(event);

    }

    public void heal(MessageReactionAddEvent event){
        if(healthPotions.getNumHealthPotions()>0) {
            player.setPlayerHealth(player.getPlayerHealth() + healthPotions.getHealthPotionHealAmount());
            healthPotions.setNumHealthPotions(healthPotions.getNumHealthPotions()-1);

            EmbedBuilder embedBuilder = new EmbedBuilder();
            embedBuilder.addField("You drink a health potion, healing yourself for "+ healthPotions.getHealthPotionHealAmount(),
                    "You now have "+player.getPlayerHealth()+"HP♥\n" +
                            "You have "+ healthPotions.getNumHealthPotions()+" health potions left",
                    false);
            event.getChannel().sendMessageEmbeds(embedBuilder.build()).queue();
            embedBuilder.clear();//TODO
            playGame(event);
        }
        else{
            EmbedBuilder embedBuilder = new EmbedBuilder();
            embedBuilder.addField("You have no health potions left!",
                    "Defeat enemies for a chance to get one!",
                    false);
            event.getChannel().sendMessageEmbeds(embedBuilder.build()).queue();
            embedBuilder.clear();//TODO
            playGame(event);
        }
    }

    public void dash(MessageReactionAddEvent event){
        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.addField("You run away from the "+enemy.getEnemy(),
                "",
                false);
        event.getChannel().sendMessageEmbeds(embedBuilder.build()).queue();
        embedBuilder.clear();//TODO

        EmbedBuilder embedBuilderPlayAgain = new EmbedBuilder();

        embedBuilder.setTitle("Play Again?");

        embedBuilderPlayAgain.addField("Easy", "Press \uD83C\uDDEA", false);
        embedBuilderPlayAgain.addField("Medium", "Press Ⓜ️", false);
        embedBuilderPlayAgain.addField("Hard", "Press \uD83C\uDDED", false);

        event.getChannel().sendMessageEmbeds(embedBuilderPlayAgain.build()).queue(message -> {
            message.addReaction("\uD83C\uDDEA").queue();
            message.addReaction("Ⓜ️").queue();
            message.addReaction("\uD83C\uDDED").queue();
        });
        embedBuilderPlayAgain.clear();
    }
}
