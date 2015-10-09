package grupp1.othello.model;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import grupp1.othello.model.PlayerType;

/*------------------------------------------------
 * CLASS
 *----------------------------------------------*/

/**
 * Contains information about the game configuration.
 *
 * @author Philip Arvidsson (S133686)
 */
public class GameConfiguration {

/*------------------------------------------------
 * FIELDS
 *----------------------------------------------*/

/**
 * First player's name.
 */
private String player1Name = "Player 1";

/**
 * First player's type.
 */
private PlayerType player1Type;

/**
 * Second player's name.
 */
private String player2Name = "Player 2";

/**
 * Second player's type.
 */
private PlayerType player2Type;

/*------------------------------------------------
 * PUBLIC METHODS
 *----------------------------------------------*/

/**
 * Gets the first player's name.
 *
 * @return The first player's name.
 */
public String getPlayer1Name() {
    return (player1Name);
}

/**
 * Sets the first player's name.
 *
 * @param value Player name.
 */
public void setPlayer1Name(String value) {
    player1Name = value;
}

/**
 * Gets the first player's type.
 *
 * @return The first player's type.
 */
public PlayerType getPlayer1Type() {
    return (player1Type);
}

/**
 * Sets the first player's type.
 *
 * @param value Player type.
 */
public void setPlayer1Type(PlayerType value) {
    player1Type = value;
}

/**
 * Gets the second player's name.
 *
 * @return The second player's name.
 */
public String getPlayer2Name() {
    return (player2Name);
}

/**
 * Sets the second player's name.
 *
 * @param value Player name.
 */
public void setPlayer2Name(String value) {
    player2Name = value;
}

/**
 * Gets the first player's type.
 *
 * @return The first player's type.
 */
public PlayerType getPlayer2Type() {
    return (player2Type);
}

/**
 * Sets the first player's type.
 *
 * @param value Player type.
 */
public void setPlayer2Type(PlayerType value) {
    player2Type = value;
}

}
