package grupp1.othello.view;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;

/*------------------------------------------------
 * CLASS
 *----------------------------------------------*/

/**
 * @author
 */
public class SetUpGameDialog extends Pane {

/*------------------------------------------------
 * PUBLIC METHODS
 *----------------------------------------------*/

public SetUpGameDialog() {
    super();

    VBox vbox = new VBox();

    HBox hbox1 = new HBox();

    hbox1.setSpacing(10);
    hbox1.getChildren().add(new Label("Namn 1"));
    hbox1.getChildren().add(new TextField());

    HBox hbox2 = new HBox();

    hbox2.setSpacing(10);
    hbox2.getChildren().add(new Label("Namn 2"));
    hbox2.getChildren().add(new TextField());

    vbox.getChildren().add(hbox1);
    vbox.getChildren().add(hbox2);

    vbox.setSpacing(10);
    vbox.setStyle("-fx-padding: 30");
    getChildren().add(vbox);

}

/*------------------------------------------------
 * PRIVATE METHODS
 *----------------------------------------------*/

}
