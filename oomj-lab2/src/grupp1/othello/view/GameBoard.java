package grupp1.othello.view;

import grupp1.othello.controller.Player;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.effect.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

//import blah;

/*------------------------------------------------
 * CLASS
 *----------------------------------------------*/

/**
 * @author
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
                StackPane tile = new StackPane();
                tile.setMinSize(30,30);
                tile.setStyle("-fx-border-color: white");
                board.add(tile, i ,j);   
            }
        }
        
     board.setOnMouseClicked(e -> setPlacing(3,4, Color.WHITE));

}

public GridPane getGameBoard(){
    return board;
}

public void setPlacing(int x, int y, Color color){
    Circle marker = new Circle(10, color);
    board.add(marker, x,y);
    GridPane.setMargin(marker,new Insets(5));
}
/*------------------------------------------------
 * PRIVATE METHODS
 *----------------------------------------------*/

}