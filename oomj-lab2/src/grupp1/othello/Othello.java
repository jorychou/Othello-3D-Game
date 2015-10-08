package grupp1.othello;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*------------------------------------------------
 * CLASS
 *----------------------------------------------*/

/**
 * The program's main class. This class contains the entry-point.
 *
 * @author Philip Arvidsson (S133686)
 */
public final class Othello extends Application {

/*------------------------------------------------
 * PUBLIC METHODS
 *----------------------------------------------*/

/**
 * Program entry point.
 * @param args Command line arguments.
 */
public static void main(String[] args) {
    printIntroMessage();

    launch(args);
}

/**
 * This method initializes the game and starts it.
 * @param primaryStage Stage to use for displaying the game in a visual fashion.
 */
@Override
public void start(Stage primaryStage) {
    Button button = new Button("heylo everyone!");
    Scene  scene  = new Scene(button);

    primaryStage.setTitle("Othello (grupp1)");
    primaryStage.setScene(scene);
    primaryStage.sizeToScene();
    primaryStage.show();
}

/*------------------------------------------------
 * PRIVATE METHODS
 *----------------------------------------------*/

/**
 * Retrieves the program authors.
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
