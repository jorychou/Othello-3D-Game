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
import javafx.scene.control.Button;

/*------------------------------------------------
 * CLASS
 *----------------------------------------------*/

/**
 * The GameBoard is the playfield
 * 
 * @author Martin Bergqvist (S141564)
 */
public class GameBoard  {

private GridPane board;
private GameManager gameManager;
private Circle[][] marker = new Circle[8][8];

/*------------------------------------------------
 * PUBLIC METHODS
 *----------------------------------------------*/

/**
 * Creates the GameBoard, constructed with a GridPane of buttons
 * 
 * @param gameManager 
 */
public GameBoard(GameManager gameManager){
    this.gameManager = gameManager;
    gameManager.onDiskPlaced((player, diskPlacement) -> {
        Platform.runLater(() -> updateGameBoard());
    });
    DropShadow shade = new DropShadow();
    shade.setColor(Color.GREEN);

    board = new GridPane();
    board.setStyle("-fx-background-image: url(images/green.png);"
            + "-fx-background-repeat: stretch;"
            + "-fx-background-size: 480 480;"
            + "-fx-background-position: center center;");
    board.setGridLinesVisible(true);
    board.setEffect(shade);
    board.setAlignment(Pos.CENTER);

    int row, column;
    for(row = 0; row < 8; row++){
        for(column = 0; column < 8; column++){
            Button tile = new Button();
            tile.setMinSize(60,60);
            tile.setMaxSize(60,60);
            tile.setStyle("-fx-border-color: white; "
                    + "-fx-background-color: transparent");
            marker[column][row] = new Circle(20, Color.TRANSPARENT);   
            marker[column][row].setMouseTransparent(true);
            GridPane.setRowIndex(tile, row);
            GridPane.setColumnIndex(tile, column);
            GridPane.setMargin(marker[column][row],new Insets(10));
            board.add(marker[column][row], row, column);
            tile.setFocusTraversable(true);
            tile.setOnAction((ActionEvent e) -> {
                setPlacing(GridPane.getColumnIndex(tile),
                        GridPane.getRowIndex(tile),
                        gameManager.getCurrentPlayer());
            });
            board.getChildren().add(tile);
        }
    }

    Platform.runLater(() -> updateGameBoard());
}

/**
 * 
 * @return The GridPane representing the board
 */
public GridPane getGameBoard(){
    return (board);
}

/*------------------------------------------------
 * PRIVATE METHODS
 *----------------------------------------------*/

private void setPlacing(int x, int y, Player player){
    try{
        ((GUIHumanPlayer)player).setNextMove(x,y);
    }
    catch (Exception e) {}  //Catches attempts to make move when it's not players turn
}

private void updateGameBoard(){
    GameGrid updateGame;
    updateGame = gameManager.getGameGrid();
    int row, column;
    for(row = 0; row < 8; row++){
        for(column = 0; column < 8; column++){
            if(updateGame.getCellData(row, column) == 1){
                marker[column][row].setFill(Color.BLACK);
            }
            if(updateGame.getCellData(row, column) == 2){
                marker[column][row].setFill(Color.WHITE);
            }
        }
    }
}
}
