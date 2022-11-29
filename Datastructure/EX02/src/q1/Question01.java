package q1;

import java.util.Scanner;


public class Question01 {
    public static void main(String[] args) {
        System.out.println("Size of hash table");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        int[] array = new int[size];
        Integer[] hash = new Integer[size];
        int inputNum;
        int collision = 0;
        int index = 0;
        int mod = 0;


        System.out.println("Give me the numbers : ");
        for (int i = 0; i < size; i++) {
            inputNum = sc.nextInt();
            array[i] = inputNum;
        }
        for (int i = 0; i < size; i++) {
            int tempCol =0;
            mod = array[i] % size;
            while (hash[mod] != null) {
                if (mod >= size-1) {
                    mod = 0;
                }else{
                    mod++;
                }
                tempCol++;
                if(collision < tempCol) {
                    collision = tempCol;
                    index = mod;
                }

            }

            hash[mod] = array[i];


        }

        System.out.println("Max collision : " + collision);
        System.out.println("Landed index : " + index);
        System.out.println("The Hash will be : ");
        for (int i = 0; i < size;i++) {
            System.out.print(hash[i] + " ");
        }
    }
}
