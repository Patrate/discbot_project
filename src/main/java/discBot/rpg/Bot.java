package discBot.rpg;

import java.util.stream.Collectors;

import discBot.DiscordHelper;
import discBot.rpg.entities.PlayerEntity;
import discBot.rpg.map.World;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Bot extends ListenerAdapter {

	// FIXME sauvegarder le channelm en fonction de l'emplacement de la session de jeu noice
	private MessageChannel currentChannel;
	
	private static Bot INSTANCE;
	
	public static Bot getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new Bot();
		}
		return INSTANCE;
	}
	
	private Bot() {};

	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		if (event.getAuthor().isBot()) {
			return;
		}
		currentChannel = event.getChannel();
		System.out.println("msg: " + event.getMessage().getContentRaw());
		
		String message = event.getMessage().getContentRaw();
		if(message.startsWith("!!")) {
			executeMasterCommand(message.substring(2), event);
		} else if (message.startsWith("!")) {
			executePlayerCommand(message.substring(1), event);
		}
	}
	
	private void executeMasterCommand(String command, MessageReceivedEvent event) {
		switch (command) {
		case "start":
			System.out.println("Generating new world");
			World.setWorld(new World());
			break;
		case "who":
			String s = String.join(", ", World.getWorld().getPlayers().stream()
					.map(o -> o.getPlayer().getUser().getName()).collect(Collectors.toList()));
			event.getChannel().sendMessage("Players: " + s).queue();
			break;

		default:
			break;
		}
	}
	
	private void executePlayerCommand(String command, MessageReceivedEvent event) {
		if(World.getWorld() == null) {
			System.out.println("world is null");
		}
		User user = event.getAuthor();
		PlayerEntity player = World.getWorld().addPlayer(user);
		if(player == null) {
			World.getWorld().message("Erreur lors de la récupération de " + user.getName() + ".");
			return;
		}
		
		switch (command) {
		case "look":
			player.message("*Regarde atour*");
			event.getChannel().sendMessage(player.lookAround()).queue();
			break;
		case "moveUp":
			player.moveUp();
			break;
		
		}
	}
	
	public static void message(String author, String message) {
		getInstance().message_(author, message);
	}
	
	private void message_(String author, String message) {
		if(currentChannel == null) {
			return; // TODO Throw exception
		}
		currentChannel.sendMessage(DiscordHelper.colorBlueHeading(author, message)).queue();
	}
}
