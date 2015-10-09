package grupp1.othello.model;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import blah;

/*------------------------------------------------
 * CLASS
 *----------------------------------------------*/

/**
 * @author
 */
public class GameGrid extends what {

private final int gridSize;

private int[] gridCells;

/*------------------------------------------------
 * PUBLIC METHODS
 *----------------------------------------------*/

public GameGrid(int gridSize) {
    this.gridSize = gridSize;

    // Allocate a square game grid of the specified size.
    gridCells = new int[gridSize * gridSize];
}

/*------------------------------------------------
 * PRIVATE METHODS
 *----------------------------------------------*/

}
