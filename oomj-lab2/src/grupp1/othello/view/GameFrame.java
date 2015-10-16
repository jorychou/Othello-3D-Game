package grupp1.othello.view;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
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
        
        /*Alert aboutMenu = new Alert(Alert.AlertType.INFORMATION);
        aboutGame.setTitle(null);
        aboutGame.setHeaderText(null);
        aboutGame.setContentText(event); */
        
    BorderPane borderPane = new BorderPane();
    borderPane.setStyle("-fx-background: #202020;");
    
    MenuBar menuBar = new MenuBar();
    Menu gameMenu = new Menu("Game");
        MenuItem newMenuItem = new MenuItem("New Game");
        MenuItem openMenuItem = new MenuItem("Open...");
        MenuItem openRecentMenuItem = new MenuItem("Open Recent");
        //MenuItem MenuItem = new MenuItem("");
        MenuItem closeMenuItem = new MenuItem("Resign");
        MenuItem saveMenuItem = new MenuItem("Save");
        MenuItem saveAsMenuItem = new MenuItem("Save As");
        //MenuItem exitMenuItem = new MenuItem("");
        MenuItem exitMenuItem = new MenuItem("Quit");
    Menu editMenu = new Menu("Edit");
        MenuItem undoMenuItem = new MenuItem("Undo last Move");
    Menu helpMenu = new Menu("Help");
        MenuItem aboutMenuItem = new MenuItem("About Othello");
        
    /*newMenuItem.setOnAction(actionEvent -> aboutMenu.show(e));
    openMenuItem.setOnAction(actionEvent -> aboutMenu.show(e));
    openRecentMenuItem.setOnAction(actionEvent -> aboutMenu.show(e));
    closeMenuItem.setOnAction(actionEvent -> aboutMenu.show(e));
    saveMenuItem.setOnAction(actionEvent -> aboutMenu.show(e));
    saveAsMenuItem.setOnAction(actionEvent -> aboutMenu.show(e));*/
    exitMenuItem.setOnAction(actionEvent -> Platform.exit());
    aboutMenuItem.setOnAction(actionEvent -> aboutGame.showAndWait());
    
    gameMenu.getItems().addAll(newMenuItem, openMenuItem, openRecentMenuItem, closeMenuItem, saveMenuItem, saveAsMenuItem, exitMenuItem);
    editMenu.getItems().add(undoMenuItem);
    helpMenu.getItems().add(aboutMenuItem);
    
    menuBar.getMenus().addAll(gameMenu, editMenu, helpMenu);
    
    borderPane.setTop(menuBar);

    //borderPane.setCenter(new GameBoard());

    Label statusBar = new Label("statusBar, possibly SpyBar");
    borderPane.setBottom(statusBar);
    // Create a scene and place it in the stage
    Scene scene = new Scene(borderPane, 450, 450);
    this.primaryStage.getIcons().add(new Image("images/reversi.png"));
    this.primaryStage.setScene(scene);
    this.primaryStage.show();

  
  }
/*------------------------------------------------
 * PRIVATE METHODS
 *----------------------------------------------*/

}
