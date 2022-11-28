package project;

import java.util.Random;
import java.util.Scanner;

public class Question05 {
    public static Scanner kb = new Scanner(System.in);
    public static Random random = new Random();

    public static void main(String[] args) {

        System.out.println("Enter the size of the array : ");
        int size = random.nextInt(5) * 2 + 3; // generate odd size, more than 3;

        int[] arrValue = createArray(size); //  create array
        printArray(arrValue);           // print the numbers
        findMajorityNumber(arrValue); // find the missing number

    }

    public static int[] createArray(int size) {

        int[] arr = new int[size]; //
        int randomMax = random.nextInt(10);  // for random number between 1-10

        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(2) + randomMax; // generate 2 type of random number boundary(1-10)
        }
        return arr;
    }

    //display the array
    public static void printArray(int[] arr) {
        System.out.print("Input : nums = [");
        for (int i = 0; i <arr.length ; i++) {
            if(i!=arr.length-1){
                System.out.print(arr[i] +", ");
            }
            else{
                System.out.print(arr[i]);
            }
        }

        System.out.println("]");
    }

    public static void findMajorityNumber(int[] arr) {
        int majorityNum; // find majority number
        int[] findArr = new int[2]; // save the 2 number of array
        int cnt = 1; // count the number of number

        findArr[0] = arr[0]; // initialize findArr[0]

        for (int j = 1; j < arr.length; j++) { // arr[0] find the same number inside array arr[1 to size of array]
            if (arr[0] == arr[j]) {
                cnt++;                      // if find same number of value , add count
            } else if (arr[j] != arr[0]) {
                findArr[1] = arr[j];        // find other number of value, input value findArr[1]
            }
        }
        if (cnt > (arr.length / 2)) {            // if count number is more than n/2 times
            System.out.println("Output : " + findArr[0]);  // print first index value of array
        } else {
            System.out.println("Output : " + findArr[1]);
        }

    }


}
