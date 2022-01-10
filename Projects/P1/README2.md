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

--dicription of test--

### eatCookie()

--discription of implimintation--

--dicription of test--

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

--discription of implimintation--

--dicription of test--

## PacMan Class

### get_valid_moves()

Implementation: 

Test:

### move()

Implementation: Retrieves an arraylist of all valid moves using the get_valid_moves method. If the returned arraylist is empty returns false. Otherwise changes pacmans location to the first location within the arraylist and returns the result from the Map move method with the first location within the arraylist.

Test: Makes sure that both within a NoFrame environment and a MainFrame environment true is returned from running the move method.

### is_ghost_in_range()

--discription of implimintation--

--dicription of test--

### consume()

Implementation: Checks to see if there is a 'power-cookie' located in Pacman's current coordinate. If there is, this method calls the eatCookie method from the Map Class, and returns the cookie component if the cookie a consumed, and null otherwise.

Test: Creates a frame with a PacMan and a cookie in the same location. Calls consume() once and checks that it returns the cookie, then calls it again to check that it returns null.
