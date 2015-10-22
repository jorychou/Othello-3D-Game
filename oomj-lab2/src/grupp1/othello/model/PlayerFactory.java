package grupp1.othello.model;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import grupp1.othello.controller.ComputerPlayer;
import grupp1.othello.controller.GUIHumanPlayer;
import grupp1.othello.controller.Player;

/*------------------------------------------------
 * CLASS
 *----------------------------------------------*/

/**
 * Factory for creating players.
 *
 * @author Philip Arvidsson (S133686)
 */
public class PlayerFactory {

/*------------------------------------------------
 * PUBLIC METHODS
 *----------------------------------------------*/

/**
 * Creates a player with the specified name, of the specified type.
 *
 * @param name The player name.
 * @param type The player type.
 *
 * @return A new player instance.
 */
public Player getPlayer(String name, PlayerType type) {
    switch (type) {

    case COMPUTER: return (new ComputerPlayer(name));
    case HUMAN   : return (new GUIHumanPlayer(name));

    }

    return (null);
}

}
