package q2;

import java.util.*;

public class Question02 {
    public static void main(String[] args) {

        System.out.println("Give me first size...");
        Scanner sc = new Scanner(System.in);
        int firstSize = sc.nextInt();
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        HashMap<Integer,Integer> joinArray = new HashMap<Integer, Integer>();

        int inputNum = 0;
        for (int i = 0; i<firstSize; i++) {
            inputNum = sc.nextInt();
            if(!joinArray.containsKey(inputNum)) {
                joinArray.put(inputNum, i);
                arrayList.add(inputNum);
            }
        }

        System.out.println("Give me second size...");
        int secondSize = sc.nextInt();

        for (int i = 0; i<secondSize; i++) {
            inputNum = sc.nextInt();
            if(!joinArray.containsKey(inputNum)) {
                joinArray.put(inputNum, i);
                arrayList.add(inputNum);
            }
        }
        Collections.sort(arrayList);
        System.out.println("Result : " + arrayList);

    }

}
