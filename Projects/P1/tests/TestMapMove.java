import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestMapMove {

	public void testMapMove() {
		MainFrame frame = new MainFrame();
		PacMan pacman = frame.addPacMan(new Location(0, 1));
		Ghost ghost = frame.addGhost(new Location(0, 3), "ghost", Color.red);

		//try moving pacman
		frame.getMap().move("pacman", new Location(0, 2), Map.Type.PACMAN);
		//use ghost in range to check if pacman moved
		assertTrue(pacman.is_ghost_in_range());

		//try moving ghost
		frame.getMap().move("ghost", new Location(0, 4), Map.Type.GHOST);
		assertFalse(pacman.is_ghost_in_range());


	}
}
