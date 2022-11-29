package project;

import java.util.Scanner;

public class Question01 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter 3 2-digit numbers : ");
        int num1 = kb.nextInt(); // input n1
        int num2 = kb.nextInt(); // input n2
        int num3 = kb.nextInt(); // input n3

        int sum = num1 + num2 + num3; // sum of 3 input integers

        String magicNum; // magic number according to condition

        /* Condition for magic number
        1. A multiple of 3 but not a multiple of 5 then the magic number is made up of the 1st digit of n2 followed by the sum of n1 and n3.
        2. Not a multiple of 3 but a multiple of 5 then the magic number is made up of the sum of n1 and n3 followed by the last digit of n2.
        3. A multiple of 3 and a multiple of 5 then the magic number is n2 followed by n1 followed by the digit 1.
        4. None of the above conditions then the magic number is n1 followed by n2 followed by n3.
        * */

        if (sum % 3 == 0 && sum % 5 != 0) {
            magicNum = "" + (num2/10) + (num1 + num3);
        } else if (sum % 3 != 0 && sum % 5 == 0){
            magicNum = "" + (num1+num3) + (num2%10);
        }else if(sum % 3 == 0 && sum % 5 == 0){
            magicNum = "" + num2 + num1 + 1;
        }else{
            magicNum = "" + num1 + num2 + num3;
        }

        System.out.println("\nYour magic number is " + magicNum); // show Magic Number


    }
}
