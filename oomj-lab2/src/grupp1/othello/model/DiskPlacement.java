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

/**
 * Gets the x-coordinate of the disk placement.
 *
 * @return The x-coordinate of the disk placement.
 */
public int getX() {
    return (x);
}

/**
 * Gets the y-coordinate of the disk placement.
 *
 * @return The y-coordinate of the disk placement.
 */
public int getY() {
    return (y);
}

}
