import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestConsume extends TestCase {

	public void testConsume() throws FileNotFoundException {
		MainFrame frame = new MainFrame();
		PacMan pacman = frame.addPacMan(new Location(0, 0));
		CookieComponent cookie = new CookieComponent(0, 0, 1);

		// pacman eats the cookie at (0,0)
		assertEquals(pacman.consume(), cookie);

		// pacman tries to eat the cookie at (0,0) again
		assertEquals(pacman.consume(), null);
	}
}
