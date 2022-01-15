import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestConsume extends TestCase {

	public void testConsume() throws FileNotFoundException {
		NoFrame frame = new NoFrame();
		PacMan pacman = frame.addPacMan(new Location(1, 1));
		CookieComponent cookie = new CookieComponent(1, 1, 1);

		// pacman eats the cookie at (1,1)
		pacman.consume();

		// pacman tries to eat the cookie at (1,1) again
		assertEquals(pacman.consume(), 5);
	}
}
