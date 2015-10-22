package grupp1.othello.controller;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import grupp1.othello.Othello;
import grupp1.othello.model.GameGrid;
import grupp1.othello.model.PlayerFactory;
import grupp1.othello.model.GameConfig;
import grupp1.othello.view.GameFrame;
import grupp1.othello.view.StdoutGameView;

import javafx.stage.Stage;

/*------------------------------------------------
 * CLASS
 *----------------------------------------------*/

/**
 * Represents a game of Othello!
 *
 * @author Philip Arvidsson (S133686)
 */
public class OthelloGame {

/*------------------------------------------------
 * PUBLIC METHODS
 *----------------------------------------------*/

/**
 * Runs the game. This is where most of the magic happens.
 */
public void run() {
    //--------------------------------------------
    // 1. CONFIGURE AND INITIALIZE
    //--------------------------------------------

    GameConfig config = askUserToConfigureGame();

    if (config.getPlayer1Name().isEmpty())
        return;

    PlayerFactory factory     = new PlayerFactory();
    GameManager   gameManager = new GameManager(
        new GameGrid(),
        factory.getPlayer(config.getPlayer1Name(), config.getPlayer1Type()),
        factory.getPlayer(config.getPlayer2Name(), config.getPlayer2Type())
    );

    // @To-do: Figure out if GC is a problem here since we don't keep a ref.
    if (Othello.enableConsoleView)
        new StdoutGameView(gameManager);

    gameManager.initialize();

    //--------------------------------------------
    // 2. FORK GAME THREAD
    //--------------------------------------------

    fork(() -> gameManager.play());

    //--------------------------------------------
    // 3. GUI THREAD
    //--------------------------------------------

    if (config.getEnable3D())
        new FX3DGameWindow(gameManager).showAndWait();
    else
        new GameFrame(new Stage(), gameManager);
}

/*------------------------------------------------
 * PRIVATE METHODS
 *----------------------------------------------*/

/**
 * Asks the user to configure the game.
 *
 * @return The game configuration.
 */
private GameConfig askUserToConfigureGame() {
    ConfigDialog configDialog = new ConfigDialog();

    configDialog.showAndWait();

    return (configDialog.getModel());
}

/**
 * Simple method to make threading neater.
 *
 * @param runnable The runnable to fork.
 *
 * @return The spawned thread.
 */
private Thread fork(Runnable runnable) {
    Thread thread = new Thread(runnable);
    thread.setPriority(Thread.MAX_PRIORITY);
    thread.start();

    return (thread);
}

}
