package project;

import java.util.Random;
import java.util.Scanner;

public class Question03 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter the number of row for array : ");
        int row = kb.nextInt(); // number of row for array
        System.out.print("Enter the number of col for array : ");
        int col = kb.nextInt(); // number of col for array

        //create array
        int[][] arr =createArray(row, col);

        // show array
        printArray(arr);

        System.out.println("Which number want to disappear? : ");
        int pickNum = kb.nextInt(); // choose the number for remove
        arr = removeArray(arr, pickNum); // return the new array after remove the picked number

        //show new Array
        printArray(arr);

    }

    public static int[][] createArray(int row, int col){
        Random random = new Random();
        int[][] arr = new int[row][col]; // create array using input row, col size

        for (int i = 0; i < row; i++) {
            for (int j = 0; j <col ; j++) {
                arr[i][j] = random.nextInt(100) + 1; // create array , value = random number between 1-100
            }
        }
        return arr;
    }
    public static void printArray(int[][] arr){
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] removeArray(int[][] arr, int num){

        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j <arr[i].length ; j++) {
                if(arr[i][j] == num){
                    arr[i][j] = 0;
                }
            }
        }

        return arr;
    }
}
