package grupp1.othello.controller;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import grupp1.othello.controller.FXMLStage;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/*------------------------------------------------
 * CLASS
 *----------------------------------------------*/

/**
 * @author
 */
public class SetUpGameDialog extends FXMLStage {

@FXML
private TextField playerName1;

@FXML
private TextField playerName2;

/*------------------------------------------------
 * PUBLIC METHODS
 *----------------------------------------------*/

/*------------------------------------------------
 * PRIVATE METHODS
 *----------------------------------------------*/

@FXML
private void playAction() {
    System.out.println("Player 1: " + playerName1.getText());
    System.out.println("Player 2: " + playerName2.getText());

    close();
}

}
