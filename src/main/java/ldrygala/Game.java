package ldrygala;

/**
 * Created by ldrygala on 2015-07-25.
 */
public class Game {
    private Board board;

    public Game(Board board) {
        this.board = board;
    }

    public Board nextGeneration() {
        Board nextBoard = board.nextGeneration();
        board = nextBoard;
        return nextBoard;
    }

}
