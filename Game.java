package exercise05;

import java.util.*;

/**
 * Represents a Quoridor game.
 *
 * Quoridor is a strategy game where each player must reach
 * the opposite side of the playing field from where he starts.
 *
 * Sets up a game with (@link Player) players and a game board
 * of a specific width and height made up of (@link Tile) tiles.
 *
 * Moves the players on the game board and keeps track
 * of the game's changes.
 */
public class Game {

    private Tile[][] gameboard;
    private Deque<Player> players;
    private ArrayList<Player> winners;

    private boolean invariant(){
        return players.size() > 1
                && gameboard != null
                && winners != null;
         //TO UPDATE: What conditions does the game have? No more than 4 players?
    }

    public Game(int width, int height, Queue<Player> players){
        this.initGameBoard(width, height);
        this.addPlayers(players);
        winners = new ArrayList<Player>();
        assignInitialTiles();

        assert invariant();
    }

    public static void main(String args[]){
        Player otis = new Player("Otis Redding", "O", 1,1);
        Player solomon = new Player("Solomon Burke", "S",7,12);
        Queue<Player> participants = new LinkedList<Player>();
        participants.add(otis);
        participants.add(solomon);
        Game game = new Game(7,12, participants);
        System.out.println(game);
        game.move(game.currentPlayer(), "R");
        System.out.print("\n");
        System.out.print(game);
    }

    //createGame()
    //doublecheck after every move
    //update
    //print out
    //makeMove() per player
    //loop while game is not over

    public void createGame(){
        //TO DO?
    }

    public void play(){
        //TO DO
    }

    /**
     * Initializes and creates a game board
     * and fills it with empty tiles.
     *
     * @param width int the width of the board
     * @param height int the height of the board
     */
    private void initGameBoard(int width, int height){
        gameboard = new Tile[(height)][(width)];
        for(int i = 0; i <= (height-1); i++){
            for(int j = 0; j <= (width-1); j++){
                gameboard[i][j] = new Tile (this, i, j);
            }
        }
    }

    /**
     * Adds players to the game.
     *
     * @param players Queue of players to be added
     */
    private void addPlayers(Queue<Player> players){
        assert players != null;
        this.players = new LinkedList<Player>();
        for (Player player: players){
            this.players.add(player);
        }
    }

    /**
     * Let's the players join the game and
     * thereby enter their initial Tiles.
     *
     */
    private void assignInitialTiles(){
        assert this.players != null;
        for (Player player: players){
            player.joinGame(this);
        }
        assert invariant();
    }

    /**
     * Finds the corresponding Tile on the game board
     * according to the specified x and y values.
     * These are the actual indices of the Tile inside the Array
     * and not the superficial ones used in playing the game.
     *
     * @param x int x coordinate
     * @param y int y coordinate
     * @return the Tile at position (x,y) on the game board
     */
    public Tile findTile(int x, int y){
        assert (x <= gameboard[0].length)
                && (y <= gameboard.length);
        return gameboard[y][x];
    }

    /**
     * Moves the players who have reached their edge
     * to "heaven" and removes them from the game board
     *
     * @param player the Player that has reached his edge
     */
    public void moveToHeaven(Player player){
        //TO DO
    }

    /**
     * Move the current player in one of four directions.
     *
     * @param currentPlayer the Player to be moved
     * @param direction String the direction the player takes
     */
    public void move(Player currentPlayer, String direction){
        currentPlayer.move(direction);
    }

    /**
     * Returns the player at the front of the queue.
     *
     * @return Player the current player
     */
    public Player currentPlayer(){ return players.peek(); }

    /*
     * Updates the game board after a player has moved.
     * Not sure about use yet.
     */
    private void updateGameBoard(){

    }

    /**
     * Returns a String that represents the current
     * state of the game.
     * Uses a (@link Renderer) Object which actually
     * creates the String.
     *
     * @return String representing the game state
     */
    public String toString(){
        Renderer gameRenderer = new Renderer(gameboard);
        return gameRenderer.renderGameState();
    }
}





// OLD implementation for initGameBoard with boarders. Deemed unnecessary.
/**
 * Fills the game board up with empty tiles.
 * Puts up walls around the game board.
 *
 * @param width int the width of the gameboard
 * @param height int the height of the gameboard
 */
    /*private void initGameBoard(int width, int height){
        gameboard = new Tile[(width)][(height)];
        for(int i = 1; i < (width-1); i++){ // the actual field without boarders
            for(int j = 1; j < (height-1); j++){
                gameboard[i][j] = new Tile (i, j);
            }
        }
        createBorders(width, height);
    }*/

/**
 * Sets up border Tiles at the edge of the gameboard
 * Example:
 * 3x3 gameboard
 * Upper border goes from (0,0) to (4,0)
 *
 * @param width int the width of the gameboard
 * @param height int the height of the gameboard
 */
    /*private void createBorders(int width, int height){
        for (int i = 0; i < (width); i ++){ // upper border
            gameboard[i][0] = new Tile (i, 0);
            gameboard[i][0].changeState(State.BORDER);
        }
        for (int j = 1; j < (height-1); j++){ // left border without highest and lowest Tile
            gameboard[0][j] = new Tile (0, j);
            gameboard[0][j].changeState(State.BORDER);
        }
        for (int j = 1; j < (height-1); j++){ // right border without highest and lowest Tile
            gameboard[width-1][j] = new Tile ((width+1), j);
            gameboard[width-1][j].changeState(State.BORDER);
        }
        for (int i = 0; i < width; i++){ // lower border
            gameboard[i][(height-1)] = new Tile (i, (height+1));
            gameboard[i][(height-1)].changeState(State.BORDER);
        }
        // TO DO: Think about different implementation because this one seems fragile
    }*/
