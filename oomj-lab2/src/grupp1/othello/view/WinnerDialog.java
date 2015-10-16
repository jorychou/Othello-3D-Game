package grupp1.othello.controller;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import grupp1.othello.controller.GameWindowBase;
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
public class WinnerDialog extends GameWindowBase<Object> {

/*------------------------------------------------
 * FIELDS
 *----------------------------------------------*/

/*------------------------------------------------
 * PUBLIC METHODS
 *----------------------------------------------*/

/**
 * Constructor.
 */
public WinnerDialog() {
    super(null);
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
    setTitle("Winner!");
    getIcons().add(new Image("images/reversi.png"));

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
}

/**
 * Sets up the control event handlers.
 */
private void setupHandlers() {
}

/**
 * Initializes the model to some defaults.
 */
private void setupModel() {
}

/**
 * Initializes the transitions and starts them.
 */
private void setupTransitions() {
}

}
