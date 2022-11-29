package question06;

import java.util.LinkedList;

public class Q6_joinList {
    public static void main(String[] args) {
        LinkedList<Character> firstList = new LinkedList<Character>();
        LinkedList<Character> secondList = new LinkedList<Character>();
        LinkedList<Character> joinList = new LinkedList<Character>();

        char first = 'A';
        char second = 'a';

        for (int i = 0; i < 26; i++) {
            firstList.add(first);
            first++;
            secondList.add(second);
            second++;
        }
//        joinList.addAll(firstList);
//        joinList.addAll(secondList);
        for (int i = 0; i < 26; i++) {
            joinList.add(firstList.get(i));
        }
        for (int i = 0; i < 26; i++) {
            joinList.add(secondList.get(i));
        }
        System.out.println("firstList : " + firstList);
        System.out.println("secondList : " + secondList);
        System.out.println("joinList : " + joinList);

    }
}
