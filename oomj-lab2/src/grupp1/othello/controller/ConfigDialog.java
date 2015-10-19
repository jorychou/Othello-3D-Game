package grupp1.othello.controller;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import grupp1.othello.controller.GameWindowBase;
import grupp1.othello.model.GameConfig;
import grupp1.othello.model.PlayerType;

import javafx.animation.RotateTransition;
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
public class ConfigDialog extends GameWindowBase<GameConfig> {

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

/**
 * Disk rotate transition 1.
 */
@FXML
private RotateTransition rotateTransition1;

/**
 * Disk rotate transition 2. Used in conjunction with the other transition to
 * create a double-axis rotation effect.
 */
@FXML
private RotateTransition rotateTransition2;

/*------------------------------------------------
 * PUBLIC METHODS
 *----------------------------------------------*/

/**
 * Constructor.
 */
public ConfigDialog() {
    super(new GameConfig());
}

/**
 * Constructor.
 *
 * @param model The model to use.
 */
public ConfigDialog(GameConfig model) {
    super(model);
}

/*------------------------------------------------
 * PROTECTED METHODS
 *----------------------------------------------*/

/**
 * Initializes the stage.
 */
@Override
protected void initialize() {
    setupWindow();
    setupModel();
    setupHandlers();
    setupBindings();
    setupTransitions();
}

/*------------------------------------------------
 * PRIVATE METHODS
 *----------------------------------------------*/

/**
 * Sets up all bindings.
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

/**
 * Initializes the transitions and starts them.
 */
private void setupTransitions() {
    rotateTransition1.play();
    rotateTransition2.play();
}

/**
 * Initializes the window/stage.
 */
private void setupWindow() {
    setResizable(false);
    setTitle("asyar14h/oomu/lab.2 - grupp 1");

    getIcons().add(new Image("images/reversi.png"));
}

}
