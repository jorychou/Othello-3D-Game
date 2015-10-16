package grupp1.othello.controller;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.util.function.Consumer;
import java.util.function.BiConsumer;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

/*------------------------------------------------
 * CLASS
 *----------------------------------------------*/

/**
 * Provides an intermediary FXML loader class that automatically loads its
 * associated view upon instantiation.
 *
 * @author Philip Arvidsson (S133686)
 */
public class GameWindowBase<T> extends Stage {

/*------------------------------------------------
 * FIELDS
 *----------------------------------------------*/

/**
 * The function to be called when the stage has achieved its life purpose.
 */
private Consumer<T> completeCallback;

/**
 * Function to be called when something has gone wrong.
 */
private BiConsumer<T, Object> errorCallback;

/**
 * The data storage object.
 */
private T model;

/*------------------------------------------------
 * PUBLIC METHODS
 *----------------------------------------------*/

/**
 * Constructor. FXML for the view is automatically loaded in it.
 *
 * @param model The view model.
 */
public GameWindowBase(T model) {
    String     className = getClass().getSimpleName();
    String     viewName  = "/fxml/" + className + ".fxml";
    FXMLLoader fxml      = new FXMLLoader(getClass().getResource(viewName));

    this.model = model;

    fxml.setController(this);

    try {
        setScene(fxml.load());
    }
    catch (IOException e) {
        e.printStackTrace();
    }
}

/**
 * Assigns a complete handler function to the stage.
 *
 * @param cb The complete handler callback function.
 *
 * @return The stage itself.
 */
public GameWindowBase<T> onComplete(Consumer<T> cb) {
    completeCallback = cb;
    return (this);
}

/**
 * Assigns an error handler function to the stage.
 *
 * @param cb The error handler callback function.
 *
 * @return The stage itself.
 */
public GameWindowBase<T> onError(BiConsumer<T, Object> cb) {
    errorCallback = cb;
    return (this);
}

/**
 * Gets the data storage object.
 *
 * @return The data storage object.
 */
public T getModel() {
    return (model);
}

/**
 * Shows the stage and blocks until its done. The complete handler will be
 * called if one has been set.
 */
@Override
public void showAndWait() {
    init();

    // @To-do: Not sure if this is a good idea.
    sizeToScene();

    super.showAndWait();
    complete();
}

/*------------------------------------------------
 * PROTECTED METHODS
 *----------------------------------------------*/

/**
 * Calls the error handler if one has been set.
 *
 * @param data Error data.
 */
protected void error(Object data) {
    if (errorCallback != null)
        errorCallback.accept(model, data);

    // Simple h4x to prevent the complete callback from being called! lol!
    completeCallback = null;
}

/**
 * Initializes the stage.
 */
protected void init() {
}

/*------------------------------------------------
 * PRIVATE METHODS
 *----------------------------------------------*/

/**
 * Calls the complete handler if one has been set.
 */
private void complete() {
    if (completeCallback != null)
        completeCallback.accept(model);
}

}
