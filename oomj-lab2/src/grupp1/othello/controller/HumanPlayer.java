package grupp1.othello.controller;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

//import blah;

/*------------------------------------------------
 * CLASS
 *----------------------------------------------*/

/**
 * @author
 */
public class HumanPlayer extends Player {

/*------------------------------------------------
 * PUBLIC METHODS
 *----------------------------------------------*/

@Override
public void initialize() {

}

@Override
public int[] makeNextMove() {
    System.out.println("varfan vill du sätta brickan");

    int[] lol = new int[2];
    lol[0] = 4;
    lol[1] = 3;

    return (lol);
}

@Override
public void notifyInvalidMove() {
    System.out.println("du, det där ger du fan i!");
}

/*------------------------------------------------
 * PRIVATE METHODS
 *----------------------------------------------*/

}
