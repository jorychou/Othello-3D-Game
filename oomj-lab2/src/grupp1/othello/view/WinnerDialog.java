package grupp1.othello.view;

import grupp1.othello.model.GameResult;
import javafx.scene.control.Alert;
import javafx.scene.control.Dialog;
import javafx.scene.image.ImageView;

/**
 *
 * @author Martin
 */
public class WinnerDialog{

public WinnerDialog(GameResult result){
    Alert winner = new Alert(Alert.AlertType.INFORMATION);
    winner.setTitle("GameOver");
    winner.setHeaderText("We have a Winner!");
    winner.setContentText("Winner is :" +result.getWinner().getName());
    winner.setResizable(false);
    winner.showAndWait();
}
}
