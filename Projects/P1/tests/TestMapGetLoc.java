import junit.framework.*;
import java.awt.Color;
import java.io.*;
import java.util.HashSet;


public class TestMapGetLoc extends TestCase{
	
	public void testMapGetLoc() throws FileNotFoundException {
		NoFrame frame = new NoFrame(); //Creates A New Map With Walls and Tokens w/o a Display

		//Creating Players
		Ghost ghost = frame.addGhost(new Location(1, 1), "name", Color.red); //Creates a red ghost named "name" at location x,y
		PacMan pacman = frame.addPacMan(new Location(1, 1)); //Creates PacMan at location x, y
		HashSet<Map.Type> comp = new HashSet<Map.Type>();
		comp.add(Map.Type.COOKIE);
		comp.add( Map.Type.GHOST);
		comp.add( Map.Type.PACMAN);
		System.out.println(comp);
		assertEquals(frame.getMap().getLoc(new Location(1, 1)), comp);

	}
}
