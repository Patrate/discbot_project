package discBot.rpg.entities;

import java.awt.Point;

import discBot.rpg.Direction;
import discBot.rpg.map.Cell;

public abstract class Mover extends Entity {

	public Mover(int zPriority, String img, String commonName) {
		super(zPriority, img, commonName);
	}

	public void move(Direction direction) {
		int X = (int)this.getContainer().getCoordinate().getX() + direction.getXmod();
		int Y = (int)this.getContainer().getCoordinate().getY() + direction.getYmod();
		move(new Point(X, Y));
	}
	
	private void move(Point p) {
		Cell destination = this.getContainer().getWorld().getCell(p);
		if(destination == null) {
			return; //TODO throw Exception
		}
		getContainer().removeEntity(this);
		destination.addEntity(this);
	}
}
