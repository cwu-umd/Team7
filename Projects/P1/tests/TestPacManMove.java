import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestPacManMove extends TestCase {

	public void testPacManMove() throws FileNotFoundException{
		NoFrame frame1 = new NoFrame();
		PacMan pacman1 = frame1.addPacMan(new Location(1, 2));
		assertTrue(pacman1.move());

		MainFame frame2 = new MainFrame();
		PacMan pacman2 = frame2.addPacMan(new Location(1, 2));
		assertTrue(pacman1.move());
	}
}
