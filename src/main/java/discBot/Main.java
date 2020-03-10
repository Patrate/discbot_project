package discBot;
import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.hooks.ListenerAdapter;
import discBot.rpg.Bot;

public class Main extends ListenerAdapter {

	public static void main(String[] args) throws LoginException {
		Bot.getInstance();
	}
}
