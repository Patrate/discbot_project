package discBot.rpg.interfaces.activeInterface;

import discBot.rpg.Bot;
import discBot.rpg.entities.EntityInterface;

public interface Messager extends EntityInterface {
	public abstract String getMessageAuthor();
	public default void message(String message) {
		Bot.message(getChannel(), getMessageAuthor(), message);
	}
}
