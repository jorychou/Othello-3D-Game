package grupp1.othello.view;

import grupp1.othello.model.GameResult;
import javafx.scene.control.Alert;

/**
 *
 * @author Martin Bergqvist (S141564)
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
