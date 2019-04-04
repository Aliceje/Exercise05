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
 * He has a certain amount of Walls {@link Wall} that he can put up
 * during the game.
 *
 * Implements the {@link TileOccupier} Interface.
 */
public class Player implements TileOccupier{

    public static final int NUM_OF_WALLS = 5;

    private String name;
    private String symbol;
    private Tile tile;
    private int[] initialPosition;
    private boolean winner;
    private int wallsSet;
    private boolean wallsLimitReached;

    /**
     * Class invariant: Conditions that must always hold.
     *
     * wallsSet not higher than NUM_OF_WALLS
     * If wallsSet == NUM_OF_WALLS, limitReached should be true
     * name and symbol not empty
     *
     * @return true if invariant states have not been modified
     */
    private boolean invariant(){
       return name != null
                && symbol != null
                && !(wallsSet > NUM_OF_WALLS);
    }

    /**
     * Sets up a new Player with a name, a symbol and the coordinates
     * of his initial Tile.
     *
     * @param name String the players name
     * @param symbol String the players symbol on the game board
     */
    public Player(String name, String symbol, int x, int y){
        this.name = name;
        this.symbol = symbol;
        initialPosition = new int[]{(x-1), (y-1)};
        winner = false;
        wallsSet = 0;
        wallsLimitReached = false;
    }

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
    }

    /**
     * Checks if the player can still put up walls.
     *
     * @param walls_set int the walls set so far.
     * @return true if the limit has not been reached yet.
     */
    public boolean wallsLeft(int walls_set){
        if(walls_set == NUM_OF_WALLS){
            return false;
        } else {
            return true;
        }
    }

    public boolean reachedTargetSide(){ return false; } //TO DO

    //if player has won move to "heaven"
    public void takeOffBoard(){
        //TO DO
    }

    /**
     * Boolean flag for use in other classes.
     * For example inside the (@link Tile#toString) method.
     * Always returns true.
     *
     * @return true
     */
    public boolean isPlayer(){ return true; }

    /**
     * Boolean flag for use in other classes.
     * Returns always false.
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
     * @param direction String the direction the player takes
     */
    public void move(String direction) {
        Tile currentTile = tile;
        tile.leave(this);
        switch (direction){
            case "U":
                currentTile.tileAbove().enter(this);
                break;
            case "D":
                currentTile.tileBelow().enter(this);
                break;
            case "L":
                currentTile.tileToLeft().enter(this);
                break;
            case "R":
                currentTile.tileToRight().enter(this);
                break;
        }
    }

    public void placeWall(){

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
