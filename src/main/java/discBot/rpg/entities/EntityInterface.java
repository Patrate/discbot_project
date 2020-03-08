package discBot.rpg.entities;

import discBot.rpg.map.Cell;

public interface EntityInterface {
	
	public void setContainer(Cell cell);
	
	public Cell getContainer();
	
	public String getCommonName();
}
