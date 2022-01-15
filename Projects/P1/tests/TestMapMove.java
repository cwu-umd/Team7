import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestMapMove extends TestCase{

	public void testMapMove() throws FileNotFoundException{
		NoFrame frame = new NoFrame();
		PacMan pacman = frame.addPacMan(new Location(1, 1));
		Ghost ghost = frame.addGhost(new Location(1, 3), "ghost", Color.red);

		//try moving pacman
		assertTrue(frame.getMap().move("pacman", new Location(1, 2), Map.Type.PACMAN));

		//try moving ghost
		frame.getMap().move("ghost", new Location(1, 4), Map.Type.GHOST);
		assertTrue(pacman.is_ghost_in_range());


	}
}
