package discBot.rpg.botCommands.playerCommands;

import discBot.rpg.Bot;
import discBot.rpg.entities.PlayerEntity;

public class LookCommand extends PlayerCommand {
	public LookCommand() {
		super("look");
	}
	
	@Override
	public void execute(PlayerEntity player, String[] args) {
		player.message("*Regarde atour*");
		Bot.getInstance().message(player.lookAround());
	}
}
