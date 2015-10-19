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
 * Winner dialog for celebrating the winner when the game is over.
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

/**
 * Initializes the window/stage.
 */
private void setupWindow() {
    setResizable(false);
    setTitle("asyar14h/oomu/lab.2");

    getIcons().add(new Image("images/reversi.png"));
}

}
