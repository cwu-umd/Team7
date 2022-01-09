import java.util.HashSet;
import java.util.ArrayList;

public class Ghost{
	String myName;
	Location myLoc;
	Map myMap;

	public Ghost(String name, Location loc, Map map) {
		this.myLoc = loc;
		this.myName = name;
		this.myMap = map;
	}

	public ArrayList<Location> get_valid_moves() {
		return null;
	}

	public boolean move() {
		return false;
	}

	public boolean is_pacman_in_range() { 
		//This function checks its surroundings to see if PacMan is in attack range. 
		//The attack radius of a ghost is 1 which means that a ghost at location (x, y) 
		//can attack PacMan as long as PacMan is located at (x +- 1, y +- 1). 
		//If PacMan is in the attack range, this function returns true otherwise it returns false.

		Location north = myLoc.shift(0, 1);
		Location south = myLoc.shift(0, -1);
		Location east = myLoc.shift(1, 0);
		Location west = myLoc.shift(-1, 0);
		if (myMap.getLoc(north).contains(Map.Type.PACMAN)){
			return true;
		}
		else if (myMap.getLoc(south).contains(Map.Type.PACMAN)){
			return true;
		}
		else if (myMap.getLoc(east).contains(Map.Type.PACMAN)){
			return true;
		}
		else if (myMap.getLoc(west).contains(Map.Type.PACMAN)){
			return true;
		}
		return false;
	}

	public boolean attack() {
		return false;
	}
}
