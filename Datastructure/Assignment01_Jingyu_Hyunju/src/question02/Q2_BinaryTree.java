package question02;

import java.util.*;

public class Q2_BinaryTree {

    public static void instertIntoMultiMap(Map<Integer, List<Integer>> map, Integer key, Integer value){
        map.putIfAbsent(key,new ArrayList<Integer>());
        map.get(key).add(value);
    }

    public static void printBottomTopNodes(Node node){
        if(node == null){
            return;
        }
        int level = 1; // start with root node.

        Map<Integer, List<Integer>> map = new HashMap<>();
        instertIntoMultiMap(map,level,node.data); //root node for first level
        Queue<Node> first = new ArrayDeque<>();
        Queue<Node> second = new ArrayDeque<>();

        System.out.println("Print Bottom Top. ");
        if(node.left!=null && node.right!=null){
            first.add(node.left);
            second.add(node.right);
        }

        while(!first.isEmpty()){
            level++;

            int n = first.size();

            while(n-->0){
                Node x = first.poll();
                instertIntoMultiMap(map,level,x.data);

                if(x.left != null){
                    first.add(x.left);
                }

                if(x.right != null){
                    first.add(x.right);
                }

                Node y = second.poll();
                map.get(level).add(y.data);

                if(y.right!=null){
                    second.add(y.right);
                }
                if(y.left != null){
                    second.add(y.left);
                }
            }
        }

        for (int i = map.size(); i >0 ; i--) {
            System.out.print(map.get(i) + " ");

        }


    }




    // Print binary tree in a specific order form top to bottom
    public static void printTopDownNodes(Node node) {
        if (node == null) {   // if node is null,
            System.out.println("This node is empty");
            return;
        }
        //print root node.
        System.out.print("Print Top-Down. \n" + node.data + " ");

        Queue<Node> first = new ArrayDeque<>(); // node of root's left child
        Queue<Node> second = new ArrayDeque<>(); // node of root's left child

        if (node.left != null && node.right != null) {
            first.add(node.left);
            second.add(node.right);
        }

        while (!first.isEmpty()) { // until first is empty

            int n = first.size(); // calculate the total number of nodes at the current level.

            while (n-- > 0) {  //until every node of current level is printed.
                Node x = first.poll();
                System.out.print(x.data + " ");

                if (x.left != null) {
                    first.add(x.left);
                }

                if (x.right != null) {
                    first.add(x.right);
                }

                Node y = second.poll();
                System.out.print(y.data + " ");
                if (y.right != null) {
                    second.add(y.right);
                }
                if (y.left != null) {
                    second.add(y.left);
                }
            }
        }
    }
    public static Node insertNode(){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(11);
        root.right.left.left = new Node(12);
        root.right.left.right = new Node(13);
        root.right.right.left = new Node(14);
        root.right.right.right = new Node(15);
        return root;

    }
    public static void main(String[] args){

        printTopDownNodes(insertNode());

        System.out.println("\n================================================");

        printBottomTopNodes(insertNode());
    }

}


