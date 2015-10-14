package grupp1.othello.model;


/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import grupp1.othello.exception.InvalidMoveException;
/*------------------------------------------------
 * CLASS
 *----------------------------------------------*/

/**
 * Grid setup for the game
 *
 * @author Tkocz
 */
public class GameGrid  {

private final int gridSize;

public int[][] grid;

/*------------------------------------------------
 * PUBLIC METHODS
 *----------------------------------------------*/

public GameGrid(int gridSize) {
    this.gridSize = gridSize;

    // Allocate a square game grid of the specified size.
    grid = new int[gridSize][gridSize];
}
/**
 * So far, checks whether the cell is empty,
 * will expand to check for all valid moves this turn.
 * @param x
 * @param y
 * @param playerIndex current player
 * @return true for valid move, else false
 */
public Boolean isValidMove(int x, int y, int playerIndex) {
    if (grid[x][y] != 0)
        return (false);

    return (recurseDirections(x, y, playerIndex, false));
}
/**
 * Resets the grid, and sets the four middle cells to starting state
 */
public void initialize(){
    int outer, inner;
    for(outer =0; outer<gridSize; outer++){
        for(inner =0; inner<gridSize; inner++){
            grid[outer][inner] = 0;
        }
    }
    grid[3][3] = 2;
    grid[3][4] = 1;
    grid[4][3] = 1;
    grid[4][4] = 2;
    printBoard(1);
}

public void placeMarker(int x, int y, int player) throws InvalidMoveException{
    if(!isValidMove(x,y,player)){
        throw(new InvalidMoveException("fasen"));
    }
    recurseDirections(x, y, player, true);
    grid[x][y] = player;
    if (player == 2)
        printBoard(1);
    else
        printBoard(2);
    }
/**
 * Måste ju skriva ut brädet på nåt sätt innan GUI
 */
public void printBoard(int player){
        System.out.println(" _ _ _ _ _ _ _ _");
        for(int outer=0; outer<gridSize; outer++){
            for(int inner=0; inner<gridSize;inner++){
                if(grid[inner][outer] == 0) {
                    if (!isValidMove(inner, outer, player))
                        System.out.print("|_");
                    else
                        System.out.print("|x");
                }
                else
                    System.out.print("|" +grid[inner][outer]);
            }
            System.out.print("|\n");

        }
}
/*------------------------------------------------
 * PRIVATE METHODS
 *----------------------------------------------*/

private Boolean recurseDirections(int x, int y, int player, Boolean flip) {
    Boolean result = false;

    for (int i = -1; i <= 1; i++) {
        for (int j = -1; j <= 1; j++) {
            if (i == 0 && j == 0)
                continue;

            result |= recurseDirection(x, y, i, j, player, false, flip);

            if (result && !flip)
                return (result);
        }
    }

    return (result);
}

private Boolean recurseDirection(int x, int y, int dx, int dy, int player, Boolean ok, Boolean flip) {
    x += dx;
    y += dy;

    // Out of bounds.
    if (x < 0 || x >= 8 || y < 0 || y >= 8)
        return (false);

    // Empty grid.
    if (grid[x][y] == 0)
        return (false);

    if (grid[x][y] == player)
        return (ok);

    ok = true;
    Boolean result = recurseDirection(x, y, dx, dy, player, ok, flip);

    if (result && flip)
        grid[x][y] = player;

    return (result);
}

}
