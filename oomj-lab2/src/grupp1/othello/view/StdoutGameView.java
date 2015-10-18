package grupp1.othello.view;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import grupp1.othello.controller.GameManager;
import grupp1.othello.controller.Player;
import grupp1.othello.model.DiskPlacement;

/*------------------------------------------------
 * CLASS
 *----------------------------------------------*/

/**
 * Pretty much a debug class used for testing the game logic without a GUI. This
 * can also be used to implement Othello as a console program.
 *
 * @author Philip Arvidsson (S133686)
 */
public class StdoutGameView {

/*------------------------------------------------
 * FIELDS
 *----------------------------------------------*/

/**
 * The game manger.
 */
private final GameManager gameManager;

/*------------------------------------------------
 * PUBLIC METHODS
 *----------------------------------------------*/

/**
 * Constructor.
 *
 * @param gameManager The game manager.
 */
public StdoutGameView(GameManager gameManager) {
    this.gameManager = gameManager;

    gameManager.onDiskPlaced((player, diskPlacement) -> {
                                 printGrid();
                             })
               .onInvalidMove((player, diskPlacement) -> {
                                  notifyInvalidMove(player, diskPlacement);
                              });
}

/*------------------------------------------------
 * PRIVATE METHODS
 *----------------------------------------------*/

/**
 * Indicates that an attempt has beeen made to do an invalid move.
 *
 * @param player        The player the attempted to perform the move.
 * @param diskPlacement The attempted disk placement.
 */
private void notifyInvalidMove(Player player, DiskPlacement diskPlacement) {
    System.out.println("invalid move: " + player.getName()
                     + " tried to place disk @ (" + diskPlacement.getX()
                     + ", " + diskPlacement.getY() + ")");
}

/**
 * Prints the game grid.
 */
private void printGrid() {
    // Lots of gets, but who cares..?
    for (int y = 0; y < gameManager.getGameGrid().getSize(); y++) {
        for (int x = 0; x < gameManager.getGameGrid().getSize(); x++) {
            int data = gameManager.getGameGrid().getCellData(x, y);

            System.out.print("|");

            switch (data) {

            case GameManager.EMPTY:
                System.out.print("_");
                break;

            case GameManager.PLAYER_ONE:
                System.out.print("B");
                break;

            case GameManager.PLAYER_TWO:
                System.out.print("W");
                break;

            default:
                System.out.print("?");
                break;

            }
        }

        System.out.println("|");
    }

    System.out.println("");
}

}
