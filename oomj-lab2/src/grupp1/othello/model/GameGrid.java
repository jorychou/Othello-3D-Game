package grupp1.othello.model;


/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import java.util.ArrayList;

import grupp1.othello.exception.InvalidMoveException;
/*------------------------------------------------
 * CLASS
 *----------------------------------------------*/

/**
 * @author
 */
public class GameGrid  {

private final int gridSize;

public int[][] gridCells;

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
    int outer, inner;
    for(outer =0; outer<gridSize; outer++){
        for(inner =0; inner<gridSize; inner++){
            gridCells[outer][inner] = 0;
        }
    }
    gridCells[3][3] = 2;
    gridCells[3][4] = 1;
    gridCells[4][3] = 1;
    gridCells[4][4] = 2;
    printBoard();
}

public void placeMarker(int x, int y, int player) throws InvalidMoveException{
    if(!isValidMove(x,y,player)){
        throw(new InvalidMoveException("fasen"));
    }
    gridCells[x][y] = player;
    printBoard();
    }
public void printBoard(){
        System.out.println(" _ _ _ _ _ _ _ _");
        for(int outer=0; outer<gridSize; outer++){
            for(int inner=0; inner<gridSize;inner++){
                if(gridCells[inner][outer] == 0)
                    System.out.print("|_");
                else
                    System.out.print("|" +gridCells[inner][outer]);
            }
            System.out.print("|\n");
            
        }   
}
/*------------------------------------------------
 * PRIVATE METHODS
 *----------------------------------------------*/
}