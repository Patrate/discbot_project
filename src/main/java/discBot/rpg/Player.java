package discBot.rpg;

import net.dv8tion.jda.api.entities.User;

public class Player {
	private User user;
	
	public Player(User user) {
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}
}
