package grupp1.othello.controller;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import grupp1.othello.controller.Player;
import grupp1.othello.exception.InvalidMoveException;
import grupp1.othello.exception.InvalidPlayerException;
import grupp1.othello.model.GameGrid;

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

public void init() {
    gameGrid.init();

    player1.init();
    player2.init();
}

// @To-do: Cleanup
public void play()
    throws InvalidMoveException, InvalidPlayerException
{
    boolean done = false;

    while (!done) {
        if (validMoves(1).length > 0) {
            while (true) {
                int[] xy = player1.makeNextMove();
                try {
                    gameGrid.placeDisk(xy[0], xy[1], GameGrid.PLAYER_ONE);
                    break;
                }
                catch (InvalidMoveException e) {
                    player1.notifyInvalidMove();
                }
            }
        }
        if (validMoves(2).length > 0) {
            while (true) {
                int[] xy = player2.makeNextMove();
                try {
                    gameGrid.placeDisk(xy[0], xy[1], GameGrid.PLAYER_TWO);
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
}

/*------------------------------------------------
 * PRIVATE METHODS
 *----------------------------------------------*/

private Integer[] validMoves(int player) {
    ArrayList<Integer> a = new ArrayList<>();

try {

    for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
            if (gameGrid.isValidMove(i, j, player))
                a.add(1337);
        }
    }
}
catch (Exception e) {
    // lol
}
    Integer[] lol = new Integer[1];
    return (a.toArray(lol));
}

}
