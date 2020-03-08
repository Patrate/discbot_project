package discBot.rpg;

import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.reflections.Reflections;

import discBot.DiscordHelper;
import discBot.rpg.botCommands.AbstractCommand;
import discBot.rpg.botCommands.MasterCommand;
import discBot.rpg.botCommands.playerCommands.PlayerCommand;
import discBot.rpg.entities.PlayerEntity;
import discBot.rpg.exceptions.CommandException;
import discBot.rpg.exceptions.CommandNotFoundException;
import discBot.rpg.map.World;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Bot extends ListenerAdapter {

	// FIXME sauvegarder le channel en fonction de l'emplacement de la session de jeu noice
	private MessageChannel currentChannel;
	private final Map<String, AbstractCommand> commandList;
	
	private static Bot INSTANCE;
	
	public static Bot getInstance() {
		if(INSTANCE == null) {
			try {
				INSTANCE = new Bot();
			} catch (InstantiationException | IllegalAccessException e) {
				System.err.println("Erreur initialisation du bot: " + e.getMessage());
			}
		}
		return INSTANCE;
	}
	
	private Bot() throws InstantiationException, IllegalAccessException {
		commandList = new HashMap<String, AbstractCommand>();
		Reflections reflections = new Reflections("discBot.rpg");
		Set<Class<? extends AbstractCommand>> allCommands =
				reflections.getSubTypesOf(AbstractCommand.class);
		for(Class<? extends AbstractCommand> command:allCommands) {
			if(Modifier.isAbstract(command.getModifiers())) {
				continue;
			}
			AbstractCommand newCommand = command.newInstance();
			commandList.put(newCommand.getName(), newCommand);
		}
		
	};

	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		if (event.getAuthor().isBot()) {
			return;
		}
		currentChannel = event.getChannel();
		System.out.println("msg: " + event.getMessage().getContentRaw());
		
		String message = event.getMessage().getContentRaw();
		if (!message.startsWith("!")) {
			return;
		}
		message = message.substring(1);
		String[] command = message.split(" ");
		try {
			executeCommand(command, event);
		} catch (CommandNotFoundException e) {
			Bot.errorMessage("Commande not found " + e.getMessage());
		} catch (CommandException e) {
			Bot.errorMessage(e.getMessage());
		}
	}
	
	private void executeCommand(String[] message, MessageReceivedEvent event) throws CommandNotFoundException, CommandException {
		AbstractCommand command = commandList.get(message[0]);
		if(command == null) {
			throw new CommandNotFoundException(message[0]);
		}
		if(command instanceof PlayerCommand) {
			if(World.getWorld() == null) {
				System.out.println("world is null");
			}
			User user = event.getAuthor();
			PlayerEntity player = World.getWorld().addPlayer(user);
			if(player == null) {
				World.getWorld().message("Erreur lors de la récupération de " + user.getName() + ".");
				return;
			}
			((PlayerCommand) command).execute(player, message);
		} else if(command instanceof MasterCommand) {
			command.execute(message);
		}
	}
	
	public static void errorMessage(String message) {
		//TODO formatage en rouge
		message(message);
	}
	
	public static void message(String message) {
		if(getInstance().currentChannel == null) {
			return; // TODO Throw exception
		}
		getInstance().currentChannel.sendMessage(message).queue();
	}
	
	public static void message(String author, String message) {
		getInstance().message_(author, message);
	}
	
	private void message_(String author, String message) {
		message(DiscordHelper.colorBlueHeading(author, message));
	}
}
