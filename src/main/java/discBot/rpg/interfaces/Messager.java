package discBot.rpg.interfaces;

import discBot.rpg.Bot;

public interface Messager {
	public abstract String getMessageAuthor();
	public default void message(String message) {
		Bot.message(getMessageAuthor(), message);
	}
}
