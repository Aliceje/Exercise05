package exercise05;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class PlayerTest {
    private Player eric, jill;
    private Game game;
    private Tile mockTile;
    private Tile tileEric, tileJill;

    @Before
    public void newGame(){
        eric = new Player("eric", "E", 1,1);
        jill = new Player("Jill", "J", 7, 12);
        tileEric = mock(Tile.class);
        tileJill = mock(Tile.class);
        game = mock(Game.class);
        when(game.findTile(1,1)).thenReturn(tileEric);
        when(game.findTile(7,12)).thenReturn(tileJill);
        eric.joinGame(game);
        jill.joinGame(game);
    }

    @Test
    public void joinGame(){
        mockTile = mock(Tile.class);
        when(game.findTile(1,1)).thenReturn(mockTile);
        eric.joinGame(game);
    }

    @Test
    public void validPositions(){

    }

    /**
     * Tests a basic player move.
     * "U" is entered as a parameter and
     * the player's tile is only stubbed for tileAbove(),
     * so the test will only pass if "U" is analysed correctly.
     *
     */
    @Test // tries to move eric one up
    public void testBasicMove(){
        Tile target = mock(Tile.class);

        when(tileEric.leave(eric)).thenReturn(true);
        when(tileEric.tileAbove()).thenReturn(target);
        when(target.enter(eric)).thenReturn(true);
        when(game.findTile(1,1)).thenReturn(target);

        eric.move("U");
    }
}
