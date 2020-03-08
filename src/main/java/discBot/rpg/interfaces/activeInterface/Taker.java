package discBot.rpg.interfaces.activeInterface;

import discBot.rpg.entities.EntityInterface;
import discBot.rpg.interfaces.passiveInterface.Takable;

public interface Taker extends EntityInterface{

	public default void take(Takable e) {
		e.take(this);
	}
}
