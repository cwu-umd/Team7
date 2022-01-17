import java.util.HashMap;
import java.util.HashSet;
import javax.swing.JComponent;

public class Map{

	public enum Type {
		EMPTY,
		PACMAN,
		GHOST,
		WALL,
		COOKIE		
	}
	
	private HashMap<Location, HashSet<Type>> field;
	private boolean gameOver;
	private int dim;

	private HashMap<String, Location> locations;
	private HashMap<String, JComponent> components; 
	private HashSet<Type> emptySet;
	private HashSet<Type> wallSet; 

	private int cookies = 0;

	public Map(int dim){
		gameOver = false;
		locations = new HashMap<String, Location>();
		components = new HashMap<String, JComponent>();
		field = new HashMap<Location, HashSet<Type>>();

		emptySet = new HashSet<Type>();
		wallSet = new HashSet<Type>();
		emptySet.add(Type.EMPTY);
		wallSet.add(Type.WALL);
		this.dim = dim;
	}


	public void add(String name, Location loc, JComponent comp, Type type) {
		locations.put(name, loc);
		components.put(name, comp);
		if (!field.containsKey(loc)) field.put(loc, new HashSet<Type>());
		field.get(loc).add(type);
	}

	public int getCookies() {
		return cookies;
	}
	
	public boolean isGameOver() {
		return gameOver;
	}
		
	public boolean move(String name, Location loc, Type type) {
		//The method takes a name, location, and type and put the object specified by 
		//the name at the location. If the function is able to successfull move the object 
		//it returns true, otherwise it returns false.

		if(field.get(loc).contains(Map.Type.WALL)){
			//wall blocks move?
			return false;
		}
		//update locations
		Location oldLoc = locations.get(name);
		locations.replace(name, loc);
		//update components
		components.get(name).setLocation(loc.x, loc.y);
		//update field
		field.get(oldLoc).remove(type);
		field.get(loc).add(type);
		return false;
	}
	
	public HashSet<Type> getLoc(Location loc) {
		//wallSet and emptySet will help you write this method
		if (!field.containsKey(loc)){
			return field.get(loc);
		}
		return null;
	}

	public boolean attack(String Name) {
		//update gameOver
		Location currLoc = locations.get(Name);
		if (currLoc == null) return false;
		Location locNew = currLoc.shift(0, 2);
		if (this.getLoc(locNew) != null && this.getLoc(locNew).contains(Map.Type.PACMAN)){
			gameOver = true;
			this.move(Name, locNew, Map.Type.GHOST);
			return true;
		}
		locNew = currLoc.shift(1, 0);
		if (this.getLoc(locNew) != null && this.getLoc(locNew).contains(Map.Type.PACMAN)){
			gameOver = true;
			this.move(Name, locNew, Map.Type.GHOST);
			return true;
		}
		locNew = currLoc.shift(-1, 0);
		if (this.getLoc(locNew) != null && this.getLoc(locNew).contains(Map.Type.PACMAN)){
			gameOver = true;
			this.move(Name, locNew, Map.Type.GHOST);
			return true;
		}
		locNew = currLoc.shift(0, -1);
		if (this.getLoc(locNew) != null && this.getLoc(locNew).contains(Map.Type.PACMAN)){
			gameOver = true;
			this.move(Name, locNew, Map.Type.GHOST);
			return true;
		}
		
		return false;
	}
	
	public JComponent eatCookie(String name) {
		//update locations, components, field, and cookies
		//the id for a cookie at (10, 1) is tok_x10_y1

		Location pacmanLoc = locations.get(name);
		// if there is no cookie at pacman's location, return null
		if (!field.get(pacmanLoc).contains(Map.Type.COOKIE)) {
			return null;
		}
		// generate cookie's id
		String cookieId = "tok_x" + pacmanLoc.x + "_y" + pacmanLoc.y;

		JComponent cookie = components.remove(cookieId);
		locations.remove(cookieId);
		field.get(pacmanLoc).remove(Map.Type.COOKIE);
		cookies++;

		return cookie;
	}
}
