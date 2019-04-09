package exercise05;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito.*;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * Tests the parser for the Quoridor game.
 * The parser is supposed to parse game specifications and
 * create a new {@link Game} from them.
 */
public class ParserTest {

    private Parser parser;

    @Before
    public void setUpParser(){
        parser = new Parser();
    }

    /**
     * Tests if the parser can set up a game
     * reading from a .txt file.
     */
    @Test
    public void testSetUpNewGame(){
        Game parsedGame = parser.parse("7 12 3\n" +
                "Otis Redding O 1 1 R\n" +
                "Solomon Burke S 7 12 L\n" );
        assertEquals("O", parsedGame.currentPlayer().toString());
    }

    /**
     * Tests whether the parser can handle
     * faulty input.
     */

    // Split tests for reading and parsing?

    /**
     * Tests whether a .txt file is
     * properly returned as a String
     */
    @Test
    public void testReader() throws IOException {
        File testFile = new File("C:\\Users\\Emma\\P2\\group28\\exercise_05\\games\\game1.txt");
        String fileAsString = parser.read(testFile);
        assertEquals("Contents are the same", "7 12 3\n" +
                "Otis Redding O 1 1 R\n" +
                "Solomon Burke S 7 12 L\n", fileAsString);
    }

    public Game gameWithMockPlayers(){
        Player otis = mock(Player.class);
        Player solomon = mock(Player.class);
        Queue<Player> players = new LinkedList<>();
        Game game = new Game(7,12, players, 5);
        return game;
    }
}
