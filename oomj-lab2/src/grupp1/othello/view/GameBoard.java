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
        
        board.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent e) {
                for(Node node : board.getChildren()){
                    if(node instanceof StackPane){
                        if(node.getBoundsInParent().contains(e.getSceneX(),  e.getSceneY())){
                            
                            System.out.println( "Node: " + node + " at x" + GridPane.getRowIndex( node) + "/ y" + GridPane.getColumnIndex( node)); 
                            //Cannot for the life of me figure out why , but x0 is the row ABOVE first row, and the last row is out of bounds
                            
                            //the setPlacing works this way, except the last row is out of bounds, and exceptions are thrown to the left and right
                            setPlacing(GridPane.getRowIndex( node)-1, GridPane.getColumnIndex( node), Color.BLACK);
                            
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
    
    Circle marker = new Circle(10, color);
    board.add(marker, y, x);
    GridPane.setMargin(marker,new Insets(5));
}
}
