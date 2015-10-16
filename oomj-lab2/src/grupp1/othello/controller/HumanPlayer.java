package grupp1.othello.controller;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import grupp1.othello.model.DiskPlacement;

import java.util.Scanner; // @To-do: Remove.

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

public HumanPlayer(String name) {
    super(name);
}

@Override
public void init() {

}

@Override
public DiskPlacement makeNextMove() {
    Scanner user_input = new Scanner( System.in );
    System.out.println("varfan vill du sätta brickan");

    int[] lol = new int[2];
    lol[0] = user_input.nextInt();
    lol[1] = user_input.nextInt();

    return (new DiskPlacement(lol[0], lol[1]));
}

@Override
public void notifyInvalidMove() {
    System.out.println("du, det där ger du fan i!");
}

/*------------------------------------------------
 * PRIVATE METHODS
 *----------------------------------------------*/

}
