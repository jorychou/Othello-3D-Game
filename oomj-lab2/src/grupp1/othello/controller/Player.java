package grupp1.othello.controller;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import grupp1.othello.model.DiskPlacement;

/*------------------------------------------------
 * CLASS
 *----------------------------------------------*/

/**
 * Abstract base class for implementing a player.
 *
 * @author Philip Arvidsson (S133686)
 */
public abstract class Player {

/**
 * The player's name.
 */
private String name;

/*------------------------------------------------
 * PUBLIC METHODS
 *----------------------------------------------*/

/**
 * Constructor.
 */
public Player() {
}

/**
 * Constructor.
 *
 * @param name The player name.
 */
public Player(String name) {
    this.name = name;
}

/**
 * Gets the player's name.
 *
 * @return The player's name.
 */
public String getName() {
    return (name);
}

/**
 * Sets the player's name.
 *
 * @param value The player's name.
 */
public void setName(String value) {
    name = value;
}

/**
 * Initializes the player.
 */
public abstract void initialize();

/**
 * Asks the player to place a disk on the grid.
 *
 * @param gameManager The game manager requesting the move.
 *
 * @return The disk placement.
 */
public abstract DiskPlacement makeNextMove(GameManager gameManager);

/*
 * Notifies a player that the attempted move is invalid.
 *
 * @param diskPlacement The invalid disk placement.
 */
public abstract void notifyInvalidMove(DiskPlacement diskPlacement);

}
