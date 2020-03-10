package discBot.rpg.entities;

import discBot.rpg.map.Cell;
import net.dv8tion.jda.api.entities.MessageChannel;

public interface EntityInterface {
	
	public void setContainer(Cell cell);
	
	public Cell getContainer();
	
	public String getCommonName();
	
	public MessageChannel getChannel();
}
