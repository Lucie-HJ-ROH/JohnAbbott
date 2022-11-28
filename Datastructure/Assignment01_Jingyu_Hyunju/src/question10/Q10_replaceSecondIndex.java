package question10;

import java.util.ArrayList;

public class Q10_replaceSecondIndex {
    public static void main(String[] args) {
        ArrayList<String> rList = new ArrayList<String>();

        rList.add("Original first");
        rList.add("Original second");
        rList.add("Original third");

        System.out.println("Before replace the List : " + rList);
        rList.set(1, "Change Second element");
        System.out.println("After replace the List : " + rList);

    }
}
