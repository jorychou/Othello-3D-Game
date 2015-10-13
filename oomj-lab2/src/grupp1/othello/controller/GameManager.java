package grupp1.othello.controller;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import grupp1.othello.controller.Player;
import grupp1.othello.model.GameGrid;
import grupp1.othello.exception.InvalidMoveException;

import java.util.ArrayList;

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
        if (validMoves(1).length > 0) {
            int[] xy = player1.makeNextMove();
            while (true) {
                try {
                    gameGrid.placeMarker(xy[0], xy[1], 1);
                    break;
                }
                catch (InvalidMoveException e) {
                    player1.notifyInvalidMove();
                }
            }
        }

        if (validMoves(2).length > 0) {
            int[] xy = player2.makeNextMove();
            while (true) {
                try {
                    gameGrid.placeMarker(xy[0], xy[1], 2);
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

    return (null);
}

/*------------------------------------------------
 * PRIVATE METHODS
 *----------------------------------------------*/

private Integer[] validMoves(int playerIndex) {
    ArrayList<Integer> a = new ArrayList<>();

    for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
            if (gameGrid.isValidMove(i, j, playerIndex))
                a.add(1337);
        }
    }

    Integer[] lol = new Integer[1];
    return (a.toArray(lol));
}

}
