package discBot.rpg.entities;

import discBot.rpg.Bot;
import discBot.rpg.interfaces.Takable;
import discBot.rpg.interfaces.Usable;

public class Beer extends Object implements Takable, Usable {
	public Beer() {
		super(10, "🍺", "Bière");
	}

	@Override
	public void use(Entity who) {
		Bot.message(who.getCommonName(), "*Boit une bière*");
	}

	@Override
	public void take(Entity who) {
		Bot.message(who.getCommonName(), "*Prend une bière*");
	}
}
