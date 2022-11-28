package bynaryTree;

public class Test {
    public static void main(String[] args) {
        NodeManagement myTree = new NodeManagement();
        myTree.insertNode(2);
        myTree.insertNode(4);
        myTree.insertNode(6);
        myTree.insertNode(8);

        myTree.search(4);
    }
}
