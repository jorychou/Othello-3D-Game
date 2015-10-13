package grupp1.othello.model;


/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/


import grupp1.othello.exception.InvalidMoveException;
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
public void initialize(){
    java.util.Arrays.fill(gridCells, 0);
    gridCells[4][4] = 2;
    gridCells[4][5] = 1;
    gridCells[5][4] = 2;
    gridCells[5][5] = 1;
}

public void placeMarker(int x, int y, int player) throws InvalidMoveException{
    if(!isValidMove(x,y,player)){
        throw(new InvalidMoveException("fasen"));
    }
    gridCells[x][y] = player;
        
    }
}
/*------------------------------------------------
 * PRIVATE METHODS
 *----------------------------------------------*/
