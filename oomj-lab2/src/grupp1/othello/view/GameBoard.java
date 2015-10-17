package grupp1.othello.view;

import javafx.scene.effect.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

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
        board.setStyle("-fx-background-image: url(images/backgr.png);-fx-background-repeat: stretch;");       
        board.setGridLinesVisible(true);
        board.setEffect(shade);

        int i, j;
        for(i = 0; i < 8; i++){
            for(j = 0; j < 8; j++){
                StackPane tile = new StackPane();
                tile.setMinSize(30,30);
                board.add(tile, i ,j);
            }
        }
}

public GridPane getGameBoard(){
    return board;
}
/*------------------------------------------------
 * PRIVATE METHODS
 *----------------------------------------------*/

}
