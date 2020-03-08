package discBot.rpg;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public enum Direction {
	UP(0,-1, new String[]{"up", "haut", "nord"}),
	DOWN(0,1, new String[]{"down", "bas", "sud"}),
	LEFT(-1,0, new String[]{"left", "gauche", "ouest"}),
	RIGHT(1,0, new String[]{"right", "droite", "est"});
	
	private int _x, _y;
	private Set<String> keywords;
	
	private Direction(int _x, int _y, String[] keywords) {
		this._x = _x;
		this._y = _y;
		this.keywords = new HashSet<String>(Arrays.asList(keywords));
	}
	
	public int getXmod() {return _x;}
	public int getYmod() {return _y;}
	public Set<String> getKeywords() { return keywords;}
	
	public static Direction getDirectionFromKeyword(String keyword) {
		for(Direction d:Direction.values()) {
			if(d.keywords.contains(keyword)) {
				return d;
			}
		}
		return null;
	}
}
