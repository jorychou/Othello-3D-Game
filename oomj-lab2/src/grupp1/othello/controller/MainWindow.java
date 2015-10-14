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

/*------------------------------------------------
 * CLASS
 *----------------------------------------------*/

/**
 * Main game window.
 *
 * @author Philip Arvidsson (S133686)
 */
public class MainWindow extends GameWindow<Object> {

/*------------------------------------------------
 * FIELDS
 *----------------------------------------------*/

/*------------------------------------------------
 * PUBLIC METHODS
 *----------------------------------------------*/

/**
 * Constructor.
 */
public MainWindow() {
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

}
