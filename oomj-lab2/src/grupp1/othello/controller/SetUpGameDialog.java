package grupp1.othello.controller;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import grupp1.othello.controller.FXMLStage;
import grupp1.othello.model.GameConfiguration;
import grupp1.othello.model.PlayerType;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
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
    setTitle("asyar14h/oomu/lab.2");

    setupModel();
    setupHandlers();
    setupBindings();
}

/*------------------------------------------------
 * PRIVATE METHODS
 *----------------------------------------------*/

/**
 * Sets up all bindings. Some in a slightly more inane manner than others.
 */
private void setupBindings() {
    player1Name.textProperty().bindBidirectional(
        getModel().player1NameProperty());
    player2Name.textProperty().bindBidirectional(
        getModel().player2NameProperty());

    // Disable play button when a name is missing.
    playButton.disableProperty().bind(
        Bindings.createBooleanBinding(() ->
            getModel().player1NameProperty().isEmpty().getValue()
         || getModel().player2NameProperty().isEmpty().getValue(),
            getModel().player1NameProperty(), getModel().player2NameProperty()
        )
    );
}

/**
 * Sets up the control event handlers.
 */
private void setupHandlers() {
    playButton.setOnAction(e -> close());
}

/**
 * Initializes the model to some defaults.
 */
private void setupModel() {
    getModel().setPlayer1Name("Player");
    getModel().setPlayer1Type(PlayerType.HUMAN);

    getModel().setPlayer2Name("Computer");
    getModel().setPlayer2Type(PlayerType.COMPUTER);
}

}
