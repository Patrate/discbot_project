package discBot.rpg.botCommands;

import discBot.rpg.map.World;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class GenerateWorldCommand extends MasterCommand {

	public GenerateWorldCommand() {
		super("start");
	}

	@Override
	public void execute(MessageReceivedEvent event) {
		System.out.println("Generating new world");
		new World(event.getChannel());
	}

}
