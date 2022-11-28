package project;

import java.util.Random;
import java.util.Scanner;

public class Question06 {
    public static Random random = new Random();
    public static Scanner kb = new Scanner(System.in);
    public static void main(String[] args) {


        int[] arrValue = createArray(); //  create array
        printArray(arrValue);           // print the numbers
        findMissingNumber(arrValue); // find the missing number

    }

    public static int[] createArray() {
        int size = random.nextInt(10) + 1;
        int[] arr = new int[size]; //

        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(size+1); // create array , value = random number between 0-size
            for (int j =0; j < i ; j++) {
                if(arr[i] == arr[j]){     //prevent duplicated numbers inside the array.
                    i--;
                }
            }
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

    public static int[] sortArray(int[] arr) {

        int temp; // temporay value for saving array value
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j <arr.length ; j++) {
                if(arr[i]>arr[j]){   //Ascending array
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }

        }

        return arr;
    }
    public static void findMissingNumber(int[] arr){
        int num = 0; // find missing number

        arr = sortArray(arr); // array sorting for finding number

        for (int i = 0; i <arr.length ; i++) {
            if(arr[i] != i){ // match sorting number 0-size and i
                num = i;    // find index = missing number
                break;
            }else{
                num = arr.length; // if it can not find the number under a range of array, the find number is the last index of the array
            }

        }
        System.out.print("Output : " + num);
        System.out.printf("\n n = %d since there are %d numbers, so all numbers are in the range [0, %d]. %d is the missing number in the range since it does not appear in nums.", arr.length, arr.length,arr.length, num);
    }
}
