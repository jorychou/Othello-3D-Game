package grupp1.othello.controller;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import grupp1.othello.controller.FXMLStage;
import grupp1.othello.model.SetUpGameDialogResult;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/*------------------------------------------------
 * CLASS
 *----------------------------------------------*/

/*------------------------------------------------
 * FIELDS
 *----------------------------------------------*/

/**
 * Initial dialog for configuring the game session.
 *
 * @author Philip Arvidsson (S133686)
 */
public class SetUpGameDialog extends FXMLStage<SetUpGameDialogResult> {

/**
 * Text field for entering the first player's name.
 */
@FXML
private TextField player1Name;

/**
 * Text field for entering the second player's name.
 */
@FXML
private TextField player2Name;

/*------------------------------------------------
 * PUBLIC METHODS
 *----------------------------------------------*/

/*------------------------------------------------
 * PRIVATE METHODS
 *----------------------------------------------*/

/**
 * Action handler for when the play button is pressed.
 */
@FXML
private void playAction() {
    setResult(new SetUpGameDialogResult(player1Name.getText(),
                                        player2Name.getText()));

    close();
}

}
