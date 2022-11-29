package priorityQueue;

import java.util.PriorityQueue;

public class Priority {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        priorityQueue.add(5);
        priorityQueue.add(1);
        priorityQueue.add(25);
        priorityQueue.add(35);

        System.out.println(priorityQueue.peek());
    }
}
