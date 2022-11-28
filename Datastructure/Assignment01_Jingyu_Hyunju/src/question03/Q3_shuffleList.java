package question03;

import java.util.Collections;
import java.util.LinkedList;

public class Q3_shuffleList {
    public static void main(String[] args) {
        LinkedList<String> originalList = new LinkedList<String>();
        LinkedList<String> shuffle = new LinkedList<String>();

        originalList.add("first");
        originalList.add("second");
        originalList.add("third");
        originalList.add("fourth");
        originalList.add("fifth");


        System.out.println("Linked List before the shuffle(Original List) : " + originalList);
        for (int i = 0; i < originalList.size(); i++){
            int index = (int) (Math.random() * 5);
            if(!shuffle.contains(originalList.get(index))){
                shuffle.add(originalList.get(index));
            }else{
                i--;
            }
        }
        //        Collections.shuffle(random);
        System.out.println("Linked List after the shuffle(Shuffled List) : " + shuffle);


    }
}
