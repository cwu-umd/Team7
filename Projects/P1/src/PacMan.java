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
		if (!myMap.getLoc(loc1).contains(Map.Type.WALL)){
			validLocations.add(loc1);
		}
		//dir 2
		Location loc2 = myLoc.shift(1, 0);
		if (!myMap.getLoc(loc2).contains(Map.Type.WALL)){
			validLocations.add(loc2);
		}
		//dir 3
		Location loc3 = myLoc.shift(0, -1);
		if (!myMap.getLoc(loc3).contains(Map.Type.WALL)){
			validLocations.add(loc3);
		}
		//dir 4
		Location loc4 = myLoc.shift(-1, 0);
		if (!myMap.getLoc(loc4).contains(Map.Type.WALL)){
			validLocations.add(loc4);
		}
		validLocations.add(new Location(1,2));
		return validLocations;		
	}

	public boolean move() {
		return false;
	}

	public boolean is_ghost_in_range() { 
		return false;
	}

	public JComponent consume() { 
 		return null;
	}
}
