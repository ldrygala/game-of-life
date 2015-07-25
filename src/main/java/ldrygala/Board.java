package ldrygala;

import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.asList;

/**
 * Created by ldrygala on 2015-07-25.
 */
public class Board {
    private Set<Cell> cells = new HashSet<Cell>();

    public Board(Cell... cells) {
        this.cells.addAll(asList(cells));
    }

    public Set<Cell> getNeighborsFor(Cell c) {
        Set<Cell> possibleNeighbors = possibleNeighborsFor(c);
        Set<Cell> neighbors = new HashSet<Cell>();
        for (Cell cell : possibleNeighbors) {
            if (isAlive(cell)) {
                neighbors.add(cell);
            }
        }
        return neighbors;
    }

    private Set<Cell> possibleNeighborsFor(Cell c) {
        Set<Cell> neighbors = new HashSet<Cell>();
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                Cell neighbor = new Cell(c.x + i, c.y + j);
                neighbors.add(neighbor);
            }
        }

        neighbors.remove(c);
        return neighbors;
    }

    public boolean isAlive(Cell c) {
        return cells.contains(c);
    }

    public Board nextGeneration() {
        Board nextBoard = new Board();
        Set<Cell> possibleToReborn = new HashSet<Cell>();

        for (Cell cell : cells) {
            possibleToReborn.addAll(possibleNeighborsFor(cell));
            if (shouldAliveInNextGeneration(cell)) {
                nextBoard.addCell(cell);
            }
        }

        for (Cell cell : possibleToReborn) {
            if (shouldRebornInNextGeneration(cell)) {
                nextBoard.addCell(cell);
            }
        }

        return nextBoard;
    }

    private boolean shouldRebornInNextGeneration(Cell cell) {
        int numberOfNeighbors = getNeighborsFor(cell).size();
        return numberOfNeighbors == 3;
    }

    private boolean shouldAliveInNextGeneration(Cell cell) {
        int numberOfNeighbors = getNeighborsFor(cell).size();
        return numberOfNeighbors == 2 || numberOfNeighbors == 3;
    }

    private void addCell(Cell cell) {
        cells.add(cell);
    }

}
