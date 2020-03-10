package discBot.rpg.botCommands.playerCommands;

import discordBot.exceptions.CommandException;
import discBot.rpg.Bot;
import discBot.rpg.entities.PlayerEntity;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class LookCommand extends PlayerCommand {
	public LookCommand() {
		super("look");
	}
	
	@Override
	public void execute(MessageReceivedEvent event) throws CommandException {
		PlayerEntity player = getPlayer(event);
		player.message("*Regarde atour*");
		Bot.message(event.getChannel(), player.lookAround());
	}
}
