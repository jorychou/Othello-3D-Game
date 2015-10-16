package grupp1.othello.controller;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import grupp1.othello.controller.Player;
import grupp1.othello.exception.InvalidMoveException;
import grupp1.othello.exception.InvalidPlayerException;
import grupp1.othello.model.DiskPlacement;
import grupp1.othello.model.GameGrid;

import java.util.ArrayList;

/*------------------------------------------------
 * CLASS
 *----------------------------------------------*/

/**
 * Represents the main game class. This class handles game logic etc.
 *
 * @author Philip Arvidsson (S133686)
 */
public class GameManager {

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
 * First player.
 */
private final Player player1;

/**
 * Second player.
 */
private final Player player2;

/**
 * The game grid to play on.
 */
private final GameGrid gameGrid;

/*------------------------------------------------
 * PUBLIC METHODS
 *----------------------------------------------*/

/**
 * Constructor.
 *
 * @param gameGrid The game grid to use.
 * @param player1 Player one.
 * @param player2 Player two.
 */
public GameManager(GameGrid gameGrid, Player player1, Player player2) {
    this.gameGrid = gameGrid;
    this.player1  = player1;
    this.player2  = player2;
}

/**
 * Initializes the game.
 */
public void init() {
    initGameGrid();

    player1.init();
    player2.init();
}

// @To-do: Cleanup. This method should return the game result as well.
public void play() {
    boolean done = false;

    while (!done) {
        if (validMoves(PLAYER_ONE).length > 0) {
            while (true) {
                DiskPlacement diskPlacement = player1.makeNextMove();
                try {
                    placeDisk(diskPlacement, PLAYER_ONE);
                    break;
                }
                catch (InvalidMoveException e) {
                    player1.notifyInvalidMove();
                }
            }
        }
        if (validMoves(PLAYER_TWO).length > 0) {
            while (true) {
                DiskPlacement diskPlacement = player2.makeNextMove();
                try {
                    placeDisk(diskPlacement, PLAYER_TWO);
                    break;
                }
                catch (InvalidMoveException e) {
                    player2.notifyInvalidMove();
                }
            }
        }

        if (validMoves(1).length == 0 && validMoves(2).length == 0)
            done = true;
    }
}

/*------------------------------------------------
 * PRIVATE METHODS
 *----------------------------------------------*/

/**
 * Initializes the game grid to its starting state.
 */
private void initGameGrid() {
    gameGrid.clear();

    int n = gameGrid.getSize() / 2;

    // Place the starting disks on the grid...
    gameGrid.setCellData(n-1, n-1, PLAYER_ONE);
    gameGrid.setCellData(n-1, n  , PLAYER_TWO);
    gameGrid.setCellData(n  , n-1, PLAYER_TWO);
    gameGrid.setCellData(n  , n  , PLAYER_ONE);
}

/**
 * Checks whether it is considered a valid move to place a disk for the
 * specified player on the board at the given coordinates.
 *
 * @param x      The x-coordinate of the cell to check.
 * @param y      The x-coordinate of the cell to check.
 * @param player The player (player one or player two).
 *
 * @return True if the specified move is considered valid.
 *
 * @throws InvalidPlayerException The specified player index is invalid.
 */
private boolean isValidMove(int x, int y, int player) {
    // Check if we're out of bounds.
    if (x < 0 || x >= gameGrid.getSize() || y < 0 || y >= gameGrid.getSize())
        return (false);

    // New disks can only be placed on empty cells.
    if (gameGrid.getCellData(x, y) != EMPTY)
        return (false);

    return (checkMove(x, y, player));
}

/**
 * Places a disk on the grid at the specified coordinates.
 *
 * @param diskPlacement The disk placement.
 * @param player        The player (player one or player two).
 *
 */
private void placeDisk(DiskPlacement diskPlacement, int player)
    throws InvalidMoveException
{
    if (!isValidMove(diskPlacement.getX(), diskPlacement.getY(), player))
        throw (new InvalidMoveException("Invalid move specified."));

    checkDirections(diskPlacement.getX(), diskPlacement.getY(), player, true);

    // Place final disk to complete the move.
    gameGrid.setCellData(diskPlacement.getX(), diskPlacement.getY(), player);
}

private boolean checkMove(int x, int y, int player) {
    return (checkDirections(x, y, player, false));
}

private void makeMove(int x, int y, int player) {
    checkDirections(x, y, player, true);
}

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
private boolean checkDirections(int x, int y, int player,
                                boolean flip)
{
    // This variable indicates whether any viable direction contains flippable
    // disks.
    boolean result = false;

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
private boolean recurseDirection(int x, int y, int dx, int dy, int player,
                                 boolean flip, boolean flag)
{
    // Move one step in the specified direction. This is the first thing we do
    // since we don't want to check the cell we're starting on.
    x += dx;
    y += dy;

    // Check if we're out of bounds.
    if (x < 0 || x >= gameGrid.getSize() || y < 0 || y >= gameGrid.getSize())
        return (false);

    // An empty cell invalidates this direction.
    if (gameGrid.getCellData(x, y) == EMPTY)
        return (false);

    // This is a special case: If we encounter the same color disk that we
    // started with, it can mean one of two things:
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
    if (gameGrid.getCellData(x, y) == player)
        return (flag);

    // We have - by necessity - passed at least one disk of opposing color when
    // reacing this point, hence we set the flag parameter to true and keep
    // recursing, now looking for a same-color disk.
    flag = true;
    boolean result = recurseDirection(x, y, dx, dy, player, flip, flag);

    // On the way back (out of the recursion nesting), we mutate the grid if
    // we've been told to flip disks.
    if (result && flip)
        gameGrid.setCellData(x, y, player);

    return (result);
}

private Integer[] validMoves(int player) {
    ArrayList<Integer> a = new ArrayList<>();

try {

    for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
            if (isValidMove(i, j, player))
                a.add(1337);
        }
    }
}
catch (Exception e) {
    // lol
}
    Integer[] lol = new Integer[1];
    return (a.toArray(lol));
}

}
