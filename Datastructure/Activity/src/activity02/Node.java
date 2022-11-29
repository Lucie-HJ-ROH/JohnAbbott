package activity02;

public class Node<T> {
    T data;
    Node<T> prev = null;
    Node<T> next = null;


    public Node(T data) {
        this.data = data;
    }
}
