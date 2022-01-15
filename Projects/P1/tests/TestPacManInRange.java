import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestPacManInRange extends TestCase {

	public void testPacManInRange() throws FileNotFoundException{
		NoFrame frame1 = new NoFrame();
		Ghost ghost1 = frame1.addGhost(new Location(1, 1), "g1", Color.red);
		PacMan pacman1 = frame1.addPacMan(new Location(1, 2));
		assertTrue(ghost1.is_pacman_in_range());

		NoFrame frame2 = new NoFrame();
		Ghost ghost2 = frame2.addGhost(new Location(1, 6), "g2", Color.red);
		Ghost ghost3 = frame2.addGhost(new Location(3, 9), "g3", Color.blue);
		PacMan pacman2 = frame2.addPacMan(new Location(3, 8));
		assertFalse(ghost2.is_pacman_in_range());
		assertTrue(ghost3.is_pacman_in_range());
	}
}
