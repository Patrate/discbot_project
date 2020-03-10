package discBot.rpg.entities;

import discBot.rpg.map.Cell;
import net.dv8tion.jda.api.entities.MessageChannel;

public abstract class Entity implements EntityInterface {
	private int zPriority;
	private String img;
	private Cell container;
	private String commonName;
	
	public Entity(int zPriority, String img, String commonName) {
		this.zPriority = zPriority;
		this.img = img;
		this.commonName = commonName;
	}
	
	public int getZPriority() {
		return zPriority;
	}
	
	@Override
	public String toString() {
		return img;
	}
	
	public void setContainer(Cell cell) {
		container = cell;
	}
	
	public Cell getContainer() {
		return container;
	}
	
	public String getCommonName() {
		return commonName;
	}

	@Override
	public MessageChannel getChannel() {
		return getContainer().getWorld().getChannel();
	}
}
