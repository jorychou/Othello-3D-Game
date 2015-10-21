package grupp1.othello.controller;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import grupp1.othello.model.DiskPlacement;

import java.util.Scanner;

/*------------------------------------------------
 * CLASS
 *----------------------------------------------*/

/**
 * Human player that reads its input from stdin.
 *
 * @author Philip Arvidsson S(133686)
 */
public class StdinHumanPlayer extends Player {

/*------------------------------------------------
 * PUBLIC METHODS
 *----------------------------------------------*/

/**
 * Constructor.
 *
 * @param name The player name.
 */
public StdinHumanPlayer(String name) {
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
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter coordinates:");

    return (new DiskPlacement(scanner.nextInt(), scanner.nextInt()));
}

/**
 * Notifies a player that the attempted move is invalid.
 *
 * @param diskPlacement The invalid disk placement.
 */
@Override
public void notifyInvalidMove(DiskPlacement diskPlacement) {}

}
