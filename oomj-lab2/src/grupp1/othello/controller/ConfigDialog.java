package grupp1.othello.controller;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import grupp1.othello.Othello;
import grupp1.othello.controller.GameWindowBase;
import grupp1.othello.model.GameConfig;
import grupp1.othello.model.PlayerType;

import javafx.animation.RotateTransition;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
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

@FXML
private CheckBox enable3D;

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
 * The type selection for player one.
 */
@FXML
private ToggleGroup player1Type;

/**
 * Text field for entering the second player's name.
 */
@FXML
private TextField player2Name;

/**
 * The type selection for player two.
 */
@FXML
private ToggleGroup player2Type;

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
    setupStage      ();
    setupModel      ();
    setupHandlers   ();
    setupBindings   ();
    setupTransitions();
}

/*------------------------------------------------
 * PRIVATE METHODS
 *----------------------------------------------*/

/**
 * Sets up all bindings.
 */
private void setupBindings() {
    enable3D.selectedProperty().bindBidirectional(
        getModel().enable3DProperty());
    player1Name.textProperty().bindBidirectional(
        getModel().player1NameProperty());

    player2Name.textProperty().bindBidirectional(
        getModel().player2NameProperty());

    // For whatever reason, the commented code below is broken, so I decided to
    // add listeners directly instead. Wtf?

    /*getModel().player1TypeProperty().bind(
        Bindings.createObjectBinding(() ->
            // Value binding.
            (PlayerType)player1Type.getSelectedToggle().getUserData(),

            // Dependencies.
            player1Type.selectedToggleProperty()
        )
    );

    getModel().player2TypeProperty().bind(
        Bindings.createObjectBinding(() ->
            // Value binding.
            (PlayerType)player2Type.getSelectedToggle().getUserData(),

            // Dependencies.
            player2Type.selectedToggleProperty()
        )
    );*/

    player1Type.selectedToggleProperty().addListener((observable) -> {
        Object data = player1Type.getSelectedToggle().getUserData();
        getModel().setPlayer1Type((PlayerType)data);
    });

    player2Type.selectedToggleProperty().addListener((observable) -> {
        Object data = player2Type.getSelectedToggle().getUserData();
        getModel().setPlayer2Type((PlayerType)data);
    });

    // Disable play button when a name is missing. Also make sure names are not
    // too long.
    playButton.disableProperty().bind(
        Bindings.createBooleanBinding(() -> {
            if (player1Name.getText().length() > Othello.maxNameLength) {
                player1Name.setText(
                    player1Name.getText().substring(0, Othello.maxNameLength)
                );
            }

            if (player2Name.getText().length() > Othello.maxNameLength) {
                player2Name.setText(
                    player2Name.getText().substring(0, Othello.maxNameLength)
                );
            }

            return (player1Name.getText().length() == 0)
                || (player2Name.getText().length() == 0);
        },
            // Value binding.


            // Dependencies.
            player1Name.textProperty(),
            player2Name.textProperty()
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
 * Initializes the stage/window.
 */
private void setupStage() {
    setResizable(false);
    setTitle("asyar14h/oomu/lab.2 - grupp 1");

    getIcons().add(new Image("images/reversi.png"));
}

}
