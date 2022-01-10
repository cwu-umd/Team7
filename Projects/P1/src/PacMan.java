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
		return null;	
	}

	public boolean move() {
		return false;
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
			return true;
		} else {
			return false;
		}
	}

	public JComponent consume() { 
 		return null;
	}
}
