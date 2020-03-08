package discBot.rpg.interfaces.passiveInterface;

import discBot.rpg.entities.EntityInterface;
import discBot.rpg.interfaces.activeInterface.User;

public interface Usable extends EntityInterface{
	public void use(User user);
}
