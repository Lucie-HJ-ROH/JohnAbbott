package assignment02;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 * Assignment 2227572
 * Question : Part1
 * Written by : Hyunju Roh 2227572
 */


public class LadderAndSnake {

    Random random = new Random();

    private int[][] board; // this is board for LadderAndSnake 10*10;
    private int numOfPlayer;     // player's number

    private String index; // Player's number to String


    private int order; //order number when player's play the game.
    private int square; // square on the board

    public LadderAndSnake(int numOfPlayer) {
        this.numOfPlayer = numOfPlayer;
        this.index = String.valueOf(numOfPlayer);
        this.square = 0;
        this.board = new int[10][10];
        setOrder();
    }


    /**
     * To determine the order of playing turns
     *
     * @return
     */


    public int flipDice() { // make random dice
        return random.nextInt(6) + 1;
    }


    public int getOrder() { // return the first dice to order players
        return order;
    }

    public void setOrder() { // if the players have same number, run again.
        order = flipDice();
    }

    public String getIndex() { // return Players index.[1st, 2nd....]
        return index;
    }


    public void play() {

        int dice = flipDice();
        System.out.println("\nPlayer #" + getIndex() + " got a dice value of " + dice);
        System.out.println("Before : " + square + " and move to " + setSquare(dice));

    }

    /**
     * Initialize the board.
     */
    public void boardSetting() {
        int count = 1;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board[i][j] = count;
                count++;
            }
            System.out.println();
        }
    }

    public int setSquare(int dice) { // move square

        square = checkCondition(square + dice); // check the rules

        return square;
    }

    public int getSquare() { // return position
        return square;
    }


    /**
     * Define Game rules on the board.
     *
     * @param square
     * @return currentPosition
     */
    public int checkCondition(int square) {

        int currentSquare;
        if(square > 100){
            square = square - 100;
        }

        switch (square) {
            case 1:
                System.out.println("You find the ladder. You can go up!");
                currentSquare = 38;
                break;
            case 4:
                System.out.println("You find the ladder. You can go up!");
                currentSquare = 14;
                break;
            case 9:
                System.out.println("You find the ladder. You can go up!");
                currentSquare = 31;
                break;
            case 16:
                System.out.println("You meet the snake. You have to go down ;(");
                currentSquare = 6;
                break;
            case 21:
                System.out.println("You find the ladder. You can go up!");
                currentSquare = 42;
                break;
            case 36:
                System.out.println("You find the ladder. You can go up!");
                currentSquare = 44;
                break;
            case 48:
                System.out.println("You meet the snake. You have to go down ;(");
                currentSquare = 30;
                break;
            case 51:
                System.out.println("You find the ladder. You can go up!");
                currentSquare = 67;
                break;
            case 64:
                currentSquare = 60;
                break;
            case 71:
                System.out.println("You find the ladder. You can go up!");
                currentSquare = 91;
                break;
            case 79:
                System.out.println("You meet the snake. You have to go down ;(");
                currentSquare = 19;
                break;
            case 80:
                System.out.println("You find the ladder. You can go up!");
                currentSquare = 100;
                break;
            case 93:
                System.out.println("You meet the snake. You have to go down ;(");
                currentSquare = 68;
                break;
            case 95:
                System.out.println("You meet the snake. You have to go down ;(");
                currentSquare = 24;
                break;
            case 97:
                System.out.println("You meet the snake. You have to go down ;(");
                currentSquare = 76;
                break;
            case 98:
                System.out.println("You meet the snake. You have to go down ;(");
                currentSquare = 78;
                break;

            default:
                currentSquare = square;

        }

        return currentSquare;

    }


    @Override
    // if first dice is same, it is equal.
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderAndSnake that = (LadderAndSnake) o;
        return order == that.order;
    }

}
