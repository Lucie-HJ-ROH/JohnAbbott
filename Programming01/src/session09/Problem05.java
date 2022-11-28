package session09;

import java.util.Random;
import java.util.Scanner;

/**
 * Getting the size of array from use
 * We ask user to put values
 * Printing the array
 * Asking for use which number wants to search inside the array    15
 * You return index
 * Ask from user which number wants to replace   0   method
 */
public class Problem05 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter the size of array's number  : ");
        int size = kb.nextInt();
        int[] arr = new int[size];
        Random rand = new Random();


        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100);
        }

        for (int showArr : arr
        ) {
            System.out.print(showArr + " , ");
        }

        System.out.print("\nWhich number wants to search inside the array : ");
        int pickNum = kb.nextInt();
        findIndex(pickNum, arr);

        System.out.print("\nWhich number wants to replace inside the array : ");
        int first = kb.nextInt();
        System.out.printf("\nWhich number wants to change instead of the %d : ", first);
        int second = kb.nextInt();

        replaceArr(arr, first, second);
        System.out.print("After change : ");
        System.out.println();
        for (int showArr : arr
        ) {
            System.out.print(showArr + " , ");
        }

        System.out.printf("\nHow long expand array ?: ");
        int expandNum = kb.nextInt();

        arr = expandArr(arr, expandNum);
        System.out.print("Expand change : ");
        System.out.println();
        for (int showArr : arr
        ) {
            System.out.print(showArr + " , ");

        }

    }

    public static void findIndex(int findNum, int[] arr) {
        int index = -1;
        int j = 0;
        while (j < arr.length) {
            if (arr[j] == findNum) {
                index = j;
            }
            j++;
        }
        if (index < 0) {
            System.out.println("We can't find your number.");
        } else {
            System.out.println("\nThe number of index is " + index);
        }
    }

    public static int[] replaceArr(int[] arr, int first, int second) {
        int index = -1;
        int j = 0;
        while (j < arr.length) {
            if (arr[j] == first) {
                arr[j] = second;
            }
            j++;
        }
        if (index < 0) {
            System.out.println("We can't find your number.");
        }
        return arr;

    }

    public static int[] expandArr(int[] arr, int x) {

        int[] newArr = new int[x];
        for (int i = 0; i <arr.length ; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }
}
