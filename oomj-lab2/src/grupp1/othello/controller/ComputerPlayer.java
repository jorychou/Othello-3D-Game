package grupp1.othello.controller;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import grupp1.othello.model.DiskPlacement;

import java.util.concurrent.ThreadLocalRandom;

/*------------------------------------------------
 * CLASS
 *----------------------------------------------*/

/**
 * Represents an A.I. (artificially idiotic) player.
 *
 * @author Philip Arvidsson (S133686)
 */
public class ComputerPlayer extends Player {

/*------------------------------------------------
 * PUBLIC METHODS
 *----------------------------------------------*/

/**
 * Constructor.
 *
 * @param name The player name.
 */
public ComputerPlayer(String name) {
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
    // This AI (artifical idiot) basically just picks a random, valid move. It
    // is, in every sense of the word, retarded. But hey, beginner's luck might
    // get you somewhere! Right!?

    int i = gameManager.getCurrentPlayerIndex();
    DiskPlacement[] diskPlacements = gameManager.findValidDiskPlacements(i);

    int n = ThreadLocalRandom.current().nextInt(0, diskPlacements.length);

    // Look thoughtful for a bit. :-)
    try {
        Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 2000));
    }
    catch (InterruptedException e) {}

    return (diskPlacements[n]);
}

/**
 * Notifies a player that the attempted move is invalid.
 *
 * @param diskPlacement The invalid disk placement.
 */
@Override
public void notifyInvalidMove(DiskPlacement diskPlacement) {}

}
