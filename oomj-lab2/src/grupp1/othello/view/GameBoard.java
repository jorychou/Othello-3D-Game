package grupp1.othello.view;
/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import grupp1.othello.controller.Player;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.effect.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.scene.Cursor;
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

/*------------------------------------------------
 * PUBLIC METHODS
 *----------------------------------------------*/
public GameBoard(){
    
        DropShadow shade = new DropShadow();
        shade.setColor(Color.GREEN);
    
        board = new GridPane();
        board.setStyle("-fx-background-image: url(images/backgr.png);"
                + "-fx-background-repeat: stretch;"
                + "-fx-background-position: center center;");       
        board.setGridLinesVisible(true);
        board.setEffect(shade);
        board.setAlignment(Pos.CENTER);

        int i, j;
        for(i = 0; i < 8; i++){
            for(j = 0; j < 8; j++){
                Button tile = new Button();
                tile.setMinSize(60,60);
                tile.setStyle("-fx-border-color: white; -fx-background-color: transparent");
                GridPane.setRowIndex(tile, i);
                GridPane.setColumnIndex(tile, j);
                tile.setOnAction(new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent e){
                        setPlacing(GridPane.getRowIndex(tile), GridPane.getColumnIndex(tile), Color.BLACK);
                    }});

                board.getChildren().add(tile);
            }
        }
        setPlacing(3,3, Color.WHITE);
        setPlacing(3,4, Color.BLACK);
        setPlacing(4,3, Color.BLACK);
        setPlacing(4,4, Color.WHITE);
        board.setFocusTraversable(true);
       
}

public GridPane getGameBoard(){
    return board;
}
/*------------------------------------------------
 * PRIVATE METHODS
 *----------------------------------------------*/

private void setPlacing(int x, int y, Color color){
    
    Circle marker = new Circle(20, color);
    board.add(marker, y, x);
    GridPane.setMargin(marker,new Insets(10));
}
}
