package exercise05;

/**
 * Represents a single player in the Quoridor game {@link Game}.
 *
 * A player has a name and a symbol for his representation
 * on the game board.
 *
 * He knows which tile he is currently on
 * and on which tile he started.
 *
 * He has a certain amount of {@link Wall} instances that he can put up
 * during the game.
 *
 * Implements the {@link TileOccupier} Interface.
 */
public class Player implements TileOccupier{

    private String name, symbol, targetSide;
    private Tile tile;
    private int[] initialPosition;
    private boolean winner; // needed, or only Game responsibility?
    private int wallsSet;
    private boolean wallsLimitReached; // needed, or only Game responsibility?

    /**
     * Class invariant: Conditions that must always hold
     * after the Player has joined the game.
     *
     * @return true if invariant states have not been modified
     */
    private boolean invariant(){
       return name != null
                && symbol != null
                && tile != null
                && targetSide != null;
    }

    /**
     * Sets up a new Player with a name, a symbol and the coordinates
     * of his initial Tile.
     *
     * @param name String the players name
     * @param symbol String the players symbol on the game board
     */
    public Player(String name, String symbol, int x, int y, String target){
        this.name = name;
        this.symbol = symbol;
        targetSide = target;
        initialPosition = new int[]{(x-1), (y-1)};
        winner = false;
        wallsSet = 0;
        wallsLimitReached = false;
    }

    /**
     * A 'nobody' Player with no properties.
     */
    public Player(){}

    /**
     * Lets the player join a game.
     * Initializes the player's Tile and
     * enters the player into that Tile.
     *
     * @param game the Game the player joins
     */
    public void joinGame(Game game){
        int x = initialPosition[0];
        int y = initialPosition[1];
        tile = game.findTile(x, y);
        tile.enter(this);
        assert invariant();
    }

    public boolean reachedTargetSide(){ return false; } //TO DO

    //if player has won move to "heaven"
    public void takeOffBoard(){
        //TO DO
    }

    /**
     * Boolean flag for use in other classes.
     * For example inside the {@link Tile#toString} method.
     * Always returns true.
     *
     * @return true
     */
    public boolean isPlayer(){ return true; }

    /**
     * Boolean flag for use in other classes.
     * Always returns false.
     *
     * @return false
     */
    public boolean isWall(){ return false; }

    /**
     * Moves the player one Tile up, down, left or right.
     * The direction is given as a String: "U" for up,
     * "D" for down, "L" for left and "R" for right.
     *
     * The player leaves his current tile first.
     * Asks the current tile which tile the player has to go to
     * according to the direction.
     *
     * Enters the player into that tile if it's not occupied.
     *
     * @param direction String the direction the player takes
     */
    public void move(String direction) {
        Tile currentTile = tile;
        tile.leave(this);
        switch (direction){ // assigns new Tile to Player.tile
            case "U":
                tile = currentTile.tileAbove();
                break;
            case "D":
                tile = currentTile.tileBelow();
                break;
            case "L":
                tile = currentTile.tileToLeft();
                break;
            case "R":
                tile = currentTile.tileToRight();
                break;
        }
        tile.enter(this); // assigns new Player to Tile.TileOccupier
    }

    public void placeWall(){
        wallsSet++;
        //TO DO
        //Ask Game if walls Left
    }

    public int getWallsSet(){
        return wallsSet;
    }

    /**
     *
     * @return the Player's initial position on the game board
     */
    public int[] getInitialPosition(){
        return initialPosition;
    }

    public String toString(){
        return symbol;
    }
}
