package discBot.rpg.interfaces.passiveInterface;

import discBot.rpg.entities.Entity;
import discBot.rpg.entities.EntityInterface;

public interface Attackable extends EntityInterface{
	public void attack(Entity who);
}
