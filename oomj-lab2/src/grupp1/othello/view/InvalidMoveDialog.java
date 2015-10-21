package grupp1.othello.view;

import javafx.scene.control.Alert;

/**
 *
 * @author Martin Bergqvist (S141564)
 */
public class InvalidMoveDialog{


public InvalidMoveDialog(){
    Alert nope = new Alert(Alert.AlertType.ERROR);
    nope.setTitle("Invalid Move");
    nope.setHeaderText("You cannot place your marker there!");
    nope.setContentText("Try another tile");
    nope.setResizable(false);
    nope.showAndWait();
}
}