package discBot.rpg.botCommands.playerCommands;

import discordBot.exceptions.CommandException;
import discBot.rpg.Bot;
import discBot.rpg.Direction;
import discBot.rpg.entities.PlayerEntity;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class MoveCommand extends PlayerCommand {
	public MoveCommand() {
		super("move");
	}
	
	@Override
	public void execute(MessageReceivedEvent event) throws CommandException {
		PlayerEntity player = getPlayer(event);
		String[] param = getParams(event);
		if(param.length < 2) {
			Bot.message(event.getChannel(), "Move where ?");
			return;
		}
		Direction direction = Direction.getDirectionFromKeyword(param[1]);
		if(direction == null) {
			Bot.message(event.getChannel(), "I didn't get where you wanna move.");
			return;
		}
		player.move(direction);
	}
}
