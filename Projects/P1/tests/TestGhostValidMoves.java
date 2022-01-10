import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestGhostValidMoves extends TestCase {

	public void testGhostValidMoves() throws FileNotFoundException{
		MainFrame frame1 = new MainFrame();
		Ghost ghost1 = frame1.addGhost(new Location(1, 2), "g1", Color.red);
		ArrayList<Location> ans1 = new ArrayList<>();
		ans1.add(new Location(1,3));
		ans1.add(new Location(1,1));
		assertEquals(ghost1.get_valid_moves(), ans1);

		NoFrame frame2 = new NoFrame();
		Ghost ghost2 = frame2.addGhost(new Location(2, 2), "g2", Color.red);
		ArrayList<Location> ans2 = new ArrayList<>();
		ans2.add(new Location(2,3));
		ans2.add(new Location(3,2));
		ans2.add(new Location(2,1));
		ans2.add(new Location(1,2));
		assertEquals(ghost2.get_valid_moves(), ans2);

	}
}
