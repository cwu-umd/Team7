import junit.framework.*;
import java.awt.Color;
import java.io.*;
import java.util.ArrayList;

public class TestPacManValidMoves extends TestCase {

	public void testPacManValidMoves() throws FileNotFoundException{
		NoFrame frame = new NoFrame(); //Creates A New Map With Walls and Tokens w/o a Display
		PacMan pacman = frame.addPacMan(new Location(1,1));
		ArrayList<Location> l1 = new ArrayList<>();
		l1.add(new Location(1,2));
		l1.add(new Location(2,1));
		assertEquals(pacman.get_valid_moves(), l1);
	}
}
