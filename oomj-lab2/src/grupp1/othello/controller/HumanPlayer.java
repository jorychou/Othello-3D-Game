package grupp1.othello.controller;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/
import java.util.Scanner;
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
    Scanner user_input = new Scanner( System.in );
    System.out.println("varfan vill du sätta brickan");

    int[] lol = new int[2];
    lol[0] = user_input.nextInt();
    lol[1] = user_input.nextInt();

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
