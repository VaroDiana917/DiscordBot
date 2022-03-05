package Main;


import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Commands extends ListenerAdapter {
    public String prefix = "!";

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (!event.isFromGuild()) return;
        String[] args = event.getMessage().getContentRaw().split(" ");

        if (args[0].equalsIgnoreCase(prefix+"ping")){
            //event.getMessage().reply("Pong!").queue(); ->for replying
            event.getChannel().sendMessage("Pong!").queue();
        }

        if (args[0].equalsIgnoreCase(prefix+"help")){
            EmbedBuilder embedBuilder = new EmbedBuilder();
            embedBuilder.setTitle("Commands List:", "");
            embedBuilder.setDescription("A list of all of the commands:");

            embedBuilder.addField("Field title", "A description", false);

            event.getChannel().sendMessageEmbeds(embedBuilder.build()).queue();

        }
    }
}
