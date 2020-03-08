package discBot.rpg.botCommands.playerCommands;

import discBot.rpg.botCommands.AbstractCommand;
import discBot.rpg.entities.PlayerEntity;
import discBot.rpg.exceptions.CommandException;

public abstract class PlayerCommand extends AbstractCommand {
	public PlayerCommand(String name) {
		super(name);
	}
	
	public abstract void execute(PlayerEntity player, String[] args) throws CommandException ;
	
	@Override
	public final void execute(String[] args) throws CommandException {
		throw new CommandException("Can't be called like this");
	}
}
