package grupp1.othello.model;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

/*------------------------------------------------
 * CLASS
 *----------------------------------------------*/

/*------------------------------------------------
 * FIELDS
 *----------------------------------------------*/

/**
 * Dialog result for the initial game configuration dialog.
 *
 * @author Philip Arvidsson (S133686)
 */
public class SetUpGameDialogResult {

/**
 * First player's name.
 */
private String player1Name;

/**
 * Second player's name.
 */
private String player2Name;

/*------------------------------------------------
 * PUBLIC METHODS
 *----------------------------------------------*/

/**
 * Constructor.
 *
 * @param player1Name First player's name.
 * @param playerName2 Second player's name.
 */
public SetUpGameDialogResult(String player1Name, String player2Name) {
    this.player1Name = player1Name;
    this.player2Name = player2Name;
}

/**
 * Gets the first player's name.
 *
 * @return The first player's name.
 */
public String getPlayer1Name() {
    return (player1Name);
}

/**
 * Gets the second player's name.
 *
 * @return The second player's name.
 */
public String getPlayer2Name() {
    return (player2Name);
}

}
