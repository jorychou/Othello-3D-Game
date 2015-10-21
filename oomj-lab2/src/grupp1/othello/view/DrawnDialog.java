package grupp1.othello.view;

import javafx.scene.control.Alert;

/**
 *
 * @author Martin Bergqvist (S141564)
 */
public class DrawnDialog{

public DrawnDialog(){
    Alert drawn = new Alert(Alert.AlertType.INFORMATION);
    drawn.setTitle("GameOver");
    drawn.setHeaderText("We have no Winner!");
    drawn.setContentText("The game was a Draw!");
    drawn.setResizable(false);
    drawn.showAndWait();
}
}