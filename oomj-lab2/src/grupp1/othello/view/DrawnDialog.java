package grupp1.othello.view;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/
import javafx.scene.control.Alert;

/*------------------------------------------------
 * CLASS
 *----------------------------------------------*/

/**
 * The dialog that lets the players know it's a Draw
 *
 * @author Martin Bergqvist (S141564)
 */
public class DrawnDialog{

 /*------------------------------------------------
 * PUBLIC METHODS
 *----------------------------------------------*/

/**
 * Dialog for the end-game scenario Draw
 */
public DrawnDialog(){
    Alert drawn = new Alert(Alert.AlertType.INFORMATION);
    drawn.setTitle("GameOver");
    drawn.setHeaderText("We have no Winner!");
    drawn.setContentText("The game was a Draw!");
    drawn.setResizable(false);
    drawn.showAndWait();
}
}