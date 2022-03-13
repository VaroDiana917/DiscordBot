package Main;



import RPGDungeon.*;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class MessageReactionsAdded extends ListenerAdapter {

    @Override
    public void onMessageReactionAdd(@NotNull MessageReactionAddEvent event) {
        super.onMessageReactionAdd(event);
        if(Objects.requireNonNull(event.getUser()).isBot()){
            return;
        }

        RPGGame rpgGame = Commands.getRpgGame();
        if(event.getReactionEmote().getName().equals("\uD83C\uDDEA") && !Objects.requireNonNull(event.getMember()).getUser().equals(event.getJDA().getSelfUser())) {
            rpgGame.setDifficulty(Difficulty.EASY);
            rpgGame.playGame(event);
        }
        if(event.getReactionEmote().getName().equals("Ⓜ️") && !Objects.requireNonNull(event.getMember()).getUser().equals(event.getJDA().getSelfUser())) {
            rpgGame.setDifficulty(Difficulty.MEDIUM);
            rpgGame.playGame(event);
        }
        if(event.getReactionEmote().getName().equals("\uD83C\uDDED") && !Objects.requireNonNull(event.getMember()).getUser().equals(event.getJDA().getSelfUser())) {
            rpgGame.setDifficulty(Difficulty.HARD);
            rpgGame.playGame(event);
        }

        if(event.getReactionEmote().getName().equals("⚔️") && !Objects.requireNonNull(event.getMember()).getUser().equals(event.getJDA().getSelfUser())) {
            rpgGame.attack(event);
        }


        if(event.getReactionEmote().getName().equals("\uD83D\uDC96") && !Objects.requireNonNull(event.getMember()).getUser().equals(event.getJDA().getSelfUser())) {
            rpgGame.heal(event);
        }


        if(event.getReactionEmote().getName().equals("\uD83D\uDCA8") && !Objects.requireNonNull(event.getMember()).getUser().equals(event.getJDA().getSelfUser())) {
            rpgGame.dash(event);
        }









    }
}
