package grupp1.othello.view;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

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
 * @author Martin
 */

public class GameFrame{
     private Stage primaryStage;
     private GameBoard board;

/*------------------------------------------------
 * PUBLIC METHODS
 *----------------------------------------------*/

  public GameFrame(Stage primaryStage) {

        this.primaryStage = primaryStage;

        Alert aboutGame = new Alert(Alert.AlertType.INFORMATION);
        aboutGame.setTitle("About Othello: Not for N00bs Edition");
        aboutGame.setHeaderText(null);
        aboutGame.setContentText("Philip Arvidsson (S133686) & "
                + "Martin Bergqvist (S141564) created this Epic game-replica for"
                + " recreational & laborative purposes. Enjoy!");

    BorderPane borderPane = new BorderPane();
    borderPane.setStyle("-fx-background: #202020;");

    MenuBar menuBar = new MenuBar();
    Menu gameMenu = new Menu("Game");
        MenuItem newMenuItem = new MenuItem("New Game");
        MenuItem closeMenuItem = new MenuItem("Resign");
        MenuItem exitMenuItem = new MenuItem("Quit");
    Menu helpMenu = new Menu("Help");
        MenuItem aboutMenuItem = new MenuItem("About Othello");

    exitMenuItem.setOnAction(actionEvent -> Platform.exit());
    aboutMenuItem.setOnAction(actionEvent -> aboutGame.showAndWait());

    gameMenu.getItems().addAll(newMenuItem, new SeparatorMenuItem(), 
            closeMenuItem, new SeparatorMenuItem(), exitMenuItem);
    helpMenu.getItems().add(aboutMenuItem);

    menuBar.getMenus().addAll(gameMenu, helpMenu);

    borderPane.setTop(menuBar);

    board = new GameBoard();
    borderPane.setCenter(board.getGameBoard());

        HBox buttonPane = new HBox();
            ToolBar buttons = new ToolBar();
                Button newGameButton = new Button();
                    newGameButton.setText("New Game");

                Button endGameButton = new Button();
                    endGameButton.setText("Exit");
                    endGameButton.setOnMouseClicked(e -> Platform.exit());

            buttons.getItems().addAll(newGameButton,new Separator(), endGameButton);
            buttons.setOrientation(Orientation.VERTICAL);
            buttons.setStyle("-fx-background-color: #202020;");
            buttons.setMaxHeight(100);
        buttonPane.getChildren().add(buttons);
        buttonPane.setAlignment(Pos.CENTER);
    borderPane.setLeft(buttonPane);
    
    Label statusBar = new Label("   statusBar, possibly SpyBar");
    statusBar.setStyle("-fx-border-color: #303030;");
    statusBar.setMinWidth(600);
    borderPane.setBottom(statusBar);

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

}
