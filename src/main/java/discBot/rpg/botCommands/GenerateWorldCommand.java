package discBot.rpg.botCommands;

import discBot.rpg.map.World;

public class GenerateWorldCommand extends MasterCommand {

	public GenerateWorldCommand() {
		super("start");
	}

	@Override
	public void execute(String[] param) {
		System.out.println("Generating new world");
		World.setWorld(new World());
	}

}
