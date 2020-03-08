package discBot.rpg.entities;


import discBot.rpg.Player;
import discBot.rpg.interfaces.activeInterface.Messager;
import discBot.rpg.interfaces.activeInterface.User;
import discBot.rpg.map.World;

public class PlayerEntity extends Mover implements Messager, User{
	private Player player;
	
	public PlayerEntity(Player player) {
		super(-1, "🙂", player.getUser().getName());
		this.player = player;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	
	//====================================
	//=========== Actions ================
	//====================================
	
	public String lookAround() {
		return World.stringCellTable(getContainer().getNeighbor(1));
	}
	
	@Override
	public String getMessageAuthor() {
		return getCommonName();
	}
}
