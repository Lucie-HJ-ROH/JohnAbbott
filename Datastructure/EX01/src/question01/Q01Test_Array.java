package question01;

import java.util.Scanner;

public class Q01Test_Array {
    public static void main(String[] args) {

        System.out.println("-----------------Arrays ----------------");
        System.out.print("Give me n : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;
        System.out.print("Give me all of the value : [" + n + "]  : " );

        Q01HeapArray q01Test = new Q01HeapArray(n);

        while(cnt < n){
            q01Test.insert(sc.nextInt());
            cnt++;
        }

        String beforeResult = q01Test.showHeap();
        System.out.print("Give me new value : ");
        q01Test.insert(sc.nextInt());


        System.out.println("HEAP AFTER ADD  : " + beforeResult);
        System.out.println("HEAP AFTER REMOVE  : " + q01Test.showHeap());
        System.out.println("Min : " + q01Test.remove());
        System.out.println("HEAP AFTER REMOVE  : " + q01Test.showHeap());
    }
}
