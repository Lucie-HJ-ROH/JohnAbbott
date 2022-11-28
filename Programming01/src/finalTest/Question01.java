package finalTest;

import java.util.Scanner;

public class Question01 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter a string : ");
        String name = kb.nextLine();           // input user name

        char[] arrName = changeArray(name); // change the String to array using changeArray method.

        showPattern(arrName); // Display the pattern of name.


    }

    public static char[] changeArray(String str){

        char[] arrName = new char[str.length()]; // string changed to array to display

        for (int i = 0; i <str.length() ; i++) {
            arrName[i] = str.charAt(i); // match string index to char array.
        }
        return arrName; // return char array
    }

    /**
     * show name of array with pattern.
     * @param charName
     */
    public static void showPattern(char[] charName){
        System.out.println();
        //fist part of the print pattern
        for (int i = 0; i < charName.length; i++) {
            for (int j = 0; j < charName.length-i ; j++) {
                System.out.print(charName[j] + "\t");   //print the char of array
            }
            System.out.println();
        }
        //second part of the print patter
        for (int i = 1; i < charName.length; i++) {
            for (int j = 0; j < i+1 ; j++) {
                System.out.print(charName[j] + "\t");   //print the char of array
            }
            System.out.println();
        }

    }

}
