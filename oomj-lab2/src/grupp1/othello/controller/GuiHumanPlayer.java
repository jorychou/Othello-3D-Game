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
public class GuiHumanPlayer extends Player {

/*------------------------------------------------
 * PUBLIC METHODS
 *----------------------------------------------*/

/**
 * Constructor.
 *
 * @param name The player name.
 */
public GuiHumanPlayer(String name) {
    super(name);
}

@Override
public void init() {

}

@Override
public DiskPlacement makeNextMove(GameManager gameManager) {
    return (null);
}

@Override
public void notifyInvalidMove() {
}

/*------------------------------------------------
 * PRIVATE METHODS
 *----------------------------------------------*/

}
