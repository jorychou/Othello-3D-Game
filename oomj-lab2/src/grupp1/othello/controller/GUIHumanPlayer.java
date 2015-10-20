package grupp1.othello.controller;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import grupp1.othello.model.DiskPlacement;

/*------------------------------------------------
 * CLASS
 *----------------------------------------------*/

/**
 * @author
 */
public class GUIHumanPlayer extends Player {

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
    // wait for disk placement to be set
    // then return diskplacement
    return (null);
}

/**
 * Notifies a player that the attempted move is invalid.
 *
 * @param diskPlacement The invalid disk placement.
 */
@Override
public void notifyInvalidMove(DiskPlacement diskPlacement) {}

/*------------------------------------------------
 * PRIVATE METHODS
 *----------------------------------------------*/

}
