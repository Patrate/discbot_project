package discBot.rpg;

import java.lang.reflect.InvocationTargetException;
import discordBot.AbstractBot;
import discordBot.DiscordHelper;
import discordBot.exceptions.CommandException;
import discordBot.exceptions.CommandNotFoundException;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.entities.MessageChannel;

public class Bot extends AbstractBot {

	private MessageChannel lastChannel;
	
	private static Bot INSTANCE;
	
	public static Bot getInstance() {
		if(INSTANCE == null) {
			try {
				INSTANCE = new Bot();
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException | LoginException e) {
				System.err.println("Erreur initialisation du bot: " + e.getMessage());
			}
		}
		return INSTANCE;
	}
	
	private Bot() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, LoginException {
		super("discBot.rpg");
	};
	
	public static void errorMessage(MessageChannel channel, String message) {
		//TODO formatage en rouge
		message(channel, message);
	}
	
	public static void message(MessageChannel channel, String message) {
		channel.sendMessage(message).queue();
	}
	
	public static void message(MessageChannel channel, String author, String message) {
		message(channel, DiscordHelper.colorBlueHeading(author, message));
	}

	@Override
	protected void commandNotFoundException(CommandNotFoundException e) {
		Bot.errorMessage(lastChannel, "Commande not found " + e.getMessage());
	}

	@Override
	protected void commandException(CommandException e) {
		Bot.errorMessage(lastChannel, e.getMessage());
	}
}
