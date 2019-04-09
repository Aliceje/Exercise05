package exercise05;

// TO DO: Think about changing the constructor:
// He could accept a game instead of a Tile[][], which would
// make it easier to test the Renderer.
// The game's game board should then be made accessible however.

// Also, the Game#toString() method works nice the way it is implemented now.
// On the other hand, each time it is called, a new Renderer is created...

/**
 * Renders a {@link Game} object.
 * Is used to visualize the game's current state.
 *
 */
public class Renderer {

    private StringBuffer builder;
    private Tile gameboard[][];

    /**
     * Creates a Renderer for a specific game board.
     *
     * @param gameboard Tile[][] 2-D-Array of a game board
     */
    public Renderer(Tile gameboard[][]){
        builder = new StringBuffer();
        this.gameboard = gameboard;
    }

    /**
     * Returns a graphical representation of the gameboard Array.
     * Used inside the {@link Game} class for rendering
     * the current state of the Game.
     *
     * @return String representation of the game board
     */
    public String renderGameState(){
        int height = gameboard.length; // e.g. 12
        int width = gameboard[0].length; // e.g. 7
        builder.append(horizontalBorder() + "\n");
        for(int i = 0; i < height; i++){
            builder.append("# "); // remove space later
            for(int j = 0; j < width; j++){
                Tile tile = gameboard[i][j];
                builder.append(tile.toString());
                builder.append(" "); // remove later
            }
            builder.append("#");
            builder.append("\n");
        }
        builder.append(horizontalBorder());
        return builder.toString();
    }

    /**
     * Helper method for the gameState() method.
     * Returns a line of "#" border marks.
     *
     * The number of marks in the line depends on the
     * width of the game board and is 2 items bigger.
     *
     * @return String a line of "#" border marks
     */
    private String horizontalBorder(){
        StringBuffer border = new StringBuffer();
        int width = gameboard[0].length;
        for(int i = 0; i <= (width+1); i++){
            border.append("# "); // remove space later
        }
        return border.toString();
    }
}