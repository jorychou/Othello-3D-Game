package grupp1.othello.controller;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import grupp1.othello.controller.FXMLStage;
import grupp1.othello.model.GameConfiguration;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/*------------------------------------------------
 * CLASS
 *----------------------------------------------*/

/**
 * Initial dialog for configuring the game session.
 *
 * @author Philip Arvidsson (S133686)
 */
public class SetUpGameDialog extends FXMLStage<GameConfiguration> {

/*------------------------------------------------
 * FIELDS
 *----------------------------------------------*/

/**
 * Button for accepting the configuration.
 */
@FXML
private Button playButton;

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

/**
 * Constructor.
 */
public SetUpGameDialog() {
    super(new GameConfiguration());
}

/*------------------------------------------------
 * PROTECTED METHODS
 *----------------------------------------------*/

/**
 * Initializes the stage.
 */
@Override
protected void initialize() {
    setResizable(false);

    player1Name.setText(getModel().getPlayer1Name());
    player2Name.setText(getModel().getPlayer2Name());
}

/*------------------------------------------------
 * PRIVATE METHODS
 *----------------------------------------------*/

/**
 * Action handler for when the play button is pressed.
 */
@FXML
private void playButtonClicked() {
    getModel().setPlayer1Name(player1Name.getText());
    getModel().setPlayer2Name(player2Name.getText());

    close();
}

/**
 * Handler for when a player name has been changed.
 */
@FXML
private void playerNameChanged() {
    Platform.runLater(() ->
        playButton.setDisable(!(player1Name.getText().length() > 0
                             && player2Name.getText().length() > 0))
    );
}

}
