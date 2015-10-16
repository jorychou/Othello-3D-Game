package grupp1.othello.view;

import grupp1.othello.controller.GameManager;
import grupp1.othello.controller.Player;
import grupp1.othello.model.DiskPlacement;

public class StdoutGameView {

private final GameManager gameManager;

public StdoutGameView(GameManager gameManager) {
    this.gameManager = gameManager;

    gameManager.onDiskPlaced((player, diskPlacement) -> printGrid())
               .onInvalidMove((player, diskPlacement) -> notifyInvalidMove(player, diskPlacement));
}

private void notifyInvalidMove(Player player, DiskPlacement diskPlacement) {
    System.out.println("invalid move: " + player.getName()
                     + " tried to place disk @ (" + diskPlacement.getX()
                     + ", " + diskPlacement.getY() + ")");
}

private void printGrid() {
    for (int y = 0; y < gameManager.getGameGrid().getSize(); y++) {
        for (int x = 0; x < gameManager.getGameGrid().getSize(); x++) {
            int data = gameManager.getGameGrid().getCellData(x, y);

            System.out.print("|");

            switch (data) {

            case 0:
                System.out.print("_");
                break;

            case GameManager.PLAYER_ONE:
                System.out.print("B");
                break;

            case GameManager.PLAYER_TWO:
                System.out.print("W");
                break;

            default:
                System.out.print("?");
                break;

            }
        }

        System.out.println("|");
    }
}

}
