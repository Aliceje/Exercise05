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
}
