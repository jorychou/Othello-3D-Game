package grupp1.othello.model;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import grupp1.othello.exception.InvalidMoveException;
import grupp1.othello.exception.InvalidPlayerException;

import java.util.Arrays;

/*------------------------------------------------
 * CLASS
 *----------------------------------------------*/

/**
 * Represents a game grid.
 *
 * @author Martin Bergqvist (S133686)
 */
public class GameGrid  {

/*------------------------------------------------
 * CONSTANTS
 *----------------------------------------------*/

/**
 * Indicates an empty cell.
 */
public static final int EMPTY = 0;

/**
 * Indicates that a cell is occupied by player one.
 */
public static final int PLAYER_ONE = 1;

/**
 * Indicates that a cell is occupied by player two.
 */
public static final int PLAYER_TWO = 2;

/*------------------------------------------------
 * FIELDS
 *----------------------------------------------*/

/**
 * The grid contents.
 */
public int[][] grid;

/**
 * The width and height of the grid, in number of cells.
 */
private final int gridSize;

/*------------------------------------------------
 * PUBLIC METHODS
 *----------------------------------------------*/

/**
 * Constructor.
 *
 * @param gridSize The size (width and height) of the grid, in number of cells.
 */
public GameGrid(int gridSize) {
    if (gridSize < 4)
        gridSize = 4;

    this.gridSize = gridSize;

    // Allocate a square game grid of the specified size.
    grid = new int[gridSize][gridSize];
}

/**
 * Resets the grid, and sets the four middle cells to starting state
 */
public void init() {
    for (int i = 0; i < gridSize; i++)
        Arrays.fill(grid[i], 0);

    int n = gridSize / 2;

    grid[n-1][n-1] = PLAYER_ONE;
    grid[n-1][n  ] = PLAYER_TWO;
    grid[n  ][n-1] = PLAYER_TWO;
    grid[n  ][n  ] = PLAYER_ONE;

    // @To-do: Remove this.
    printBoard(1);
}

/**
 * Checks whether it is considered a valid move to place a disk for the
 * specified player on the board at the given coordinates.
 *
 * @param x      The x-coordinate of the cell to place a disk on.
 * @param y      The y-coordinate of the cell to place a disk on.
 * @param player The player (player one or player two).
 *
 * @return True if the specified move is considered valid.
 *
 * @throws InvalidPlayerException The specified player index is invalid.
 */
public Boolean isValidMove(int x, int y, int player)
    throws InvalidPlayerException
{
    if (player != PLAYER_ONE && player!= PLAYER_TWO)
        throw (new InvalidPlayerException("Invalid player index specified."));

    // Check if we're out of bounds.
    if (x < 0 || x >= gridSize || y < 0 || y >= gridSize)
        return (false);

    // New disks can only be placed on empty cells.
    if (grid[x][y] != EMPTY)
        return (false);

    return (checkDirections(x, y, player, false));
}

/**
 * Places a disk on the grid at the specified coordinates.
 *
 * @param x      The x-coordinate of the cell to place a disk on.
 * @param y      The y-coordinate of the cell to place a disk on.
 * @param player The player (player one or player two).
 *
 * @throws InvalidMoveException   The specified move is not considered valid.
 * @throws InvalidPlayerException The specified player index is invalid.
 */
public void placeDisk(int x, int y, int player)
    throws InvalidMoveException, InvalidPlayerException
{
    if (!isValidMove(x, y, player))
        throw (new InvalidMoveException("Invalid move specified."));

    checkDirections(x, y, player, true);

    // Place final disk to complete the move.
    grid[x][y] = player;

    // @To-do: Remove this.
    if (player == 2)
        printBoard(1);
    else
        printBoard(2);
}

/**
 * Måste ju skriva ut brädet på nåt sätt innan GUI
 */
    // @To-do: Remove this.
public void printBoard(int player){
    try {
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
        catch (Exception e) {
            System.out.println("lol");
        }
}

/*------------------------------------------------
 * PRIVATE METHODS
 *----------------------------------------------*/

/**
 * Checks in all (eight) directions from the specified coordinate for flippable
 * disks.
 *
 * @param x      The x-coordinate of the starting point on the grid.
 * @param y      The y-coordinate of the starting point on the grid.
 * @param player The player index. (1 or 2).
 * @param flip   True to actually flip disks (and mutate the grid state).
 *
 * @return True if any flippable disks were found.
 *
 * @author Philip Arvidsson (S133686)
 */
private Boolean checkDirections(int x, int y, int player, Boolean flip) {
    Boolean result = false;

    // We loop through all possible directions...
    for (int i = -1; i <= 1; i++) {
        for (int j = -1; j <= 1; j++) {
            // ...ignoring (0, 0) since it technically isn't even a direction.
            if (i == 0 && j == 0)
                continue;

            // Then we recurse in the current direction and store the result.
            result |= recurseDirection(x, y, i, j, player, flip, false);

            // If we're not flipping disks, we can return as soon as we know we
            // found flippable disks since we're only checking whether the move
            // is valid.
            if (result && !flip)
                return (result);
        }
    }

    return (result);
}

/**
 * Recurses the direction specified by (dx, dy) and checks for flippable disks
 * according to the Othello game logic.
 *
 * @param x      The x-coordinate of the starting point on the grid.
 * @param y      The y-coordinate of the starting point on the grid.
 * @param dx     The x-coordinate of the direction to recurse towards.
 * @param dy     The y-coordinate of the direction to recurse towards.
 * @param player The player index. (1 or 2).
 * @param flip   True if disks should be flipped when found flippable.
 * @param flag   MUST be set to false when called externally.
 *
 * @author Philip Arvidsson (S133686)
 */
private Boolean recurseDirection(int x, int y, int dx, int dy, int player,
                                 Boolean flip, Boolean flag)
{
    // Move one step in the specified direction. This is the first thing we do
    // since we don't want to check the cell we're starting on.
    x += dx;
    y += dy;

    // Check if we're out of bounds.
    if (x < 0 || x >= gridSize || y < 0 || y >= gridSize)
        return (false);

    // An empty cell invalidates this direction.
    if (grid[x][y] == EMPTY)
        return (false);

    // This is a special case: If we encounter the same color disk that we
    // started with, it can mean two things:
    //
    //   1. The direction is invalid because the first disk we encountered was
    //      the same color as our first.
    //
    //   2. The direction is VALID because the last disk we encountered was the
    //      same color as our first, AND we encountered at least one disk of
    //      opposing color between them.
    //
    // To solve this in an algorithmic manner, we use the flag parameter and set
    // it to true AFTER passing the first disk. This means that the first same-
    // color disk would invalidate the direction, but any same-color disks after
    // opposing color disks validates it, thus completing the evaluation of the
    // direction that was specified.
    if (grid[x][y] == player)
        return (flag);

    // We have - by necessity - passed at least one disk of opposing color when
    // reacing this point, hence we set the flag parameter to true and keep
    // recursing, now looking for a same-color disk.
    flag = true;
    Boolean result = recurseDirection(x, y, dx, dy, player, flip, flag);

    // On the way back (out of the recursion nesting), we mutate the grid if
    // we've been told to flip disks.
    if (result && flip)
        grid[x][y] = player;

    return (result);
}

}
