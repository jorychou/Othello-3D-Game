package grupp1.othello.view;

import grupp1.othello.controller.Player;
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

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

//import blah;

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
                StackPane tile = new StackPane();
                tile.setMinSize(30,30);
                tile.setStyle("-fx-border-color: white");
                board.add(tile, i ,j);   
            }
        }
        setPlacing(3,3, Color.WHITE);
        setPlacing(3,4, Color.BLACK);
        setPlacing(4,3, Color.BLACK);
        setPlacing(4,4, Color.WHITE);
        board.setOnMouseClicked(e -> setPlacing(4,5, Color.WHITE));
        
        /*
        board.setOnMouseClicked((MouseEvent e) -> {
            for(Node node: board.getChildren()){
                if(node instanceof StackPane) {
                    setPlacing(GridPane.getRowIndex(node), GridPane.getColumnIndex(node), Color.WHITE);
                }
            }
        });
        */
}

public GridPane getGameBoard(){
    return board;
}

private void setPlacing(int x, int y, Color color){
    Circle marker = new Circle(10, color);
    board.add(marker, x,y);
    GridPane.setMargin(marker,new Insets(5));
}
/*------------------------------------------------
 * PRIVATE METHODS
 *----------------------------------------------*/

}