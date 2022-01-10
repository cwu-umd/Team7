import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestPacManMove extends TestCase {

	public void testPacManMove() throws FileNotFoundException{
		NoFrame frame1 = new NoFrame();
		PacMan pacman1 = frame1.addPacMan(new Location(1, 2));
		System.out.println(pacman1.myLoc);
		Location loc = pacman1.get_valid_moves().get(0);
		assertTrue(pacman1.move());
		assertEquals(pacman1.myLoc, loc);
	}
}
