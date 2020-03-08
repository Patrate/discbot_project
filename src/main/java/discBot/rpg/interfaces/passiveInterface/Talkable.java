package discBot.rpg.interfaces.passiveInterface;

import discBot.rpg.entities.Entity;
import discBot.rpg.entities.EntityInterface;

public interface Talkable extends EntityInterface {
	public void talkTo(Entity who);
}
