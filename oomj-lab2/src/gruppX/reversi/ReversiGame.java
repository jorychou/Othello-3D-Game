package gruppX.reversi;

import javafx.application.Application;
import javafx.stage.Stage;

public final class ReversiGame extends Application {

@Override
public void start(Stage primaryStage) {
    System.out.println("in start");

    primaryStage.setTitle("hellooooo");
    primaryStage.show();
}

public static void main(String[] args) {
    System.out.println("Nothing to see here!");

    launch(args);
}

}
