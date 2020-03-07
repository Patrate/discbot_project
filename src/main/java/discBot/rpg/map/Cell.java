package discBot.rpg.map;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import discBot.rpg.entities.Entity;

public class Cell {

	private final World world;
	private final Point coord;
	private final TreeSet<Entity> content;
	
	
	public Cell(World world, Point coord) {
		this.world = world;
		this.coord = coord;
		content = new TreeSet<Entity>(new Comparator<Entity>() {
			@Override
			public int compare(Entity o1, Entity o2) {
				return o1.getZPriority() - o2.getZPriority();
			}
		});
	}
	
	public void addEntity(Entity e) {
		content.add(e);
		e.setContainer(this);
	}
	
	public void removeEntity(Entity e) {
		if(!content.contains(e)) {
			return;
		}
		content.remove(e);
		e.setContainer(null);
	}
	
	@Override
	public String toString() {
		if(content.isEmpty()) {
			return "⬛";
		}
		return content.first().toString();
	}
	
	public Point getCoordinate() {
		return coord;
	}
	
	public World getWorld() {
		return world;
	}
	
	public List<Cell> getNeighbor(int range) {
		World world = getWorld();
		int _x = (int) coord.getX();
		int _y = (int) coord.getY();
		List<Cell> retour = new ArrayList<Cell>((int) (Math.pow((range * 2) + 1, 2)));
		for(int i = -range + _x; i <= range + _x; i++) {
			for(int j = -range + _y; j <= range + _y; j++) {
				retour.add(world.getCell(i, j));
			}
		}
		return retour;
	}
}
