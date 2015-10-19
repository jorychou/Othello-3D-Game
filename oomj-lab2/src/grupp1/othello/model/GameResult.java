package grupp1.othello.model;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import grupp1.othello.controller.Player;

/*------------------------------------------------
 * CLASS
 *----------------------------------------------*/

/**
 * Contains the results from a game.
 *
 * @author Philip Arvidsson (S133686)
 */
public class GameResult {

/*------------------------------------------------
 * FIELDS
 *----------------------------------------------*/

/**
 * The players that participated in the game.
 */
private Player[] players;

/**
 * The winning player.
 */
private Player winner;

/*------------------------------------------------
 * PUBLIC METHODS
 *----------------------------------------------*/

/**
 * Gets the players that participated in the game.
 *
 * @return The players that participated in the game.
 */
public Player[] getPlayers() {
    return (players.clone());
}

/**
 * Sets the players that participated in the game.
 *
 * @param value The players that participated in the game.
 */
public void setPlayers(Player... value) {
    players = value;
}

/**
 * Gets the winning player.
 *
 * @return The winning player.
 */
public Player getWinner() {
    return (winner);
}

/**
 * Sets the winning player.
 *
 * @param value The winning player.
 */
public void setWinner(Player value) {
    winner = value;
}

}
