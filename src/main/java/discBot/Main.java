package discBot;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import discBot.rpg.Bot;

public class Main extends ListenerAdapter {

	public static void main(String[] args) throws LoginException, IOException {
		JDABuilder builder = new JDABuilder(AccountType.BOT);
		String token = "";
	    token = new String(Files.readAllBytes(Paths.get("token")));
		builder.setToken(token);
		builder.addEventListeners(Bot.getInstance());
		builder.build();
	}
}
