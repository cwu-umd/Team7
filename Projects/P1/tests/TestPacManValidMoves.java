import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestPacManValidMoves extends TestCase {

	public void testPacManValidMoves() throws FileNotFoundException{
		NoFrame frame = new NoFrame(); //Creates A New Map With Walls and Tokens w/o a Display
		PacMan pacman = frame.addPacMan(new Location(0,0));
		//ArrayList<Location> l1 = new ArrayList<>();
		// ans1.add(new Location(1,3));
		// ans1.add(new Location(1,1));
		System.out.println(pacman.get_valid_moves().get(0));
		//assertEquals(ghost1.get_valid_moves(), ans1);

		//return null;
	}
}
