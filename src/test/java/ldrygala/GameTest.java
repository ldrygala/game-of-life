package ldrygala;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by ldrygala on 2015-07-25.
 */
public class GameTest {

    @Test
    public void singleCellShouldDieInNextGeneration() {
        //given
        Cell c = new Cell(0, 0);
        Game game = new Game(new Board(c));
        //when
        Board nextBoard = game.nextGeneration();
        //then
        assertThat(nextBoard.isAlive(c)).isFalse();
    }

    @Test
    public void cellWithTwoNeighborsShouldAliveInNextGeneration() {
        //given
        Cell c1 = new Cell(0, 0);
        Cell c2 = new Cell(0, 1);
        Cell c3 = new Cell(1, 0);
        Game game = new Game(new Board(c1, c2, c3));
        //when
        Board nextBoard = game.nextGeneration();
        //then
        assertThat(nextBoard.isAlive(c1)).isTrue();
    }

    @Test
    public void cellWithThreeNeighborsShouldAliveInNextGeneration() {
        //given
        Cell c1 = new Cell(0, 0);
        Cell c2 = new Cell(0, 1);
        Cell c3 = new Cell(1, 0);
        Cell c4 = new Cell(1, 1);

        Game game = new Game(new Board(c1, c2, c3, c4));
        //when
        Board nextBoard = game.nextGeneration();
        //then
        assertThat(nextBoard.isAlive(c1)).isTrue();
    }

    @Test
    public void cellWithFourNeighborsShouldDieInNextGeneration() {
        //given
        Cell c1 = new Cell(1, 1);
        Cell c2 = new Cell(2, 1);
        Cell c3 = new Cell(1, 2);
        Cell c4 = new Cell(0, 1);
        Cell c5 = new Cell(1, 0);

        Game game = new Game(new Board(c1, c2, c3, c4, c5));
        //when
        Board nextBoard = game.nextGeneration();
        //then
        assertThat(nextBoard.isAlive(c1)).isFalse();
    }

    @Test
    public void deadCellWithThreeNeighborsShouldAliveInNextGeneration() {
        //given
        Cell cellWhichShouldAliveInNextGeneration = new Cell(0, 0);

        Cell c2 = new Cell(0, 1);
        Cell c3 = new Cell(1, 0);
        Cell c4 = new Cell(1, 1);

        Game game = new Game(new Board(c2, c3, c4));
        //when
        Board nextBoard = game.nextGeneration();
        //then
        assertThat(nextBoard.isAlive(cellWhichShouldAliveInNextGeneration)).isTrue();
    }
}
