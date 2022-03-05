package Main;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BotStartUp {
    public static void main(String[] args) throws LoginException {


        try {
            //get Discord Bot Token from file 
            File botTokenFile = new File("E:\\Facultate\\Projects\\DiscordBot\\DiscordBotToken.txt");
            Scanner myReader = new Scanner(botTokenFile);
            String botToken = myReader.nextLine();

            JDABuilder jda = JDABuilder.createDefault(botToken);

            jda.setActivity(Activity.playing("!help"));
            jda.setStatus(OnlineStatus.ONLINE); //Do not set to invisible or offline

            jda.addEventListeners(new Commands());
            jda.addEventListeners(new MessageReactionsAdded());

            jda.build();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }



    }
}
