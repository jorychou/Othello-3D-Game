package grupp1.othello.view;
/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import grupp1.othello.controller.GUIHumanPlayer;
import grupp1.othello.controller.GameManager;
import grupp1.othello.controller.Player;
import grupp1.othello.model.GameGrid;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.effect.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/*------------------------------------------------
 * CLASS
 *----------------------------------------------*/

/**
 * 
 * @author Tkocz
 */
public class GameBoard  {
    
private GridPane board;
private GameManager gameManager;

/*------------------------------------------------
 * PUBLIC METHODS
 *----------------------------------------------*/
public GameBoard(GameManager gameManager){
    this.gameManager = gameManager;
    gameManager.onDiskPlaced((player, diskPlacement) -> {
        Platform.runLater(() -> updateGameBoard());
    });
    DropShadow shade = new DropShadow();
    shade.setColor(Color.GREEN);

    board = new GridPane();
    board.setStyle("-fx-background-image: url(images/backgr.png);"
            + "-fx-background-repeat: stretch;"
            + "-fx-background-size: 480 480;"
            + "-fx-background-position: center center;");       
    board.setGridLinesVisible(true);
    board.setEffect(shade);
    board.setAlignment(Pos.CENTER);

    int i, j;
    for(i = 0; i < 8; i++){
        for(j = 0; j < 8; j++){
            Button tile = new Button();
            tile.setMinSize(60,60);
            tile.setMaxSize(60,60);
            tile.setStyle("-fx-border-color: white; "
                    + "-fx-background-color: transparent");
            GridPane.setRowIndex(tile, i);
            GridPane.setColumnIndex(tile, j);
            tile.setOnAction((ActionEvent e) -> {
                setPlacing(GridPane.getRowIndex(tile),
                        GridPane.getColumnIndex(tile), gameManager.getCurrentPlayer());
            });

            board.getChildren().add(tile);
        }
    }
    
    board.setFocusTraversable(true);
    Platform.runLater(() -> updateGameBoard());
}

public GridPane getGameBoard(){
    return board;
}
/*------------------------------------------------
 * PRIVATE METHODS
 *----------------------------------------------*/

private void setPlacing(int x, int y, Player player){
    ((GUIHumanPlayer)player).setNextMove(x,y);
}
private void updateGameBoard(){
    GameGrid updateGame;
    updateGame = gameManager.getGameGrid();
    //board.getChildren().clear();
    int i, j;
    for(j = 0; j < 8; j++){
        for(i = 0; i < 8; i++){
            if(updateGame.getCellData(i, j) == 1){
                Circle blackMarker = new Circle(20, Color.BLACK);
                board.add(blackMarker, j, i);
                GridPane.setMargin(blackMarker,new Insets(10));
            }
            if(updateGame.getCellData(i, j) == 2){
                Circle whiteMarker =new Circle(20, Color.WHITE);
                board.add(whiteMarker, j, i);
                GridPane.setMargin(whiteMarker,new Insets(10));
            }
        }
    }
}
}
