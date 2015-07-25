package ldrygala;

import org.junit.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by ldrygala on 2015-07-25.
 */
public class BoardTest {

    @Test
    public void shouldReturnZeroNeighborsForSingleCell() {
        //given
        Cell c = new Cell(0, 0);
        Board board = new Board(c);
        //when
        Set<Cell> neighbors = board.getNeighborsFor(c);
        //then
        assertThat(neighbors).isEmpty();
    }

    @Test
    public void shouldReturnOneNeighborForTwoCellsNextToEachOther() {
        //given
        Cell c1 = new Cell(0, 0);
        Cell c2 = new Cell(0, 1);
        Board board = new Board(c1, c2);
        //when
        Set<Cell> neighbors = board.getNeighborsFor(c1);
        //then
        assertThat(neighbors).contains(c2);
    }

    @Test
    public void shouldReturnTwoNeighborsForThreeCellsNextToEachOther() {
        //given
        Cell c1 = new Cell(0, 0);
        Cell c2 = new Cell(0, 1);
        Cell c3 = new Cell(1, 0);
        Board board = new Board(c1, c2, c3);
        //when
        Set<Cell> neighbors = board.getNeighborsFor(c1);
        //then
        assertThat(neighbors).contains(c2, c3);
    }

    @Test
    public void shouldReturnZeroNeighborForTwoCellsFarFromEachOther() {
        //given
        Cell c1 = new Cell(0, 0);
        Cell c2 = new Cell(0, 5);
        Board board = new Board(c1, c2);
        //when
        Set<Cell> neighbors = board.getNeighborsFor(c1);
        //then
        assertThat(neighbors).isEmpty();
    }

}
