package discBot.rpg.botCommands.playerCommands;

import discBot.rpg.Bot;
import discBot.rpg.Direction;
import discBot.rpg.entities.PlayerEntity;

public class MoveCommand extends PlayerCommand {
	public MoveCommand() {
		super("move");
	}
	
	@Override
	public void execute(PlayerEntity player, String[] param) {
		if(param.length < 2) {
			Bot.getInstance().message("Move where ?");
			return;
		}
		Direction direction = Direction.getDirectionFromKeyword(param[1]);
		if(direction == null) {
			Bot.getInstance().message("I didn't get where you wanna move.");
			return;
		}
		player.move(direction);
	}
}
