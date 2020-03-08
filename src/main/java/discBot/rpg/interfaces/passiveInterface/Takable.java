package discBot.rpg.interfaces.passiveInterface;

import discBot.rpg.entities.EntityInterface;
import discBot.rpg.interfaces.activeInterface.Taker;

public interface Takable extends EntityInterface {
	public void take(Taker taker);
}
