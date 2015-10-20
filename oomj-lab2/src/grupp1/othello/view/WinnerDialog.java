package grupp1.othello.view;

import javafx.scene.control.Alert;
import javafx.scene.control.Dialog;
import javafx.scene.image.ImageView;

/**
 *
 * @author Martin
 */
public class WinnerDialog extends Dialog{

public void winnerDialog(){
    Alert winner = new Alert(Alert.AlertType.INFORMATION);
    winner.setTitle("GameOver");
    winner.setHeaderText("We have a Winner!");
    winner.setContentText("Winner is :" /*+player*/);
    winner.setResizable(false);
    //winner.setGraphic(new ImageView(this.getClass().getResource("resources/images/reversi.png").toString()));
    winner.showAndWait();
}
}
