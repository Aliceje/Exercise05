# Use of debugger

## Problem 1

We were setting up the Game class and had just finished methods for initializing
a game board, which we wanted to test. These methods are private, but they are invoked
by the Game constructor. In GameTest, before each method is executed a new game
is created, so by executing one test method we test the Game constructor
as well.

The test failed, this screenshot shows that several assertion errors occured:
[Screenshot P1](debugger1.PNG)

We put up a stop mark at the first line of the constructor ([see here](stop1.PNG)), 
ran the test with the debugger and stepped into the Game#addPlayers() method.
There, we found the source of the first assertion error: the Game
invariant said the *gameboard* variable must not be null,
but the game board was only set up after the players had been added
to the game inside the constructor.

First we just changed the order, since there was no assertion of 
the invariant inside the Game#initGameBoard() method that could fail.

But then we realized that we didn't have to assert the invariant at
all in these private methods, only after the constructor had called 
them all!

Twenty minutes later we also realized that there was a logical error
inside the invariant() method (an *assert* was used inside), which may have lead to some of the 
other assertion errors.
The constructor now created a new Game without errors.


## Problem 2

When calling the Game#move() method
inside the Game#main() method, 
an ArrayIndexOutOfBoundsException was thrown: [Screenshot P2](debugger4.PNG).

Using the debugger, we put up a mark at the Player#move() method.
This quickly solved another problem: inside this method, the player is first
asked to leave his current square. The variable *tile* of the player was
shown to be null, which is not what is to be expected, since the
player had already joined the game!

It turns out we didn't tell the player to enter the tile
inside the Player#joinGame() method, we only assigned the initial
tile's position to the player's *position* variable.

This the question of why the players weren't displayed on 
the game board when rendering it: The tiles didn't know that
the players were on them.

But our Exception was still raised, see [exception](outOfBoundsException4.PNG).
The debuggers messages show that inside the Game#findTile() method
-1 was entered as an array index. This is because in the 
Tile class, the position[] variable holds the position of the 
tile as its true indices on the gameboard[][] array.

This was different for the Player class, where the player's 
position[] variable was initially set using the 
superficial coordinates starting at (1,1) and not at (0,0), see
[Constructor](playerConstructor4.PNG).

By setting the player's position[] variable to the
coordinates according to the 2d gameboard array, the 
Game#findTile() method could be changed accordingly, see
[findTile()](findTileXY.PNG).

We ran the Game#main() method again and this time, no 
Exception was thrown.




