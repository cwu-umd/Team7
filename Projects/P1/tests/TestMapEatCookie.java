import junit.framework.*;
import java.awt.Color;
import java.io.*;
import java.util.HashSet;

public class TestMapEatCookie extends TestCase {
	
	public void testMapEatCookie() throws FileNotFoundException {
		NoFrame frame = new NoFrame();
		PacMan pacman = frame.addPacMan(new Location(1, 1));

		assertTrue(frame.getMap().getLoc(new Location(1, 1)).contains(Map.Type.COOKIE));
		assertEquals(frame.getMap().getCookies(), 0);

		// pacman eats the cookie at (1,1)
		frame.getMap().eatCookie("pacman");
		assertFalse(frame.getMap().getLoc(new Location(1, 1)).contains(Map.Type.COOKIE));
		assertEquals(frame.getMap().getCookies(), 1);

		// pacman tries to eat the cookie at (1,1) again
		assertNull(frame.getMap().eatCookie("pacman"));
		assertEquals(frame.getMap().getCookies(), 1);
	}
}
