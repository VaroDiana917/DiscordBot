package Main;

import RPGDungeon.*;
import net.dv8tion.jda.api.EmbedBuilder;
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
        if(event.getReactionEmote().getName().equals("Ⓜ️") && !Objects.requireNonNull(event.getMember()).getUser().equals(event.getJDA().getSelfUser())) {
            rpgGame.setDifficulty(Difficulty.MEDIUM);
            rpgGame.playGame(event);
        }

        if(event.getReactionEmote().getName().equals("⚔️") && !Objects.requireNonNull(event.getMember()).getUser().equals(event.getJDA().getSelfUser())) {
            System.out.println("Here!");
            rpgGame.attack(event);
        }



    }
}
