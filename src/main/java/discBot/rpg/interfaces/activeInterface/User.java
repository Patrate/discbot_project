package discBot.rpg.interfaces.activeInterface;

import discBot.rpg.entities.EntityInterface;
import discBot.rpg.interfaces.passiveInterface.Usable;

public interface User extends EntityInterface{

	public default void use(Usable e) {
		e.use(this);
	}
}
