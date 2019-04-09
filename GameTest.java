package exercise05;

import java.util.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class GameTest {
    private Game game;
    private Player eric;
    private Player jill;
    private Queue<Player> players;
    private Tile tile;

    @Before
    public void newGame(){
        eric = mock(Player.class);
        jill = mock(Player.class);
        players = new LinkedList<Player>();
        players.add(eric);
        players.add(jill);
        game = new Game(9,9, players, 3);
    }

    @Test
    public void playersHaveBeenAdded(){
        // TO DO: only testable when game logic has been added
        // Use Game#play() to make sure each player in the queue
        // gets his turn.
    }

    @Test
    public void testPlay(){
        game.play();
        // TO DO: test while implementing it.
        // Method that holds the main loop of the game
        // Method asserts the final state is ok
        // The game must be over when the method is done.
    }

    // Test relies on Tile class because it is very
    // difficult to test Game#findTile() in isolation
    // with the classes being intertwined.
    @Test
    public void testFindTile(){
        tile = new Tile(game, 0, 0);
        assertEquals(tile.position()[0], game.findTile(0,0).position()[0]);
    }

    /**
     * Run a scripted game.
     */
    public void checkGame(){
        // TO DO: When the game can be executed.
    }

}
