import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestGhostInRange extends TestCase {

	public void testGhostInRange() throws FileNotFoundException {
		NoFrame frame1 = new NoFrame();
		Ghost ghost1 = frame1.addGhost(new Location(1, 1), "g1", Color.red);
		PacMan pacman1 = frame1.addPacMan(new Location(1, 2));
		assertTrue(pacman1.is_ghost_in_range());

		NoFrame frame2 = new NoFrame();
		Ghost ghost2 = frame2.addGhost(new Location(5, 3), "g2", Color.red);
		Ghost ghost3 = frame2.addGhost(new Location(10, 9), "g3", Color.red);
		PacMan pacman2 = frame2.addPacMan(new Location(3, 3));
		assertFalse(pacman2.is_ghost_in_range());
	}
}
