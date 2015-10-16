package grupp1.othello.model;

/*------------------------------------------------
 * CLASS
 *----------------------------------------------*/

/**
 * Defines the player types.
 *
 * @author Philip Arvidsson (S133686)
 */
public class DiskPlacement {

/*------------------------------------------------
 * FIELDS
 *----------------------------------------------*/

/**
 * The x-coordinate of the placement.
 */
private final int x;

/**
 * The y-coordinate of the placement.
 */
private final int y;

/*------------------------------------------------
 * PUBLIC METHODS
 *----------------------------------------------*/

/**
 * Construcctor.
 *
 * @param x The x-coordinate of the placement.
 * @param y The y-coordinate of the placement.
 */
public DiskPlacement(int x, int y) {
    this.x = x;
    this.y = y;
}

public int getX() {
    return (x);
}

public int getY() {
    return (y);
}

}
