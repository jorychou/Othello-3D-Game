package grupp1.othello.controller;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import grupp1.othello.exception.InvalidMoveException;
import grupp1.othello.model.DiskPlacement;

/*------------------------------------------------
 * CLASS
 *----------------------------------------------*/

/**
 * @author
 */
public class GUIHumanPlayer extends Player {

/*------------------------------------------------
 * FIELDS
 *----------------------------------------------*/

private DiskPlacement diskPlacement;
private final Object lock = new Object();

/*------------------------------------------------
 * PUBLIC METHODS
 *----------------------------------------------*/

/**
 * Constructor.
 *
 * @param name The player name.
 */
public GUIHumanPlayer(String name) {
    super(name);
}

/**
 * Initializes the player.
 */
@Override
public void initialize() {}

/**
 * Asks the player to place a disk on the grid.
 *
 * @param gameManager The game manager requesting the move.
 *
 * @return The disk placement.
 */
@Override
public DiskPlacement makeNextMove(GameManager gameManager) {
    synchronized (lock) {
        try {
            lock.wait();
        }
        catch (InterruptedException e) {
            // Not much we can do here.
        }

        DiskPlacement result = diskPlacement;
        diskPlacement = null;

        // This should never happen.
        assert(result != null);

        return (result);
    }
}

/**
 * Notifies a player that the attempted move is invalid.
 *
 * @param diskPlacement The invalid disk placement.
 */
@Override
public void notifyInvalidMove(DiskPlacement diskPlacement) {}

/**
 * Sets the next move (and allows the makeNextMove() method to stop blocking
 * and instead return the move specified by the call to this method).
 *
 * @param The x-coordinate of the disk placement.
 * @param The y-coordinate of the disk placement.
 */
public void setNextMove(int x, int y) {
    synchronized (lock) {
        diskPlacement = new DiskPlacement(x, y);
        lock.notify();
    }
}

/*------------------------------------------------
 * PRIVATE METHODS
 *----------------------------------------------*/

}
