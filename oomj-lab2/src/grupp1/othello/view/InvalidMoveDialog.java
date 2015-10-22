package grupp1.othello.view;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/
import javafx.scene.control.Alert;

/*------------------------------------------------
 * CLASS
 *----------------------------------------------*/

/**
 * The dialog that lets the players know that a marker cannot 
 * be placed at that tile
 * 
 * @author Martin Bergqvist (S141564)
 */
public class InvalidMoveDialog{

 /*------------------------------------------------
 * PUBLIC METHODS
 *----------------------------------------------*/
    
/**
 * Error-dialog for instances of attempt at invalid moves
 */
public InvalidMoveDialog(){
    Alert nope = new Alert(Alert.AlertType.ERROR);
    nope.setTitle("Invalid Move");
    nope.setHeaderText("You cannot place your marker there!");
    nope.setContentText("Try another tile");
    nope.setResizable(false);
    nope.showAndWait();
}
}