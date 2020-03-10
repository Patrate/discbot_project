package discBot.rpg.botCommands;

import java.util.stream.Collectors;

import discBot.rpg.Bot;
import discBot.rpg.map.World;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class WhoCommand extends MasterCommand {

	public WhoCommand() {
		super("start");
	}

	@Override
	public void execute(MessageReceivedEvent event) {
		String s = String.join(", ", World.getWorld(event.getChannel()).getPlayers().stream()
				.map(o -> o.getPlayer().getUser().getName()).collect(Collectors.toList()));
		Bot.message(event.getChannel(), "Players: " + s);
	}

}
