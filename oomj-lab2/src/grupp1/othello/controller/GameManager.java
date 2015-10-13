package grupp1.othello.controller;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

//import blah;

/*------------------------------------------------
 * CLASS
 *----------------------------------------------*/

/**
 * @author
 */
public class GameManager {

/*------------------------------------------------
 * FIELDS
 *----------------------------------------------*/

private final Player player1;
private final Player player2;

private final GameGrid gameGrid;

/*------------------------------------------------
 * PUBLIC METHODS
 *----------------------------------------------*/

public GameManager(GameGrid gameGrid, Player player1, Player player2) {
    this.gameGrid = gameGrid;
    this.player1  = player1;
    this.player2  = player2;
}

public void initialize() {
    gameGrid.initialize();

    player1.initialize();
    player2.initialize();
}

public Object play() {
    Boolean done = false;

    while (!done) {
        if (validMoves(1).length() > 0) {
            int cellIndex = player1.makeNextMove();
            while (true) {
                try {
                    gameGrid.placeMarker(cellIndex, 1);
                    break;
                }
                catch (InvalidMoveException e) {
                    player1.invalidMove(cellIndex);
                }
            }
        }

        if (validMoves(2).length() > 0) {
            cellIndex = player2.makeNextMove();
            while (true) {
                try {
                    gameGrid.placeMarker(cellIndex, 2);
                    break;
                }
                catch (InvalidMoveException e) {
                    player2.invalidMove(cellIndex);
                }
            }
        }

        if (validMoves(1).length() == 0 && validMoves(2).length() == 0)
            done = true;
    }

    return (null);
}

/*------------------------------------------------
 * PRIVATE METHODS
 *----------------------------------------------*/

private int[] validMoves(int playerIndex) {
    ArrayList a = new ArrayList();

    for (int i = 0; i < 63; i++) {
        if (gameGrid.isValidMove(i, playerIndex))
            a.add(i);
    }

    return (a.toArray());
}

}
