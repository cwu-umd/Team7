# Team 7: Project1

Team members: Emmy Denison, Josephine Palmhede, Robert Schmidt, Shira Shamouilian

--image of game play here ---

## How to Run Pacman

To play Pacman, run the following lines from the project directory in your command line:

```bash
//code to run pacman here
```

## Map Class

### move()
--discription of implimintation--

--dicription of test--

### getLoc()

Implementation: Returns the Value, HashSet of Types, associated with the given Key, Location, in the "field" HashMap.

Test: After creating a frame, a Pacman and Ghost were both added to the same location. The test checks that the result of getLoc() for the location the pacman and ghost were added to is equal to a HashSet containing Pacman, Ghost, and Cookie.

### attack()

--discription of implimintation--

--dicription of test--

### eatCookie()

--discription of implimintation--

--dicription of test--

## Ghost Class

### get_valid_moves()

--discription of implimintation--

--dicription of test--

### move()

Implementation: Gets all of the possible moves by calling the get_valid_moves() method. If get_valid_moves returns an empty list move returns false. Otherwise, the current location of the ghost is updated in myLoc, the ghost moves in the map by calling Map.move() and true is returned.

Test: After creating a frame and a ghost at a location. The test checks that the location of the ghost is equal to the location it was initially created with. After calling the move function the test then checks that the ghost’s new location equals the first Location in the list of valid moves obtained by calling get_valid_moves..

### is_pacman_in_range()

--discription of implimintation--

--dicription of test--

### attack()

--discription of implimintation--

--dicription of test--

## PacMan Class

### get_valid_moves()

Implementation: 

Test:

### move()

--discription of implimintation--

--dicription of test--

### is_ghost_in_range()

--discription of implimintation--

--dicription of test--

### consume()

--discription of implimintation--

--dicription of test--
