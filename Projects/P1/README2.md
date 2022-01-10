# Team 7: Project1

Team members: Emmy Denison, Josephine Palmhede, Robert Schmidt, Shira Shamouilian

--image of game play here ---

## How to Run Pacman

To play Pacman, run the following lines from the project directory in your command line:

```bash
javac -cp "src/" src/*.java
java -cp "src/" StartMenu
```

## Map Class

### move()
Implementation: Updates the locations HashSet, components HashSet, and field HashMap in the instance of the Map class. If the method is not able to successfully move the object it returns false, otherwise it returns true.

Test: The test creates a frame with a pacman and a ghost. It then moves pacman within range of the ghost and uses PacMan.is_ghost_in_range() to check if pacman moved. Then moves the ghost
out of range and performs the same check to see if the ghost was moved.

### getLoc()

Implementation: Returns the Value, HashSet of Types, associated with the given Key, Location, in the "field" HashMap.

Test: After creating a frame, a Pacman and Ghost were both added to the same location. The test checks that the result of getLoc() for the location the pacman and ghost were added to is equal to a HashSet containing Pacman, Ghost, and Cookie.

### attack()

Implementation: First finds the location of the chost based on the input name, if it doesn't exist
just returns false. From there it checks of the location up, down, left, or right contains packman.
If so it sets gameover to true, moves the ghost to where pacman is, and returns true.

Test: Creates a frame with packman and 5 ghosts, 4 ghosts are in the 4 possible locations where they could attack pacman and the last on is slightly too far away. Tests make sure all ghost within range correctly attack pacman while the one too far away returns false.

### eatCookie()

Implementation: The method controls Pacman eating a cookie. If there is NOT a cookie at pacman's location, null is returned. Otherwise if there is a cookie, the cookie's id is generated. (For example, the id for a cookie at (10, 1) is tok_x10_y1.) Then, components, locations, and field are updated to remove the cookie and cookies is incremented. This updates the display to show that a cookie has been eaten. The cookie JComponent that was removed from components is then returned. 

Test: A new MainFrame is created with PacMan at (1,1). The test first verifies that there is a cookie at (1,1) and that the cookies count is 0. Pacman then eats the cookie. The test then checks that there is no longer a cookie at (1,1) and that the cookie count is 1. Next, the test checks that null is returned if Pacman calls eatCookie again, because there is no longer a cookie at (1,1). 

## Ghost Class

### get_valid_moves()

Implementation: Checks the location above, below, left, and right of the ghost. If the location isn't null and is not a wall then adds the location to an arraylist. Returns arraylist at the end.

Test: Within a NoFrame environment makes sure an arraylist with all locations up, down, left, and right is returned. Within the MainFrame environment there is a wall above and below the ghost so it makes sure an arraylist with only the locations to the right and left is returned.

### move()

Implementation: Gets all of the possible moves by calling the get_valid_moves() method. If get_valid_moves returns an empty list move returns false. Otherwise, the current location of the ghost is updated in myLoc, the ghost moves in the map by calling Map.move() and true is returned.

Test: After creating a frame and a ghost at a location. The test checks that the location of the ghost is equal to the location it was initially created with. After calling the move function the test then checks that the ghost’s new location equals the first Location in the list of valid moves obtained by calling get_valid_moves..

### is_pacman_in_range()

Implementation: Checks all four cardinal directions around the ghost to see if PacMan is next to it using the conatins() method in the Location class. If any of the four directions contain pacman the method returns true. Otherwise it returns false.

Test: The first test creates a frame with a PacMan and one ghost within range. It checks that the is_pacman_in_range() method returns true. The second test creates a new frame with a Pacman and two gosts out of range. It then checks that the is_pacman_in_range() method returns false.

### attack()

Implementation: Checks to see if pacman is in range by calling the is_pacman_in_range method. If pacman is in range, the ghost attacks by calling the attack method from the Map class, which returns true if the ghost attack is successful. If pacman is not in range, this method returns false. 

Test: The first test creates a frame with one ghost and pacman in range. It tests that true is returned when the ghost attacks pacman. The second test has three ghosts, two with pacman out of range and one with pacman in range. The test checks that attack returns false for the ghosts out of range and returns true for the ghost in range.

## PacMan Class

### get_valid_moves()

Implementation: Checks the locations to each side (left, right, above, below) of pacman. If the location is in the map and it does not contain a wall the location is added to an arraylist of valid Locations. 

Test: Creats a pacman in he frame at location (1,1) and checks that the array list returned from get_valid_moves equals an array list of locations (1,2) and (2,1).

### move()

Implementation: Retrieves an arraylist of all valid moves using the get_valid_moves method. If the returned arraylist is empty returns false. Otherwise changes pacmans location to the first location within the arraylist and returns the result from the Map move method with the first location within the arraylist.

Test: Makes sure that both within a NoFrame environment and a MainFrame environment true is returned from running the move method.

### is_ghost_in_range()

Implementation: Checks whether any of the spaces directly above, below, left, or right of pacman contain a ghost. If there is a ghost in any of these spaces, returns true. Otherwise, returns false. 

Test: The first test creates a frame with pacman and a ghost next to each other and confirms that is_ghost_in_range returns true. The second test creates a frame with two ghosts outside of pacman's range and confirms that is_ghost_in_range returns false.

### consume()

Implementation: Checks to see if there is a 'power-cookie' located in Pacman's current coordinate. If there is, this method calls the eatCookie method from the Map Class, and returns the cookie component if the cookie a consumed, and null otherwise.

Test: Creates a frame with a PacMan and a cookie in the same location. Calls consume() once and checks that it returns the cookie, then calls it again to check that it returns null.
