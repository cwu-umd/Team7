import junit.framework.*;
import java.awt.Color;
import java.io.*;
import java.util.HashSet;

public class TestMapAttack extends TestCase {

	public void testMapAttack() throws FileNotFoundException{
		NoFrame frame1 = new NoFrame();
		Ghost ghost1 = frame1.addGhost(new Location(2, 2), "g1", Color.red);
		Ghost ghost2 = frame1.addGhost(new Location(1, 3), "g2", Color.blue);
		Ghost ghost3 = frame1.addGhost(new Location(0, 2), "g3", Color.blue);
		Ghost ghost4 = frame1.addGhost(new Location(1, 1), "g4", Color.blue);
		Ghost ghost5 = frame1.addGhost(new Location(1, 4), "g5", Color.blue);
		PacMan pacman1 = frame1.addPacMan(new Location(1, 2));
		assertTrue(frame1.getMap().attack("g1"));
		assertTrue(frame1.getMap().attack("g2"));
		assertTrue(frame1.getMap().attack("g3"));
		assertTrue(frame1.getMap().attack("g4"));
		//too far away
		assertFalse(frame1.getMap().attack("g5"));
	}
}
