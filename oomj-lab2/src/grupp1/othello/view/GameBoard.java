package grupp1.othello.view;
/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

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
import javafx.event.EventTarget;
import javafx.scene.Cursor;

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
                tile.setMinSize(60,60);
                tile.setStyle("-fx-border-color: white");
                GridPane.setRowIndex(tile, i);
                GridPane.setColumnIndex(tile, j);
                //System.out.println( "Node: " + tile + " at " + GridPane.getRowIndex(tile) + "/" + GridPane.getColumnIndex(tile)); 
                board.getChildren().add(tile);
            }
        }
        setPlacing(3,3, Color.WHITE);
        setPlacing(3,4, Color.BLACK);
        setPlacing(4,3, Color.BLACK);
        setPlacing(4,4, Color.WHITE);
        board.setFocusTraversable(true);
        board.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent e) {
                for(Node node : board.getChildren()){
                    if(node instanceof StackPane){
                        if(node.getBoundsInParent().contains(e.getSceneX(),  e.getSceneY())){
                            
                            System.out.println( "Player: " /*+ getPlayer();*/ + " at x" + GridPane.getRowIndex( node) + "/ y" + GridPane.getColumnIndex( node)); 
                           
                            //possibly, it focuses on the lower side of the mouse...
                            
                            setPlacing(GridPane.getRowIndex( node), GridPane.getColumnIndex( node), Color.BLACK);
                            break;
                            //@todo Check for validity against the GameGrid, and add if valid
                            //probably want to replace the whole setPlacing for a replot-GameGrid-function
                        }
                    }
                }
               
            }
        });
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
