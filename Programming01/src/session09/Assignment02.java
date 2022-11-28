package session09;

import java.util.Scanner;

public class Assignment02 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int pickPattern;  //Pick the number of patter

        /*Input number for choice the pattern, until value is correct (1-5)*/
        /*This function will be continued before user input the '5'
         * */
        System.out.println(" === Welcome to Lucie's Triangle/Diamond Printer === ");

        do {
            printPatternExam();  // print sample pattern
            System.out.print("Enter your choice  (5 to Quit) : ");
            pickPattern = kb.nextInt();
            choosePattern(pickPattern); // choose the pattern between 1 and 4
        } while (pickPattern != 5);

    }

    public static void printPatternExam() {
        String printEx;  // Show which pattern will be displayed
        printEx =
                """
                        1) 54321    2)     1    3) 12345    4)   1
                           5432           12        2345        123
                           543           123         345       12345
                           54           1234          45        123
                           5           12345           5         1     
                        """;


        System.out.println("Which pattern do you want to print? ");
        System.out.println(printEx); // print pattern example

    }

    public static void choosePattern(int pickPattern) {
        Scanner sc = new Scanner(System.in);
        int row;        // row of pattern

        //if user input the 5 , Program finish.
        if (pickPattern == 5) {
            System.out.println("Hope you enjoyed the triangles.");
            System.exit(0);
        }

        // input number must be between 1 and 5
        while (pickPattern < 0 || pickPattern > 5) {
            System.out.println("Oops! It's an invalid number. Try again.");
            System.out.print("Please enter a number between 1 and 5 inclusive : ");
            pickPattern = sc.nextInt();
        }

        /*Input number for row to make pattern, until value is correct (1-10)*/
        System.out.print("How many rows would you like to print? (More than 1 please): ");
        row = sc.nextInt();
        while (row < 2 || row > 10) { // input value must be between 1 and 10
            System.out.println("How many rows would you like to print? (More than 1 please):");
            row = sc.nextInt();
        }

        //match the function to the selected number.
        switch (pickPattern) {
            case 1:
                pattern01(row);
                break;
            case 2:
                pattern02(row);
                break;
            case 3:
                pattern03(row);
                break;
            case 4:
                pattern04(row);
                break;
        }
    }

    public static void pattern01(int row) {
        System.out.println("This is pattern 01");
        /**
         *  each value of in inside for loop indicate below.
         *  int i for number index of row
         *  int j for space
         *  int k for number
         */
        for (int i = 0; i < row; i++) {
            for (int j = i; j > row; j--) {
                System.out.print(" ");
            }
            for (int k = row; k > i; k--) {
                System.out.print(k);
            }
            System.out.println();
        }

    }

    public static void pattern02(int row) {
        System.out.println("This is pattern 02");
        /**
         *  each value of in inside for loop indicate below.
         *  int i for row
         *  int j for space
         *  int k for number
         */
        for (int i = 0; i < row; i++) {
            for (int j = i; j < row; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k <= i; k++) {
                System.out.print(k + 1);
            }
            System.out.println();
        }
    }

    public static void pattern03(int row) {
        System.out.println("This is pattern 03");
        /**
         *  each value of in inside for loop indicate below.
         *  int i for number index of row
         *  int j for space
         *  int k for number
         */
        for (int i = 0; i < row; i++) {
            for (int j = i; j > 0; j--) {
                System.out.print(" ");
            }
            for (int k = i; k < row; k++) {
                System.out.print(k + 1);
            }
            System.out.println();
        }

    }

    public static void pattern04(int row) {
        System.out.println("This is pattern 04");
        /**
         *  each value of in inside for loop indicate below.
         *  int i for number index of first part of row
         *  int j for space
         *  int k for number
         *  int a for number index of last part of row
         *  int b for space
         *  int c for number
         */
        if (row % 2 == 0) { // if number of row of pattern4 is even.
            for (int i = 0; i < row / 2; i++) {
                for (int j = i; j < row / 2; j++) {
                    System.out.print(" ");
                }
                for (int k = 0; k <= i * 2; k++) {
                    System.out.print(k + 1);
                }
                System.out.println();
            }
        } else {
            for (int i = 0; i < row / 2 + 1; i++) {
                for (int j = i; j < row / 2; j++) {
                    System.out.print(" ");
                }
                for (int k = 0; k <= i * 2; k++) {
                    System.out.print(k + 1);
                }
                System.out.println();
            }
        }

        for (int a = row / 2; a > 0; a--) {
            for (int b = a; b <= row / 2; b++) {
                System.out.print(" ");
            }
            for (int c = 0; c < a * 2 - 1; c++) {
                System.out.print(c + 1);
            }
            System.out.println();
        }


    }
}
