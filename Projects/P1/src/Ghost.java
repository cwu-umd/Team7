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
		return null;
	}

	public boolean move() {
		ArrayList<Location> loc = this.get_valid_moves();
		if (loc.isEmpty()){
			return false;
		}else{
			this.myLoc = loc.get(0);
			myMap.move(myName, loc.get(0), Map.Type.GHOST)
			return true;
		}
	}

	public boolean is_pacman_in_range() { 
		return false;
	}

	public boolean attack() {
		return false;
	}
}
