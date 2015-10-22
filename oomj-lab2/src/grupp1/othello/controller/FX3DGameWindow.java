package grupp1.othello.controller;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import grupp1.othello.controller.GameWindowBase;
import grupp1.othello.controller.GUIHumanPlayer;
import grupp1.othello.controller.Player;
import grupp1.othello.model.GameResult;

import java.util.Stack;

import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Material;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Box;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

/*------------------------------------------------
 * CLASS
 *----------------------------------------------*/

/**
 * @author Philip Arvidsson (S133686)
 */
public class FX3DGameWindow extends GameWindowBase<GameResult> {

/*------------------------------------------------
 * FIELDS
 *----------------------------------------------*/

/**
 * The current camera index. Used to switch between camera views. See the
 * switchToNextCamera() method for more information.
 */
private int currentCamera = 1;

/**
 * Basically a cache for disks to make animations easier to perform in a
 * coherent manner.
 */
private Group[][] disks;

/**
 * The game manager.
 */
private final GameManager gameManager;

/**
 * The indicator disks showing where disks may be placed.
 */
private Group indicator;

/**
 * The game board group. Defined in the view. Supposed to contain the game
 * board, cell separators and disks.
 */
@FXML
private Group gameBoardGroup;

/**
 * The group that contains all game disks.
 */
@FXML
private Group gameDisksGroup;

/**
 * The group that contains all game disks.
 */
@FXML
private Group validMovesGroup;

/**
 * The group that contains game buttons.
 */
@FXML
private Group buttonGroup;

/**
 * The group that displays game score info.
 */
@FXML
private Group scoreGroup;

/**
 * The group that displays winner info.
 */
@FXML
private Group winnerGroup;

/**
 * Score text for the black player (player 1).
 */
@FXML
private Text blackPlayerScore;

/**
 * Score text for the white player (player 2).
 */
@FXML
private Text whitePlayerScore;

/**
 * The text displayed between the player scores (name vs. name).
 */
@FXML
private Text versusText;

/**
 * The text displayed when a player wins.
 */
@FXML
private Text winnerText;

/**
 * The initial board rotation effect.
 */
@FXML
private RotateTransition boardRotateTransition;

/**
 * The initial board translation effect.
 */
@FXML
private TranslateTransition boardTranslateTransition;

/**
 * Used as a button for switching camera views.
 */
@FXML
private ImageView switchCamera;

/**
 * The exit button.
 */
@FXML
private Button exitButton;

/**
 * The new game button.
 */
@FXML
private Button newGameButton;

/*------------------------------------------------
 * PUBLIC METHODS
 *----------------------------------------------*/

/**
 * Constructor.
 *
 * @param gameManager The game manager.
 */
public FX3DGameWindow(GameManager gameManager) {
    super(new GameResult());

    this.gameManager = gameManager;

    int n = gameManager.getGameGrid().getSize();
    disks = new Group[n][n];
}

/*------------------------------------------------
 * PROTECTED METHODS
 *----------------------------------------------*/

/**
 * Initializes the stage.
 */
@Override
protected void initialize() {
    setupStage      ();
    setupModel      ();
    setupHandlers   ();
    setupBindings   ();
    setupTransitions();

    versusText.setText(gameManager.getPlayer1().getName() + " vs. "
                     + gameManager.getPlayer2().getName());

    createIndicator();
    createGridLines();
    updateView     ();
}

/*------------------------------------------------
 * PRIVATE METHODS
 *----------------------------------------------*/

/**
 * Creates a new game disk.
 *
 * @param blackSideUp True to create the disk with the black side up.
 *
 * @return The game disk that was created.
 */
private Group createDisk(boolean blackSideUp, boolean transparent) {
    Group group = new Group();

    group.setRotationAxis(Rotate.Y_AXIS);

    if (blackSideUp)
        group.setRotate(180.0f);

    PhongMaterial blackMaterial = new PhongMaterial(Color.BLACK);
    blackMaterial.setSpecularColor(Color.WHITE);

    PhongMaterial whiteMaterial = new PhongMaterial(Color.WHITE);
    whiteMaterial.setSpecularColor(Color.WHITE);

    if (transparent) {
        blackMaterial.setDiffuseColor(new Color(0.0f, 0.0f, 0.0f, 0.2f));
        blackMaterial.setSpecularColor(Color.BLACK);

        whiteMaterial.setDiffuseColor(new Color(0.2f, 0.2f, 0.2f, 0.0f));
        whiteMaterial.setSpecularColor(Color.BLACK);
    }

    Cylinder blackPart = new Cylinder();
    blackPart.setRadius      (24.0f        );
    blackPart.setHeight      (4.0f         );
    blackPart.setTranslateZ  (-12.0f       );
    blackPart.setRotationAxis(Rotate.X_AXIS);
    blackPart.setRotate      (90.0f        );
    blackPart.setMaterial    (blackMaterial);

    Cylinder whitePart = new Cylinder();
    whitePart.setRadius      (24.0f        );
    whitePart.setHeight      (4.0f         );
    whitePart.setTranslateZ  (-16.0f       );
    whitePart.setRotationAxis(Rotate.X_AXIS);
    whitePart.setRotate      (90.0f        );
    whitePart.setMaterial    (whiteMaterial);

    // Easter egg! lol!
    if (gameManager.getPlayer1().getName().equals("Patrick")) {
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseMap(new Image("/images/paga.jpg"));
        blackPart.setMaterial(material);
    }

    group.getChildren().add(blackPart);
    group.getChildren().add(whitePart);

    return (group);
}

/**
 * Creates the cell separator lines and adds them to the game board.
 */
private void createGridLines() {
    int size = gameManager.getGameGrid().getSize();
    int halfSize = size / 2;

    for (int i = 0; i <= size; i++) {
        float x1 = -250.0f;
        float y1 = (i - halfSize) * 62.5f - 0.5f;
        float x2 = x1 + 500.0f;
        float y2 = (i - halfSize) * 62.5f + 0.5f;

        Box box1 = new Box();

        box1.setTranslateX((x1 + x2) / 2.0f);
        box1.setTranslateY((y1 + y2) / 2.0f);
        box1.setTranslateZ(-10.05f         );
        box1.setWidth     (x2 - x1         );
        box1.setHeight    (y2 - y1         );
        box1.setDepth     (0.0001f         );

        Box box2 = new Box();

        box2.setTranslateX((y1 + y2) / 2.0f);
        box2.setTranslateY((x1 + x2) / 2.0f);
        box2.setTranslateZ(-10.05f         );
        box2.setWidth     (y2 - y1         );
        box2.setHeight    (x2 - x1         );
        box2.setDepth     (0.0001f         );

        Material mat = new PhongMaterial(new Color(0.7f, 0.7f, 0.7f, 0.0f));

        box1.setMaterial(mat);
        box2.setMaterial(mat);

        gameBoardGroup.getChildren().add(box1);
        gameBoardGroup.getChildren().add(box2);
    }
}

/**
 * Creates the indicator square.
 */
private void createIndicator() {
    indicator = new Group();

    Material mat = new PhongMaterial(Color.BLACK);

    // Some metrics have + 4.0f because we want the corners to touch each other.

    Box box1 = new Box();
    box1.setTranslateY(-31.25f   );
    box1.setTranslateZ(-11.0f    );
    box1.setWidth     (61.5f+4.0f);
    box1.setHeight    (4.0f      );
    box1.setDepth     (0.0001f   );
    box1.setMaterial  (mat       );

    Box box2 = new Box();
    box2.setTranslateX(-31.25f   );
    box2.setTranslateZ(-11.0f    );
    box2.setWidth     (4.0f      );
    box2.setHeight    (61.5f+4.0f);
    box2.setDepth     (0.0001f   );
    box2.setMaterial  (mat       );

    Box box3 = new Box();
    box3.setTranslateY(31.25f    );
    box3.setTranslateZ(-11.0f    );
    box3.setWidth     (61.5f+4.0f);
    box3.setHeight    (4.0f      );
    box3.setDepth     (0.0001f   );
    box3.setMaterial  (mat       );

    Box box4 = new Box();
    box4.setTranslateX(31.25f    );
    box4.setTranslateZ(-11.0f    );
    box4.setWidth     (4.0f      );
    box4.setHeight    (61.5f+4.0f);
    box4.setDepth     (0.0001f   );
    box4.setMaterial  (mat       );

    indicator.getChildren().add(box1);
    indicator.getChildren().add(box2);
    indicator.getChildren().add(box3);
    indicator.getChildren().add(box4);

    indicator.setVisible(false);

    gameBoardGroup.getChildren().add(indicator);
}

/**
 * Flips the specified disk with an animation.
 *
 * @param disk    The disk to flip.
 * @param toBlack True to flip from white to black.
 */
private void flipDisk(Group disk, boolean toBlack) {
    // Rotate (flip) the disk.
    RotateTransition rotation =
        new RotateTransition(Duration.millis(400), disk);
    rotation.setFromAngle(toBlack ? 540.0f : 0.0f  );
    rotation.setToAngle  (toBlack ? 0.0f   : 540.0f);

    // Jump the disk while flipping it.
    TranslateTransition translation =
        new TranslateTransition(Duration.millis(200), disk);
    translation.setAutoReverse(true  );
    translation.setByZ        (-70.0f);
    translation.setCycleCount (2     );

    rotation.play();
    translation.play();
}

/**
 * Flips the next disk in the chain.
 *
 * @param disks The chain (stack) of disks to flip, one after another.
 */
private void flipNext(Stack<Group> disks) {
    if (disks.isEmpty())
        return;

    Group disk = disks.pop();
    if (disk.getRotate() < 90.0f) flipDisk(disk, false);
    else                          flipDisk(disk, true );

    PauseTransition delay = new PauseTransition(Duration.millis(100));
    delay.setOnFinished((e) -> flipNext(disks));
    delay.play();
}

/**
 * Places a disk (triggered by a mouse click).
 *
 * @param e Mouse click data.
 */
private void placeDisk(MouseEvent e) {
    Player p = gameManager.getCurrentPlayer();
    if (!(p instanceof GUIHumanPlayer))
        return;

    GUIHumanPlayer player = (GUIHumanPlayer)p;

    int x = (int)((e.getX() + 250.0f) / 62.5f);
    int y = (int)((e.getY() + 250.0f) / 62.5f);

    player.setNextMove(x, y);
}

/**
 * Resets the game.
 */
private void resetGame() {
    // Only allow reset when a human is playing.
    if (!(gameManager.getCurrentPlayer() instanceof GUIHumanPlayer))
        return;

    // Reset game.
    gameManager.initialize();

    updateView();

    int size     = gameManager.getGameGrid().getSize();
    int halfSize = size / 2;

    for (int x = 0; x < size; x++) {
        for (int y = 0; y < size; y++) {
            // Leave center disks alone to preserve Othello starting state.
            if (x >= (halfSize-1) && x <= halfSize
             && y >= (halfSize-1) && y <= halfSize)
            {
                continue;
            }

            Group disk = disks[x][y];
            if (disk == null)
                continue;

            // Remove the disk from cache since we're going to dump it from the
            // board.
            disks[x][y] = null;

            TranslateTransition transition =
                new TranslateTransition(Duration.millis(800), disk);

            transition.setByX(400.0f + (disk.getTranslateY() + 250.0f) * 2.5f);

            // Disks on the left go to the left.
            if (disk.getTranslateX() < 0.0f)
                transition.setByX(-transition.getByX());

            transition.setByX(transition.getByX() + disk.getTranslateX() * 3.0f);
            transition.setByY(disk.getTranslateY() * 2.0f);

            transition.setOnFinished((e) ->
                // Remove disk when transition finishes.
                gameDisksGroup.getChildren().removeAll(
                    ((TranslateTransition)e.getSource()).getNode()
                )
            );

            transition.play();
        }
    }

    // -
}

/**
 * Sets up all bindings.
 */
private void setupBindings() {}

/**
 * Sets up the control event handlers.
 */
private void setupHandlers() {
    gameManager.onDiskPlaced((player, diskPlacement) -> {
        Platform.runLater(() -> updateView());
    });

    gameManager.onGameOver((gameResult) -> {
        // Not quite happy with this, but it's ok.
        getModel().setPlayers(gameResult.getPlayers());
        getModel().setWinner (gameResult.getWinner ());

        Platform.runLater(() -> showGameResult(gameResult));
    });

    // Show some feedback for invalid moves.
    gameManager.onInvalidMove((player, diskPlacement) -> {
        Platform.runLater(() -> {
            TranslateTransition translation =
                new TranslateTransition(Duration.millis(50), gameBoardGroup);

            translation.setAutoReverse(true);
            translation.setCycleCount (3   );
            translation.setByX        (5.0f);
            translation.play();

            translation.setOnFinished((e) ->
                gameBoardGroup.setTranslateX(350.0f)
            );
        });
    });

    gameBoardGroup.setOnMouseClicked((e) -> placeDisk(e)    );
    gameBoardGroup.setOnMouseMoved  ((e) -> showIndicator(e));
    gameBoardGroup.setOnMouseExited ((e) -> hideIndicator() );

    switchCamera.setOnMouseClicked((e) -> switchToNextCamera());

    exitButton.setOnAction((e) -> {
        gameManager.quit();

        Player p = gameManager.getCurrentPlayer();
        if (p instanceof GUIHumanPlayer) {
            GUIHumanPlayer player = (GUIHumanPlayer)p;
            player.interrupt();
        }

        close();
    });

    // Probably not entirely thread-safe, but whatever...
    newGameButton.setOnAction((e) -> resetGame());

    // Make sure same thing happens when the window is closed, as when the exit
    // button is pressed.
    setOnCloseRequest((e) -> exitButton.getOnAction().handle(null));
}

/**
 * Initializes the model to some defaults.
 */
private void setupModel() {}

/**
 * Initializes the transitions and starts them.
 */
private void setupTransitions() {
    boardRotateTransition.play();
    boardTranslateTransition.play();
}

/**
 * Initializes the stage/window.
 */
private void setupStage() {
    setResizable(false);
    setTitle("asyar14h/oomu/lab.2 - grupp 1");

    getIcons().add(new Image("images/reversi.png"));
}

/**
 * Hides the placement indicator.
 */
private void hideIndicator() {
    indicator.setVisible(false);
}

/**
 * Shows the game result from a game session.
 *
 * @param gameResult The game result.
 */
private void showGameResult(GameResult gameResult) {
    if (gameResult.getWinner() != null) {
        winnerText.setText(gameResult.getWinner().getName() + " won!");

        buttonGroup.setVisible(false);
        versusText .setVisible(false);
        winnerGroup.setVisible(true );

        FadeTransition fade =
            new FadeTransition(Duration.millis(800), winnerGroup);

        fade.setFromValue(0.0f);
        fade.setToValue(1.0f);

        fade.play();

        if (currentCamera == 0)
            switchToNextCamera();
    }
    else {
        // Draw.
    }
}

/**
 * Shows the indicator if the mouse data represents a valid move.
 *
 * @param e Mouse move data.
 */
private void showIndicator(MouseEvent e) {
    Player p = gameManager.getCurrentPlayer();
    if (!(p instanceof GUIHumanPlayer)) {
        // Human isn't playing right now, so don't indicate anything.
        indicator.setVisible(false);
        return;
    }

    int size     = gameManager.getGameGrid().getSize();
    int halfSize = size / 2;

    int x = (int)((e.getX() + 250.0f) / 62.5f);
    int y = (int)((e.getY() + 250.0f) / 62.5f);

    if (x < 0       ) x = 0;
    if (x > (size-1)) x = (size-1);
    if (y < 0       ) y = 0;
    if (y > (size-1)) y = (size-1);

    int i = gameManager.getCurrentPlayerIndex();

    /*if (!gameManager.isValidMove(x, y, i)) {
        // Mouse data does not represent a valid move so hide the indicator.
        indicator.setVisible(false);
        return;
    }*/

    if (i == GameManager.PLAYER_ONE) indicator.setRotate(180.0f);
    else                             indicator.setRotate(0.0f  );

    indicator.setTranslateX((x - halfSize) * 62.5f + 31.25f);
    indicator.setTranslateY((y - halfSize) * 62.5f + 31.25f);
    indicator.setVisible(true);
}

/**
 * Switches to the next camera with a transitional effect.
 */
private void switchToNextCamera() {
    RotateTransition rotation =
        new RotateTransition(Duration.millis(1000), gameBoardGroup);

    TranslateTransition translation
        = new TranslateTransition(Duration.millis(1000), gameBoardGroup);

    currentCamera++;
    if (currentCamera > 1) currentCamera = 0;

    if (currentCamera == 0) {
        rotation.setAxis   (new Point3D(1.0f, 0.4f, 0.25f));
        rotation.setToAngle(0.0f                          );

        translation.setToY(330.0f);
        translation.setToZ(0.0f  );
    }
    else if (currentCamera == 1) {
        rotation.setAxis   (new Point3D(1.0f, 0.4f, 0.25f));
        rotation.setToAngle(-30.0f                        );

        translation.setToY(310.0f );
        translation.setToZ(-160.0f);
    }

    rotation.play();
    translation.play();
}

/**
 * Updates the view by adding and flipping disks, etc.
 */
private void updateView() {
    int size     = gameManager.getGameGrid().getSize();
    int halfSize = size / 2;

    validMovesGroup.getChildren().clear();

    Stack<Group> disksToFlip = new Stack<>();

    for (int x = 0; x < size; x++) {
        for (int y = 0; y < size; y++) {
            float diskX = (x - halfSize) * 62.5f + 31.25f;
            float diskY = (y - halfSize) * 62.5f + 31.25f;

            int data = gameManager.getGameGrid().getCellData(x, y);
            if (data == GameManager.EMPTY) {
                // Create "ghost" disk for valid moves.
                int i = gameManager.getCurrentPlayerIndex();
                if (gameManager.isValidMove(x, y, i)) {
                    Group g = createDisk(i == GameManager.PLAYER_ONE, true);

                    g.setTranslateX(diskX);
                    g.setTranslateY(diskY);
                    g.setTranslateZ(2.0f );
                    g.setScaleX    (0.5f );
                    g.setScaleY    (0.5f );

                    validMovesGroup.getChildren().add(g);
                }

                continue;
            }

            // Reuse disks.
            Group disk = disks[x][y];

            // No disk here, so create one and cache it.
            if (disk == null) {
                disk = createDisk(data == GameManager.PLAYER_ONE, false);
                disks[x][y] = disk;

                gameDisksGroup.getChildren().add(disk);
            }

            disk.setTranslateX(diskX);
            disk.setTranslateY(diskY);
            disk.setTranslateZ(0.0f );

            if (data == GameManager.PLAYER_ONE) {
                // Flip from black to white. Check the angle first to not flip
                // disks that don't need flipping.
                if (disk.getRotate() < 90.0f)
                    disksToFlip.push(disk);
            }
            else {
                // Flip from white to black.
                if (disk.getRotate() > 90.0f)
                    disksToFlip.push(disk);
            }
        }
    }

    // Start the flip chain! Wohooo!
    flipNext(disksToFlip);

    // Concatenating strings is syntactically cleaner than Integer.toString().
    blackPlayerScore.setText(
        "" + gameManager.getCurrentScore(GameManager.PLAYER_ONE)
    );

    whitePlayerScore.setText(
        "" + gameManager.getCurrentScore(GameManager.PLAYER_TWO)
    );
}

}
