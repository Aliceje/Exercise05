package exercise05;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class PlayerTest {
    private Player eric, jill;
    private Game game;
    private Tile tileEric, tileJill;
    private Queue<Player> players;

    @Before
    public void newGame(){
        eric = new Player("eric", "E", 1,1, "R");
        jill = new Player("Jill", "J", 7, 12, "L");
        players = new LinkedList<>();
        players.add(eric);
        players.add(jill);
        tileEric = mock(Tile.class);
        tileJill = mock(Tile.class);
        game = mock(Game.class);
    }

    @Test
    public void joinGame(){
        when(game.findTile(anyInt(), anyInt())).thenReturn(tileEric);
        eric.joinGame(game);
    }

    @Test
    public void validPositions(){

    }

    // TO DO: complete test.
    /**
     * Tests a basic player move.
     * "R" is entered as a parameter and
     * the player's tile is only stubbed for tileBelow(),
     * so the test will only pass if "R" is analysed correctly.
     *
     * Note: Player movement is closely intertwined with the {@link Game}
     * and the {@link Tile} class. This makes it nearly impossible to test
     * in isolation, so this test relies on the mentioned classes as well.
     *
     */
    @Test // tries to move eric one up
    public void testBasicMove(){
        Game realGame = new Game(7, 12, players, 5);
        eric.move("R");
    }
}
