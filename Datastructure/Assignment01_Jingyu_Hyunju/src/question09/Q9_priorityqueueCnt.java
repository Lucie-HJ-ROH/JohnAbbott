package question09;

import java.util.PriorityQueue;

public class Q9_priorityqueueCnt {
    public static void main(String[] args) {
        PriorityQueue<Character> priorityQueue = new PriorityQueue<Character>();
        char a = 'A';

        for (int i = 0; i < 26; i++) {
            priorityQueue.add(a);
            a++;
        }
        System.out.println("PriorityQueue: " + priorityQueue);
        System.out.println("Size of priorityQueue: " + priorityQueue.size());
    }
}
