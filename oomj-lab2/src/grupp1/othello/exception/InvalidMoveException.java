package grupp1.othello.exception;

/*------------------------------------------------
 * CLASS
 *----------------------------------------------*/

/**
 * The exception that is thrown when an attempt is made to make an invalid move.
 *
 * @author Philip Arvidsson (S133686)
 */
public class InvalidMoveException extends Exception {

/*------------------------------------------------
 * PUBLIC METHODS
 *----------------------------------------------*/

/**
 * Constructor.
 *
 * @param message The exception message.
 */
public InvalidMoveException(String message) {
    super(message);
}

/*------------------------------------------------
 * PRIVATE METHODS
 *----------------------------------------------*/

}
