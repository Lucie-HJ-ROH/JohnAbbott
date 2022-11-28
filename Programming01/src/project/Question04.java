package project;

import java.util.Random;
import java.util.Scanner;

public class Question04 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter the number of row for array : ");
        int size = kb.nextInt(); // number of row for array
        //create array
        int[] arr = createArray(size);

        // show array
        printArray(arr);

        //sort the array
        arr = sortArray(arr);

        System.out.println("\nAfter sorting  : ");
        //show sorted Array
        printArray(arr);

    }


    public static int[] createArray(int size) {
        Random random = new Random();
        int[] arr = new int[size]; // create array using input row, col size

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100) + 1; // create array , value = random number between 1-100
        }
        return arr;
    }

    //display the array
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    //array sorting
    public static int[] sortArray(int[] arr) {
        int temp; // temporay value for saving array value
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j <arr.length ; j++) {
                if(arr[i]>arr[j]){   //Ascending order
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        return arr;
    }
}
