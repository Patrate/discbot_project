package discBot.rpg.map;

import java.awt.Point;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import discBot.rpg.Bot;
import discBot.rpg.Player;
import discBot.rpg.entities.*;
import discBot.rpg.entities.objects.Beer;
import discBot.rpg.entities.objects.Wine;
import discBot.rpg.interfaces.activeInterface.Messager;
import net.dv8tion.jda.api.entities.User;

public class World implements Messager {
	
	private static World world = new World();
	private Map<Point, Cell> map;
	private Random random= new Random();
	private Map<String, PlayerEntity> players;
	
	public static World getWorld() {
		return world;
	}
	
	public static void setWorld(World w) {
		world = w;
	}
	
	public World() {
		map = new HashMap<Point, Cell>(81);
		generateWorld();
		players = new HashMap<String, PlayerEntity>();
	}
	
	private void generateWorld() {
		for(int i = -3; i < 3; i++) {
			for(int j = -3; j < 3; j++) {
				Point coord = new Point(i, j);
				Cell c = new Cell(this, coord);
				randomInit(c);
				map.put(coord, c);
			}
		}
	}
	
	private void randomInit(Cell c) {
		int randomInt = random.nextInt(3);
		switch(randomInt) {
			case 0:
				c.addEntity(new Beer());
				break;
			case 1:
				c.addEntity(new Wine());
				break;
			default:
				return;
		}
	}
	
	public PlayerEntity addPlayer(User user) {
		if(!players.containsKey(user.getId())) {
			return addPlayer(user, new Point(0, 0));
		} else {
			return getPlayer(user);
		}
	}
	
	private PlayerEntity addPlayer(User user, Point p) {
		Player player = new Player(user);
		PlayerEntity pe = new PlayerEntity(player);
		getCell(p).addEntity(pe);
		players.put(user.getId(), pe);
		return pe;
	}
	
	public Cell getCell(int x, int y) {
		return getCell(new Point(x, y));
	}
	
	public Cell getCell(Point p) {
		return map.get(p);
	}
	
	public Collection<PlayerEntity> getPlayers(){
		return players.values();
	}
	
	public PlayerEntity getPlayer(User user) {
		return players.get(user.getId());
	}
	
	@Override
	public String getMessageAuthor() {
		return "World";
	}
	
	public static String stringCellTable(List<Cell> table) {
		StringBuilder sb = new StringBuilder();
		int rowSize = (int) Math.sqrt(table.size());
		for(int i = 0; i < rowSize; i++) {
			for(int j = 0; j < rowSize; j++) {
				Cell c = table.get(i * rowSize + j);
				if(c != null) {
					sb.append(c.toString());
				}
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public void message(String message) {
		Bot.message("World", message);
	}
}
