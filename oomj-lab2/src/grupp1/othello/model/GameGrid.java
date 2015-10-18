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
 * Comment: This class became redundant when game logic was moved over to the
 *          game manager class. What is left is basically a wrapper for a two-
 *          dimensional array. Still, this class will be kept in the project to
 *          stay true to the assignment specification. // Philip Arvidsson
 *
 * @author Martin Bergqvist (S133686)
 */
public class GameGrid  {

/*------------------------------------------------
 * CONSTANTS
 *----------------------------------------------*/

/**
 * The default game grid size.
 */
public static final int DEFAULT_SIZE = 8;

/*------------------------------------------------
 * FIELDS
 *----------------------------------------------*/

/**
 * The grid contents.
 */
private int[][] grid;

/**
 * The width and height of the grid, in number of cells.
 */
private final int gridSize;

/*------------------------------------------------
 * PUBLIC METHODS
 *----------------------------------------------*/

/**
 * Constructs a game grid of default size.
 */
public GameGrid() {
    this.gridSize = DEFAULT_SIZE;

    // Allocate a square game grid of the specified size.
    grid = new int[gridSize][gridSize];
}

/**
 * Constructor.
 *
 * @param gridSize The size (width and height) of the grid, in number of cells.
 */
public GameGrid(int gridSize) {
    // A grid with a side length of less than four cells isn't useful. We
    // require at least 16 cells in the grid.
    if (gridSize < 4)
        gridSize = 4;

    this.gridSize = gridSize;

    // Allocate a square game grid of the specified size.
    grid = new int[gridSize][gridSize];
}

/**
 * Clears the grid and zeroes the cell data.
 */
public void clear() {
    for (int i = 0; i < gridSize; i++)
        Arrays.fill(grid[i], 0);
}

/**
 * Gets the grid size, in number of cells.
 *
 * @return The grid size, in number of cells.
 */
public int getSize() {
    return (gridSize);
}

/**
 * Gets the cell data at the specified coordinates.
 *
 * @param x    The x-coordinate of the cell.
 * @param y    The y-coordinate of the cell.
 *
 * @return The cell data.
 */
public int getCellData(int x, int y) {
    assertWithinBounds(x, y);

    return (grid[x][y]);
}

/**
 * Sets the cell data for the cell at the specified coordinates.
 *
 * @param x    The x-coordinate of the cell.
 * @param y    The y-coordinate of the cell.
 * @param data The data to place in the cell at the specified coordinates.
 */
public void setCellData(int x, int y, int data) {
    assertWithinBounds(x, y);

    grid[x][y] = data;
}

/*------------------------------------------------
 * PRIVATE METHODS
 *----------------------------------------------*/

/**
 * Asserts that the specified coordinates are within the grid bounds.
 *
 * @param x The x-coordinate.
 * @param y The y-coordinate.
 */
private void assertWithinBounds(int x, int y) {
    // Oracle tell us to not use assert in this manner (i.e. public method
    // parameter checking) but I think it's ok for this assignment.
    assert (x >= 0 && x < gridSize);
    assert (y >= 0 && y < gridSize);
}

}
