package finalTest;

import java.util.Scanner;

public class Question02 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.println("Please put your N value");
        int arrSize = kb.nextInt(); // input value from user & it is size of array.

        int[][] arr = new int[arrSize][arrSize]; // Creat array size of input number

        //input array size with input number(arrSize)
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = kb.nextInt();           //input number of array.
            }
        }
        showReverseArray(arr); //Show reverse array
    }

    /**
     * make print method to display reverse array
     * @param arr
     */
    public static void showReverseArray(int[][] arr) {
        //print array in inverse
        for (int i = arr.length-1; i >=0; i--) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("%d ", arr[i][j]);    //print number of array.
            }
            System.out.println();
        }

    }


}
