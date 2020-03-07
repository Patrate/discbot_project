package discBot.rpg.entities;

import java.awt.Point;

import discBot.rpg.Player;
import discBot.rpg.interfaces.Messager;
import discBot.rpg.interfaces.Takable;
import discBot.rpg.interfaces.Usable;
import discBot.rpg.map.World;

public class PlayerEntity extends Entity implements Messager{
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
	
	public void use(Usable e) {
		e.use(this);
	}
	
	public void take(Takable e) {
		e.take(this);
	}
	
	public String lookAround() {
		return World.stringCellTable(getContainer().getNeighbor(1));
	}
	
	public void move(int x, int y) {
		move(new Point(x, y));
	}
	
	public void move(Point p) {
		if(World.getWorld().getCell(p) == null) {
			return; //TODO throw Exception
		}
		getContainer().removeEntity(this);
		World.getWorld().getCell(p).addEntity(this);
	}
	
	public void moveUp() {
		int X = (int)this.getContainer().getCoordinate().getX();
		int Y = (int)this.getContainer().getCoordinate().getY() - 1;
		move(X, Y);
	}
	
	@Override
	public String getMessageAuthor() {
		return getCommonName();
	}
}
