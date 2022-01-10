import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestGhostMove extends TestCase {

	public void testGhostMove() throws FileNotFoundException{
		NoFrame frame = new NoFrame(); //Creates A New Map With Walls and Tokens w/o a Display
		//MainFrame frame = new MainFrame();

		//Creating Players
		Ghost ghost = frame.addGhost(new Location(0, 1), "name", Color.red); //Creates a red ghost named "name" at location x,y
		Location l1 = ghost.get_valid_moves().get(0);
		assertEqual(ghost.myLoc,new Location(0, 1) );
		ghost.move();
		assertEqual(ghost.myLoc,l1 );
		
	
	}
}
