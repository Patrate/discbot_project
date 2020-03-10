package discBot.rpg.entities.objects;

import discBot.rpg.Bot;
import discBot.rpg.interfaces.activeInterface.Taker;
import discBot.rpg.interfaces.activeInterface.User;
import discBot.rpg.interfaces.passiveInterface.Takable;
import discBot.rpg.interfaces.passiveInterface.Usable;

public class Beer extends Object implements Takable, Usable {
	public Beer() {
		super(10, "🍺", "Bière");
	}

	@Override
	public void use(User user) {
		Bot.message(user.getChannel(), user.getCommonName(), "*Boit une bière*");
	}

	@Override
	public void take(Taker taker) {
		Bot.message(taker.getChannel(), taker.getCommonName(), "*Prend une bière*");
	}
}
