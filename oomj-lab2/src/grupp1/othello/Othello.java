package grupp1.othello;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import grupp1.othello.controller.OthelloGame;

import javafx.application.Application;
import javafx.stage.Stage;

/*------------------------------------------------
 * CLASS
 *----------------------------------------------*/

/**
 * The program's main class. This class contains the entry-point.
 *
 * @author Philip Arvidsson (S133686)
 */
public class Othello extends Application {

/*------------------------------------------------
 * CONSTANTS
 *----------------------------------------------*/

/**
 * True to enable printing of game state to stdout.
 */
public static final boolean enableConsoleView = true;

/*------------------------------------------------
 * PUBLIC METHODS
 *----------------------------------------------*/

/**
 * Program entry point.
 *
 * @param args Command line arguments.
 */
public static void main(String[] args) {
    printIntroMessage();

    launch(args);
}

/**
 * This method initializes the game and starts it.
 *
 * @param primaryStage Stage to use for displaying the game in a visual fashion.
 */
@Override
public void start(Stage primaryStage) {
    // Don't need this crap stage! lulz
    primaryStage.close();
    primaryStage = null; // This might allow the GC to collect it earlier?

    new OthelloGame().run();
}

/*------------------------------------------------
 * PRIVATE METHODS
 *----------------------------------------------*/

/**
 * Retrieves the program authors.
 *
 * @return An array of strings with the program authors' names.
 */
private static String[] getAuthors() {
    return new String[] { "Philip Arvidsson (S133686)",
                          "Martin Bergqvist (S141564)" };
}

/**
 * Prints the introductory message to stdio.
 */
private static void printIntroMessage() {
    System.out.println("ASYAR14h / OOMU / Lab. 2");

    System.out.println("By:");
    for (String author : getAuthors())
        System.out.println("    " + author);

    System.out.println();
}

}
