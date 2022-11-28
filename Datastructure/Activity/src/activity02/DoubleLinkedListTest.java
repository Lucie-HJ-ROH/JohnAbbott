package activity02;

public class DoubleLinkedListTest {
    public static void main(String[] args) {
        DoubleLinkedList<Integer> MyLinkedList = new DoubleLinkedList<Integer>();

        MyLinkedList.addNode(1);
        MyLinkedList.addNode(2);
        MyLinkedList.addNode(3);
        MyLinkedList.addNode(5);
        MyLinkedList.addNode(6);
        System.out.println("-------ADD NODE 1, 2, 3, 5, 6---------");
        MyLinkedList.printAll();

        MyLinkedList.insertToAfter(3, 4);

        System.out.println("\n---------Insert Nde After(3, 4)----------------");
        MyLinkedList.printAll();


        System.out.println("\n-------------Delete Last Node-------------------------");
        MyLinkedList.deleteNode();
        MyLinkedList.printAll();


    }
}
