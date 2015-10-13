package grupp1.othello.model;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

//import blah;

/*------------------------------------------------
 * CLASS
 *----------------------------------------------*/

/**
 * @author
 */
public class GameGrid  {

private final int gridSize;

private int[][] gridCells;

/*------------------------------------------------
 * PUBLIC METHODS
 *----------------------------------------------*/

public GameGrid(int gridSize) {
    this.gridSize = gridSize;

    // Allocate a square game grid of the specified size.
    gridCells = new int[gridSize][gridSize];
}

public Boolean isValidMove(int x, int y, int playerIndex) {
    if (gridCells[x][y] != 0)
        return (false);

    return (true);
}

/*------------------------------------------------
 * PRIVATE METHODS
 *----------------------------------------------*/

}
