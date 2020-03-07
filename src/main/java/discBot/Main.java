package discBot;
import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import discBot.rpg.Bot;

public class Main extends ListenerAdapter {

	public static void main(String[] args) throws LoginException {
		JDABuilder builder = new JDABuilder(AccountType.BOT);
		String token = "Njg1MTA3OTQ2MjQ1NzE4MDYz.XmD2yw.XlqDdLyu7tLh48zyPGowlcpqQFY";
		builder.setToken(token);
		//builder.addEventListeners(new Main());
		builder.addEventListeners(Bot.getInstance());
		builder.build();
	}
	
	public void onMessageReceived(MessageReceivedEvent event) {
		if(event.getAuthor().isBot()) {
			return;
		}
		
		System.out.println("Message from " + 
				event.getAuthor().getName() + ": " + 
				event.getMessage().getContentDisplay());
		
		if("!ping".equals(event.getMessage().getContentRaw())) {
			event.getChannel().sendMessage("Pong !").queue();
		}
		
	}

}
