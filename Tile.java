package exercise05;

/**
 * Represents a tile on the Quoridor game {@link Game}.
 * A tile can be empty or occupied by a {@link TileOccupier}
 *
 */
public class Tile {

    private int[] position;
    private State state; // TO DO: Think about use, remove if not needed in implementation.
    private Game game;
    private TileOccupier occupier;

    /**
     * Class invariant: Conditions that must always hold.
     *
     * position must be on game board.
     * state must be either EMPTY, PLAYER or WALL
     *
     * @return true if conditions hold
     */
    private boolean invariant(){
        return state != null
                && position != null;
    }

    /**
     * Creates a new Tile Object for a specific
     * game at a specific place on the game board.
     *
     * Used inside the {@link Game} and inside the {@link Player} class.
     *
     * @param game Game the Game the Tile belongs to
     * @param x int the x-value on the game board Array
     * @param y int the y-value on the game board Array
     */
    public Tile(Game game, int x, int y){
        this.game = game;
        position = new int[]{x, y};
        state = State.EMPTY;

        assert invariant();
    }

    /**
     * Getter method for the Tile's position
     * on the game board.
     *
     * @return int[] the Tile's position
     */
    public int[] position() {
        return this.position;
    }

    /**
     * Returns the Tile one position to
     * the left of this Tile on the game board.
     *
     * @return Tile the adjoining left Tile
     */
    public Tile tileToLeft(){
        int x = position[0]-1;
        int y = position[1];
        return game.findTile(x, y);
    }

    /**
     * Returns the Tile one position to
     * the right of this Tile on the game board.
     *
     * @return Tile the adjoining right Tile
     */
    public Tile tileToRight(){
        int x = position[0]+1;
        int y = position[1];
        return game.findTile(x, y);
    }

    /**
     * Returns the Tile one position above
     * this Tile on the game board.
     *
     * @return Tile the Tile above
     */
    public Tile tileAbove(){
        int x = position[0];
        int y = position[1]-1;
        return game.findTile(x, y);
    }

    /**
     * Returns the Tile one position below
     * this Tile on the game board.
     *
     * @return Tile the Tile below
     */
    public Tile tileBelow(){
        int x = position[0];
        int y = position[1]+1;
        return game.findTile(x, y);
    }

    /**
     * Changes the state of the Tile.
     *
     * @param state the new State the Tile will have
     */
    public void changeState(State state){
        this.state = state;
    }

    /**
     * Let's a new player enter this Tile.
     * Must be empty before the player enters.
     *
     * @param newOccupier TileOccupier wanting to enter
     */
    public void enter(TileOccupier newOccupier){
        assert occupier == null;
        occupier = newOccupier;
    }

    /**
     * Let's a player leave this tile.
     * The player must occupy this tile in order to leave it.
     *
     * @param currentOccupier TileOccupier currently on this tile
     */
    public void leave(TileOccupier currentOccupier){
        assert occupier == currentOccupier;
        occupier = null;
    }

    /**
     * Checks whether the Tile is occupied or not.
     *
     * @return true if the Tile is occupied
     */
    public boolean isOccupied(){
        return occupier != null;
    }

    /**
     * Returns a representation of a Tile for
     * use on the game board (@link Game).
     *
     * @return String empty or TileOccupier
     */
    public String toString(){
       if (isOccupied()){
           return occupier.toString();
       }
       else return " ";
    }
}