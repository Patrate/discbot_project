package discBot.rpg.botCommands;

import discBot.rpg.exceptions.CommandException;

public abstract class AbstractCommand {
	private String name;
	
	public AbstractCommand(String name) {
		this.name = name;
	}
	
	public String getName() {return name;}
	
	public abstract void execute(String[] param) throws CommandException;
}
