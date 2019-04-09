package exercise05;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RendererTest {
    private Renderer renderer;
    private Tile[][] gameBoard;
    private Game game;

    @Before
    public void setUpRenderer(){
        gameBoard = new Tile[12][7];
        game = mock(Game.class);
        for(int i = 0; i < 12; i++){
            for(int j = 0; j < 7; j++){
                gameBoard[i][j] = new Tile (game, j, i);
            }
        }
        renderer = new Renderer(gameBoard);
    }

    @Test
    public void testRenderGameState(){
        String gameState = renderer.renderGameState();
        assertEquals("Correct representation", "# # # # # # # # # \n" +
                "#               #\n" +
                "#               #\n" +
                "#               #\n" +
                "#               #\n" +
                "#               #\n" +
                "#               #\n" +
                "#               #\n" +
                "#               #\n" +
                "#               #\n" +
                "#               #\n" +
                "#               #\n" +
                "#               #\n" +
                "# # # # # # # # # ", gameState);
    }

    @Test
    public void renderWithPlayersOnBoard(){
        Player eric = mock(Player.class);
        Player jill = mock(Player.class);
        gameBoard[11][6].enter(eric);
        gameBoard[0][0].enter(jill);
        when(eric.toString()).thenReturn("E");
        when(jill.toString()).thenReturn("J");
        Renderer rendererWithPlayers = new Renderer(gameBoard);
        String gameState = rendererWithPlayers.renderGameState();
        assertEquals("Correct representation", "# # # # # # # # # \n" +
                "# J             #\n" +
                "#               #\n" +
                "#               #\n" +
                "#               #\n" +
                "#               #\n" +
                "#               #\n" +
                "#               #\n" +
                "#               #\n" +
                "#               #\n" +
                "#               #\n" +
                "#               #\n" +
                "#             E #\n" +
                "# # # # # # # # # ", gameState);
    }

    @Test (expected=IndexOutOfBoundsException.class) // because of empty Tile[][] Array
    public void testArrayLengthZero() throws IndexOutOfBoundsException {
        Renderer testRenderer = new Renderer(new Tile[0][0]);
        assertEquals("Empty String", "", testRenderer.renderGameState());
    }


    // 2D Arrays can't consist of just one line!
    /*
    @Test
    public void testArrayOneLine(){
        Tile[][] oneLine = new Tile[1][7]; // one row of 7 tiles
        Game mockGame = mock(Game.class);
        Renderer testRenderer = new Renderer(oneLine);
        for (int i = 0; i < 7; i++) {
            oneLine[1][i] = new Tile(mockGame, i, 1);
        }
        assertEquals("Border + one line of 7 empty Tiles", "# # # # # # # # # \n"
                + "#               #\n", testRenderer.renderGameState());
    }
    */
}
