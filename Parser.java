package exercise05;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.*;

/**
 * Parses a Quoridor game specification and creates a {@link Game} instance.
 */

public class Parser {
    /*
    idea: array of strings, choose function dependent on index
    for i = 0 -> f for game, for i >= 1 -> f for player
    */

    /**
     * Reads from a file and returns its contents as a String.
     *
     * @param file the File to be read
     * @return String the file's contents in a String
     */
    public String read (File file) throws IOException {
				FileReader fileReader = new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				StringBuffer stringBuffer = new StringBuffer();
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					stringBuffer.append(line);
					stringBuffer.append("\n"); // empty line appended to the end of the String
				}
				fileReader.close();
				
				String res_string = stringBuffer.toString();
				return res_string;
    }

	/**
	 * Creates a {@link Game} from a String with game specifications
	 *
	 * @param gameSpecifications String with syntactically correct game specifications
	 * @return Game
	 */
	public Game parse(String gameSpecifications){
		String[] lines = gameSpecifications.split("\\n"); // check for specification ending in \n
		int[] board = parseBoardSpecification(lines[0]); // save
		Queue<Player> players = new LinkedList<Player>();
		for(int i = 1; i < lines.length; i++){
			Player player = parsePlayerSpecification(lines[i]);
			players.add(player);
		}
		int width = board[0];
		int height = board[1];
		int walls = board[2];
		Game game = new Game(width, height, players, walls); // change Constructor: add numberOfWalls per player
    	return game;
	}

	private Player parsePlayerSpecification(String playerSpecification){
		Pattern playerPattern = Pattern.compile("(.+) (.) (\\d+) (\\d+) (.)");
		Matcher matcher = playerPattern.matcher(playerSpecification);
		if (matcher.find()) {
			String name = matcher.group(1);
			String symbol = matcher.group(2);
			int x = Integer.parseInt(matcher.group(3));
			int y = Integer.parseInt(matcher.group(4));
			String target = matcher.group(5);
			Player player = new Player(name, symbol, x, y, target); // change Constructor: add target
			return player;
		}
		else return new Player(); // Change?
	}


	private int[] parseBoardSpecification(String boardSpecification){
		Pattern boardPattern = Pattern.compile("(\\d+) (\\d+) (\\d+)");
		Matcher matcher = boardPattern.matcher(boardSpecification);
		if (matcher.find()) {
			int width = Integer.parseInt(matcher.group(1));
			int height = Integer.parseInt(matcher.group(2));
			int walls = Integer.parseInt(matcher.group(3));
			return new int[]{width, height, walls}; // Add walls when Game constructor changed
		}
		else return new int[] {}; // Change?
	}


}


