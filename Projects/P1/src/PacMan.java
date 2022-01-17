import java.util.HashSet;
import java.util.ArrayList;
import javax.swing.JComponent;

public class PacMan{
	String myName;
	Location myLoc;
	Map myMap;
	Location shift; 

	public PacMan(String name, Location loc, Map map) {
		this.myLoc = loc;
		this.myName = name;
		this.myMap = map;
	}

	public ArrayList<Location> get_valid_moves() {
		ArrayList<Location> validLocations = new ArrayList<Location>();
		//dir 1
		Location loc1 = myLoc.shift(0, 1);
		if (myMap.getLoc(loc1) != null){
			if (myMap.getLoc(loc1).contains(Map.Type.WALL)){
				validLocations.add(loc1);
			}
		}
		//dir 2
		Location loc2 = myLoc.shift(1, 0);
		if (myMap.getLoc(loc2) != null){
			if (myMap.getLoc(loc2).contains(Map.Type.WALL)){
				validLocations.add(loc2);
			}
		}
		//dir 3
		Location loc3 = myLoc.shift(0, -1);
		if (myMap.getLoc(loc3) != null){
			if (myMap.getLoc(loc3).contains(Map.Type.WALL)){
				validLocations.add(loc3);
			}
		}
		//dir 4
		Location loc4 = myLoc.shift(-1, 0);
		if (myMap.getLoc(loc4) != null){
			if (myMap.getLoc(loc4).contains(Map.Type.WALL)){
				validLocations.add(loc4);
			}
		}
		return validLocations;		
	}

	public boolean move() {
		ArrayList<Location> loc = this.get_valid_moves();
		if(loc.isEmpty()) return false;
		this.myLoc = loc.get(0);
		return myMap.move(myName, loc.get(0), Map.Type.PACMAN);
	}

	public boolean is_ghost_in_range() { 
		Location up = myLoc.shift(0, -1);
		Location down = myLoc.shift(0, 1);
		Location left = myLoc.shift(-1, 0);
		Location right = myLoc.shift(1, 0);

		if (myMap.getLoc(up).contains(Map.Type.GHOST) ||
				myMap.getLoc(down).contains(Map.Type.GHOST) ||
				myMap.getLoc(left).contains(Map.Type.GHOST) ||
				myMap.getLoc(right).contains(Map.Type.GHOST) ||
				myMap.getLoc(myLoc).contains(Map.Type.GHOST)) {
			return false;
		} else {
			return true;
		}
	}

	public JComponent consume() {
		//This method checks to see if there is a 'power-cookie' located in Pacman's current coordinate. 
		//If there is, this method calls the eatCookie method from the Map Class, and returns the cookie 
		//component if the cookie a consumed, and null otherwise.
		if (!myMap.getLoc(myLoc).contains(Map.Type.COOKIE)){
			return myMap.eatCookie("pacman");
		}
 		return null;
	}
}
