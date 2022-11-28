package question01;

import java.util.Scanner;

public class Q01Test_ArrayList {
    public static void main(String[] args) {
        System.out.print("Give me n : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 1;
        System.out.print("Give me all of the value : [" + n + "]  : " );

        Q01Heap_ArrayList q01Test = new Q01Heap_ArrayList(sc.nextInt());
        while(cnt < n){
            q01Test.insert(sc.nextInt());
            cnt++;
        }

        String beforeResult = q01Test.heapArray.toString();

        System.out.print("Give me new value : ");
        q01Test.insert(sc.nextInt());

        System.out.println("HEAP BEFORE ADD  : " + beforeResult);
        System.out.println("HEAP AFTER ADD  : " + q01Test.heapArray);
        System.out.println("Min : " + q01Test.remove());
        System.out.println("HEAP AFTER REMOVE  : " + q01Test.heapArray);

    }
}
