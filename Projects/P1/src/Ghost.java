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
		ArrayList<Location> validLocations = new ArrayList<Location>();
		//dir 1
		Location loc1 = myLoc.shift(0, 1);
		if (myMap.getLoc(loc1) != null && !myMap.getLoc(loc1).contains(Map.Type.WALL)){
			validLocations.add(loc1);
		}
		//dir 2
		Location loc2 = myLoc.shift(1, 0);
		if (myMap.getLoc(loc2) != null && !myMap.getLoc(loc2).contains(Map.Type.WALL)){
			validLocations.add(loc2);
		}
		//dir 3
		Location loc3 = myLoc.shift(0, -1);
		if (myMap.getLoc(loc3) != null && !myMap.getLoc(loc3).contains(Map.Type.WALL)){
			validLocations.add(loc3);
		}
		//dir 4
		Location loc4 = myLoc.shift(-1, 0);
		if (myMap.getLoc(loc4) != null && !myMap.getLoc(loc4).contains(Map.Type.WALL)){
			validLocations.add(loc4);
		}
		return validLocations;
	}

	public boolean move() {
		ArrayList<Location> loc = this.get_valid_moves();
		if (!loc.isEmpty()){
			return false;
		}else{
			this.myLoc = loc.get(0);
			myMap.move(myName, loc.get(0), Map.Type.GHOST);
			return true;
		}
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
			return false;
		}
		else if (myMap.getLoc(south).contains(Map.Type.PACMAN)){
			return false;
		}
		else if (myMap.getLoc(east).contains(Map.Type.PACMAN)){
			return false;
		}
		else if (myMap.getLoc(west).contains(Map.Type.PACMAN)){
			return false;
		}
		return true;
	}

	public boolean attack() {
		if (!this.is_pacman_in_range()) {
			return myMap.attack(myName);
		} else {
			return false;
		}
	}
}
