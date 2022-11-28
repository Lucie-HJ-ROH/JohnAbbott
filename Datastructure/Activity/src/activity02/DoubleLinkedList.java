package activity02;

import linkedList.MyListNode;

public class DoubleLinkedList<T> {
    public Node<T> head = null;
    public Node<T> tail = null;

    public void addNode(T data) {
        if (head == null) { // if head is null, there is nothing in the list
            this.head = new Node<T>(data);// make new node and it becomes head and tail
            this.tail = head;
        } else {
            Node<T> node = this.head;   // input the data end of the list
            while (node.next != null) {   // find the last node
                node = node.next;
            }
            node.next = new Node<T>(data);  //find last node and link the new node after the last node
            node.next.prev = node;  // new node's prev is previous last node.
            this.tail = node.next; // new node becomes tail.

        }
    }

    public void deleteNode() {
        if (head == null) { // if head is null, list is empty
            System.out.println("List is empty");
            return;
        } else if (head.next == null) { // there is only one node, delete node, head and tail are null
            System.out.println("Delete Success List is empty now.");
            this.head = null;
            this.tail = null;
        }else{
            tail = tail.prev;       // delete last node (last node is tail)
            tail.next = null;
        }
    }

    public void printAll() {

        if (this.head != null) {
            Node<T> node = this.head;
            System.out.print(node.data + " \t");
            while (node.next != null) {
                node = node.next;
                System.out.print(node.data + " \t");
            }

        }
    }


    public T searchFromHead(T isData) {
        if (this.head == null) {
            return null;
        } else {
            Node<T> node = this.head;
            while (node != null) {
                if (node.data == isData) {
                    return node.data;
                } else {
                    node = node.next;
                }
            }
            return null;
        }
    }


    public T searchFromTail(T isData) {
        if (this.head == null) {
            return null;
        } else {
            Node<T> node = this.tail;
            while (node != null) {
                if (node.data == isData) {
                    return node.data;
                } else {
                    node = node.prev;
                }
            }
            return null;
        }
    }

    public boolean insertToAfter(T existedData, T addData) {
        if (this.head == null) {// if head is null just input the addNode as a head.
            this.head = new Node<T>(addData);
            this.tail = head;
            return true;
        } else if (this.head.data == existedData) { // if the data existed in head, tail becomes the addNode
            this.head.next = new Node<T>(addData);  // head's next is new node
            this.head.next.prev = head;     //new node's prev is head
            this.tail = this.head.next;         //newNode is head.
            return true;
        } else {
            Node<T> node = this.head;           //for searching at the first of head
            while (node != null) {                 // until node is not null (it means , it reaches to the tailNode
                if (node.data == existedData) {   // if found the data(Position)
                    Node<T> nodeNext = node.next;       // make temporary node , we have to put the newNode between foundNode and foundNode's next
                    nodeNext.prev = new Node<T>(addData); // node's next is newNode
                    nodeNext.prev.next = nodeNext;       // newNode's next is nodeNext
                    node.next = nodeNext.prev;          //node's next is newNode
                    nodeNext.prev.prev = node;          //newNode's prev is node'
                    return true;
                } else {
                    node = node.next;
                }
            }
            return false;
        }

    }

    public boolean insertToFront(T existedData, T addData) {
        if (this.head == null) {
            this.head = new Node<T>(addData);
            this.tail = head;
            return true;
        } else if (this.head.data == existedData) {
            Node<T> newHead = new Node<T>(addData);
            newHead.next = this.head;
            this.head = newHead;
            return true;
        } else {
            Node<T> node = this.head;
            while (node != null) {
                if (node.data == existedData) {
                    Node<T> nodePrev = node.prev;
                    nodePrev.next = new Node<T>(addData);
                    nodePrev.next.next = node;


                    nodePrev.next.prev = nodePrev;
                    node.prev = nodePrev.next;
                    return true;
                } else {
                    node = node.next;
                }
            }
            return false;
        }
    }

}
