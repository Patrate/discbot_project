package discBot.rpg.botCommands;

import java.util.stream.Collectors;

import discBot.rpg.Bot;
import discBot.rpg.map.World;

public class WhoCommand extends MasterCommand {

	public WhoCommand() {
		super("start");
	}

	@Override
	public void execute(String[] param) {
		String s = String.join(", ", World.getWorld().getPlayers().stream()
				.map(o -> o.getPlayer().getUser().getName()).collect(Collectors.toList()));
		Bot.getInstance().message("Players: " + s);
	}

}
