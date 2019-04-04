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
        game = new Game(9,9, players);
    }

    @Test
    public void playersHaveBeenAdded(){

    }

    @Test
    public void testPlay(){
        game.play();
        /*
        * Method that effectuates the moves
        * Assert the final state is ok
        * The game must be over when the method is done.
         */
    }

    @Test
    public void testFindTile(){
        tile = new Tile(game, 0, 0);
        assertEquals(tile.position()[0], game.findTile(0,0).position()[0]);
    }

}
