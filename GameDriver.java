package exercise05;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Creates {@link Game} instances and executes them.
 */
public class GameDriver {
    public static void main(String args[]){
        Player otis = new Player("Otis Redding", "O", 1,1, "R");
        Player solomon = new Player("Solomon Burke", "S",7,12, "L");
        Queue<Player> participants = new LinkedList<Player>();
        participants.add(otis);
        participants.add(solomon);
        Game game = new Game(7,12, participants, 5);
        System.out.println(game);
        game.move(game.currentPlayer(), "R");
        System.out.print("\n");
        System.out.print(game);
        System.out.print("\n");
        game.move(game.currentPlayer(), "D");
        System.out.print(game + "\n");
        String nextMove = game.askPlayerNextMove();
        game.move(game.currentPlayer(), nextMove);
        System.out.print(game);
    }
}
