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
 * Represents an A.I. controlled player.
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

@Override
public void init() {}

@Override
public DiskPlacement makeNextMove(GameManager gameManager) {
    int i = gameManager.getCurrentPlayerIndex();
    DiskPlacement[] diskPlacements = gameManager.findValidDiskPlacements(i);

    int n = ThreadLocalRandom.current().nextInt(0, diskPlacements.length);

    // Look thoughtful for a bit. :-)
    try {
        Thread.sleep(ThreadLocalRandom.current().nextInt(500, 2000));
    }
    catch (InterruptedException e) {}

    return (diskPlacements[n]);
}

@Override
public void notifyInvalidMove() {}

/*------------------------------------------------
 * PRIVATE METHODS
 *----------------------------------------------*/

}
