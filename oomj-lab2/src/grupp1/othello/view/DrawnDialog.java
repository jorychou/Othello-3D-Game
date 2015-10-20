package grupp1.othello.view;

import javafx.scene.control.Alert;
import javafx.scene.control.Dialog;
import javafx.scene.image.ImageView;

/**
 *
 * @author Martin
 */
public class DrawnDialog extends Dialog{

public void drawnDialog(){
    Alert drawn = new Alert(Alert.AlertType.INFORMATION);
    drawn.setTitle("GameOver");
    drawn.setHeaderText("We have no Winner!");
    drawn.setContentText("The game was a Draw!");
    drawn.setResizable(false);
    //drawn.setGraphic(new ImageView(this.getClass().getResource("resources/images/reversi.png").toString()));
    drawn.showAndWait();
}
}