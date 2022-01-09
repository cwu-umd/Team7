import java.util.HashSet;

import com.sun.jdi.Location;

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
		return validLocations;
	}

	public boolean move() {
		ArrayList<Location> loc = this.get_valid_moves();
		if (loc.isEmpty()){
			return false;
		}else{
			this.myLoc = loc.get(0);
			myMap.move(myName, loc.get(0), Map.Type.GHOST);
			return true;
		}
	}

	public boolean is_pacman_in_range() { 
		return false;
	}

	public boolean attack() {
		if (this.is_pacman_in_range()) {
			return myMap.attack(myName);
		} else {
			return false;
		}
	}
}
