package question05;

import java.util.LinkedList;

public class Q5_linkedList {
    public static void main(String[] args) {
        LinkedList<Character> random = new LinkedList<Character>();

        char a = 'A';

        for (int i = 0; i < 26; i++) {
            random.add(a);
            a++;
        }

        for (int i = 0; i < random.size(); i++) {
            System.out.print(i + " :" + random.get(i) + ", ");
        }

    }
}
