package grupp1.othello.controller;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import grupp1.othello.controller.GameWindow;
import grupp1.othello.model.GameConfig;
import grupp1.othello.model.PlayerType;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;

/*------------------------------------------------
 * CLASS
 *----------------------------------------------*/

/**
 * Initial dialog for configuring the game session.
 *
 * @author Philip Arvidsson (S133686)
 */
public class ConfigWindow extends GameWindow<GameConfig> {

/*------------------------------------------------
 * FIELDS
 *----------------------------------------------*/

@FXML private javafx.animation.RotateTransition kewk1;
@FXML private javafx.animation.RotateTransition kewk2;

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
public ConfigWindow() {
    super(new GameConfig());
}

/*------------------------------------------------
 * PROTECTED METHODS
 *----------------------------------------------*/

/**
 * Initializes the stage.
 */
@Override
protected void init() {
    setResizable(false);
    setTitle("asyar14h/oomu/lab.2");
    getIcons().add(new Image("images/reversi.png"));

    setupModel();
    setupHandlers();
    setupBindings();

    kewk1.play();
    kewk2.play();
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
