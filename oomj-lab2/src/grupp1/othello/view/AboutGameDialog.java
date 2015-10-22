package grupp1.othello.view;

import javafx.scene.control.Alert;

/**
 *
 * @author Martin Bergqvist (S141564)
 */
public class AboutGameDialog{

    /**
     * Dialog about the Game
     */
    public AboutGameDialog(){
        Alert aboutGame = new Alert(Alert.AlertType.INFORMATION);
        aboutGame.setTitle("About Othello: Not for N00bs Edition");
        aboutGame.setHeaderText(null);
        aboutGame.setContentText("Philip Arvidsson (S133686) & "
                + "Martin Bergqvist (S141564) created this Epic game-replica for"
                + " recreational & laborative purposes. Enjoy!");
        aboutGame.showAndWait();
}
}