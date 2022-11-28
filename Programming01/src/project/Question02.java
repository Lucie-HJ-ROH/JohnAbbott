package project;

import java.util.Scanner;

public class Question02 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.println("Joker :");
        int joker = kb.nextInt(); // input number of joker
        System.out.println("Number : ");
        int num = kb.nextInt();  // numbers for how many put

        System.out.println("Enter number : ");
        int[] arrValue = new int[num]; // create num size integer array.

        for (int i = 0; i < arrValue.length; i++) {
            arrValue[i] = kb.nextInt(); // input number of value
        }


        /*Condition of this game
        If the number is less than joker give the zero otherwise deduct
        that number until getting number less than joker and keep that number.
        */

        for (int j = 0; j < arrValue.length; j++) {      // show the result
            System.out.print(arrValue[j] % joker + " "); // number to joker remainder
        }

    }
}
