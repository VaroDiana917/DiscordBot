package Main;

import RPGDungeon.Difficulty;
import RPGDungeon.RPGDungeon;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class MessageReactionsAdded extends ListenerAdapter {

//    @Override
//    public void onMessageReactionAdd(@NotNull MessageReactionAddEvent event) {
//        super.onMessageReactionAdd(event);
//        if(event.getReactionEmote().getName().equals("Ⓜ️")) return Difficulty.MEDIUM;
//    }

    @Override
    public void onMessageReactionAdd(@NotNull MessageReactionAddEvent event) {
        super.onMessageReactionAdd(event);
        if(Objects.requireNonNull(event.getUser()).isBot()){
            return;
        }
        //CommandManager.runReactionCommand(e);
        System.out.println(event.getUser().getAsTag()+" "+event.getReactionEmote().getName());



    }
}
