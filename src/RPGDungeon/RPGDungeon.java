package RPGDungeon;

public class RPGDungeon {
    private boolean running;
    private Difficulty difficulty;
    private Player player;
    private Enemy enemy;
    private HealthPotions healthPotions;

    public RPGDungeon(Difficulty difficulty) {
        this.running = true;
        this.difficulty = difficulty;
        if(difficulty == Difficulty.MEDIUM){
            this.player = new Player(100, 50);
            this.enemy = new Enemy(75, 25);
            this.healthPotions = new HealthPotions(3,25,50);
        }

    }

    public void playGame(){

    }
}
