package discBot.rpg.botCommands.playerCommands;

import discordBot.AbstractCommand;
import discordBot.exceptions.CommandException;
import discBot.rpg.entities.PlayerEntity;
import discBot.rpg.map.World;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public abstract class PlayerCommand extends AbstractCommand {
	public PlayerCommand(String name) {
		super(name);
	}
	
	public World getWorld(MessageReceivedEvent event) {
		return World.getWorld(event.getChannel());
	}
	
	public PlayerEntity getPlayer(MessageReceivedEvent event, World world) throws CommandException {
		User user = event.getAuthor();
		PlayerEntity player = world.addPlayer(user);
		if(player == null) {
			throw new CommandException("Erreur lors de la récupération de " + user.getName() + ".");
		}
		return player;
	}
	
	public PlayerEntity getPlayer(MessageReceivedEvent event) throws CommandException {
		World currentWorld = getWorld(event);
		if(currentWorld == null) {
			throw new CommandException("World is null");
		}
		return getPlayer(event, currentWorld);
	}
}
