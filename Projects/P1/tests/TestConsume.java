import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestConsume extends TestCase {

	public void testConsume() throws FileNotFoundException {
		MainFrame frame = new MainFrame();
		PacMan pacman = frame.addPacMan(new Location(1, 1));
		CookieComponent cookie = new CookieComponent(1, 1, 1);

		// pacman eats the cookie at (1,1)
		assertEquals(pacman.consume(), cookie);

		// pacman tries to eat the cookie at (1,1) again
		assertEquals(pacman.consume(), null);
	}
}
