package algorithm;

import java.util.Scanner;

public class MaxArraySum {
    public static void main(String[] args) {
        int[] array = new int[10];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 10) + 1;
            System.out.print(array[i] + " ");
        }

        System.out.println("\n Input number : " );
        int cnt = sc.nextInt();
        int maxNum = 0;

        for (int i = 0; i < cnt; i++){
            maxNum += array[i];
        }


        for (int i = cnt; i < array.length; i++) {

            int temp = maxNum + array[i] - array[i-cnt];
            if(maxNum<temp){
                maxNum = temp;
            }

            System.out.println("temporary Max number : " + maxNum);
        }

        System.out.println("Max number : " + maxNum);
    }
}
