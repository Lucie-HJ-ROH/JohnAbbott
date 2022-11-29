package question08;

import java.util.TreeSet;

public class Q8_treeset {
    public static void main(String[] args) {
        TreeSet<Integer> treeNum = new TreeSet<Integer>();
        TreeSet<Integer> treehead = new TreeSet<Integer>();

        treeNum.add(11);
        treeNum.add(25);
        treeNum.add(13);
        treeNum.add(42);
        treeNum.add(15);
        treeNum.add(63);
        treeNum.add(70);

        System.out.println("Original TreeSet : " + treeNum);
        System.out.println("Remove last TreeSet : " + treeNum.pollLast());
        System.out.println("TreeSet after removing last data : " + treeNum);


    }
}
