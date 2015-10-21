package grupp1.othello.view;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import grupp1.othello.controller.GameManager;
import grupp1.othello.controller.OthelloGame;
import grupp1.othello.model.GameResult;

import java.awt.Color;
import java.util.HashSet;
import java.util.Set;
import javafx.application.Platform;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/*------------------------------------------------
 * CLASS
 *----------------------------------------------*/

/**
 *
 * @author Martin Bergqvist (S141564)
 */

public class GameFrame{
     private Stage primaryStage;
     private GameBoard board;
     private GameManager gameManager;

/*------------------------------------------------
 * PUBLIC METHODS
 *----------------------------------------------*/

  public GameFrame(Stage primaryStage, GameManager gameManager) {
      
        this.primaryStage = primaryStage;
        this.gameManager = gameManager;

    AboutGameDialog aboutGame = new AboutGameDialog();

    BorderPane borderPane = new BorderPane();
    borderPane.setStyle("-fx-background: #202020;");

    MenuBar menuBar = new MenuBar();
    Menu gameMenu = new Menu("Game");
        MenuItem newMenuItem = new MenuItem("New Game");
        MenuItem closeMenuItem = new MenuItem("Resign");
        MenuItem exitMenuItem = new MenuItem("Quit");
    Menu helpMenu = new Menu("Help");
        MenuItem aboutMenuItem = new MenuItem("About Othello");

    exitMenuItem.setOnAction(actionEvent -> System.exit(0));
    aboutMenuItem.setOnAction(actionEvent -> aboutGame.aboutGameDialog());

    gameMenu.getItems().addAll(newMenuItem, new SeparatorMenuItem(),
            closeMenuItem, new SeparatorMenuItem(), exitMenuItem);
    helpMenu.getItems().add(aboutMenuItem);

    menuBar.getMenus().addAll(gameMenu, helpMenu);

    borderPane.setTop(menuBar);

    board = new GameBoard(gameManager);
    borderPane.setCenter(board.getGameBoard());

        HBox buttonPane = new HBox();
            ToolBar buttons = new ToolBar();
                Button newGameButton = new Button();
                    newGameButton.setText("New Game");
                    newGameButton.setOnMouseClicked(e -> {
                        primaryStage.close();
                        new OthelloGame().run();
                            });

                Button endGameButton = new Button();
                    endGameButton.setText("Exit");
                    endGameButton.setOnMouseClicked(e -> System.exit(0));

            buttons.getItems().addAll(newGameButton,new Separator(), endGameButton);
            buttons.setOrientation(Orientation.VERTICAL);
            buttons.setStyle("-fx-background-color: #202020;");
            buttons.setMaxHeight(100);
        buttonPane.getChildren().add(buttons);
        buttonPane.setAlignment(Pos.CENTER);
    borderPane.setRight(buttonPane);

    Label statusBar = new Label("   statusBar, possibly SpyBar");
    statusBar.setStyle("-fx-border-color: #303030;");
    statusBar.setMinWidth(600);
    borderPane.setBottom(statusBar);

    gameManager.onDiskPlaced((player, diskPlacement) -> {
        Platform.runLater(() -> statusBar.setText("Current Score: "
                + "Player 1 (Black) " 
                +gameManager.getPlayer1().getName() +" : " 
                +gameManager.getCurrentScore(1) +"      ||        "
                +"Player 2 (White) "
                +gameManager.getPlayer2().getName() +" : " 
                +gameManager.getCurrentScore(2)));         
    });
    
    gameManager.onGameOver((result) -> Platform.runLater(() -> displayEnd(result)));
    
    // Create the scene and place it in the stage
    Scene scene = new Scene(borderPane, 600, 600);
    this.primaryStage.getIcons().add(new Image("images/reversi.png"));
    this.primaryStage.setResizable(false);
    this.primaryStage.setTitle("Othello: Not for N00bs Edition");
    this.primaryStage.setScene(scene);
    this.primaryStage.showAndWait();


  }
/*------------------------------------------------
 * PRIVATE METHODS
 *----------------------------------------------*/
private void displayEnd(GameResult result){
    if(result.getWinner() == null){
        new DrawnDialog();
        
    }
    else{
        new WinnerDialog(result);
        
    }
}
}
