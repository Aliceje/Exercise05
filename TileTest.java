package exercise05;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TileTest {
    private Game game;
    private Tile tile;
    private Player eric, jill;

    @Before
    public void newGame(){
        game = mock(Game.class);
        tile = new Tile(game, 1, 1);
        eric = mock(Player.class);
        jill = mock(Player.class);
    }

    @Test(expected=AssertionError.class)
    public void testEnterWhenOccupied() throws AssertionError {
        tile.enter(eric);
        tile.enter(jill);
    }

    @Test
    public void testIsOccupied(){
        tile.enter(eric);
        assertEquals("Tile is occupied", tile.isOccupied(), true);
    }

    @Test (expected=AssertionError.class)
    public void testLeaveWhenNotOnTile() throws AssertionError {
        tile.leave(eric);
    }

    @Test
    public void testLeave(){
        tile.enter(eric);
        tile.leave(eric);
        assertEquals("Tile is not occupied", tile.isOccupied(), false);
    }
}
