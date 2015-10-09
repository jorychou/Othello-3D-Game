package grupp1.othello.controller;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import blah;

/*------------------------------------------------
 * CLASS
 *----------------------------------------------*/

/**
 * @author
 */
public abstract class Player {

private int markerID;

private String name;

/*------------------------------------------------
 * PUBLIC METHODS
 *----------------------------------------------*/

public int getMarkerID() {
    return (markerID);
}

public void setMarkerID(int value) {
    markerID = value;
}

public String getName() {
    return (name);
}

public void setName(String value) {
    name = value;
}

public abstract void makeNextMove();

/*------------------------------------------------
 * PRIVATE METHODS
 *----------------------------------------------*/

}
