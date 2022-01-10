import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestAttack extends TestCase {

	public void testAttack() throws FileNotFoundException{
		NoFrame frame1 = new NoFrame();
		Ghost ghost1 = frame1.addGhost(new Location(1, 1), "g1", Color.red);
		PacMan pacman1 = frame1.addPacMan(new Location(1, 2));
		assertTrue(ghost1.attack());

		NoFrame frame2 = new NoFrame();
		Ghost ghost2 = frame2.addGhost(new Location(3, 6), "g2", Color.red);
		Ghost ghost3 = frame2.addGhost(new Location(10, 9), "g3", Color.red);
		Ghost ghost4 = frame2.addGhost(new Location(4, 3), "g4", Color.red);
		PacMan pacman2 = frame2.addPacMan(new Location(3, 3));
		assertFalse(ghost2.attack());
		assertFalse(ghost3.attack());
		assertTrue(ghost4.attack());	
	}
}
