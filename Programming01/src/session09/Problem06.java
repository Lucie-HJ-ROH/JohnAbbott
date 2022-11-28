package session09;

import java.util.Random;
import java.util.Scanner;
public class Problem06 {
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

        System.out.print("\nWhich number wants to delete inside the array : ");
        int pickNum = kb.nextInt();
        arr = deleteArr(arr, pickNum);
        System.out.print("After change : ");
        System.out.println();
        for (int showArr : arr
        ) {
            System.out.print(showArr + " , ");

        }

    }
    public static int[] deleteArr(int[] arr, int x) {
        int index = -1;

        for (int i = 0; i <arr.length ; i++) {
            if(arr[i] == x){
                index = i;
            }
        }
        for (int j = index; j < arr.length-1 ; j++) {
            arr[j] = arr[j+1];
        }
        arr[arr.length-1] = 0;
        return arr;
    }
}
