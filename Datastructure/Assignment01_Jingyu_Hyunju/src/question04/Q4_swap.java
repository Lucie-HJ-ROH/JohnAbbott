package question04;

import java.util.ArrayList;
import java.util.Collections;

public class Q4_swap {
    public static void main(String[] args) {
        ArrayList<String> swapList = new ArrayList<String>();
        swapList.add("First String");
        swapList.add("Second String");

        System.out.println("Before swap : " + swapList);
//        Collections.swap(swapList, 0, 1);
        String tempStr = swapList.get(0);

        swapList.set(0,swapList.get(1));
        swapList.set(1,tempStr);
        System.out.println("After swap : " + swapList);






    }
}
