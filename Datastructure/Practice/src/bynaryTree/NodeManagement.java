package bynaryTree;

public class NodeManagement {
    Node head = null;

    public boolean insertNode(int data) {
//        case 1 : There is no data in Node.
        if (this.head == null) {
            this.head = new Node(data);
        } else {//        case 2 : There are some nodes in Node.
            Node findNode = this.head;
            while (true) {
                //case 2-1 : New node has to be inserted in left node of Current node.
                if (data < findNode.value) {
                    if (findNode.left != null) {
                        findNode = findNode.left;
                    } else {
                        findNode.left = new Node(data);
                        break;
                    }
                } else {  //case 2-2 : New node has to be inserted in right node of Current node.
                    if (findNode.right != null) {
                        findNode = findNode.right;
                    } else {
                        findNode.right = new Node(data);
                        break;
                    }
                }
            }
        }
        return true;
    }


    public Node search(int data) {
        //case 1 : There is no node.
        if (this.head == null) {
            System.out.println("There is no node.");
            return null;
        } else { // case 2 : There are nodes
            Node findNode = this.head;
            while (findNode != null) {
                if (findNode.value == data) {
                    return findNode;
                } else if (data < findNode.value) {
                    findNode = findNode.left;
                } else {
                    findNode = findNode.right;
                }
            }
            System.out.println("Can not find node.");
            return null;
        }
    }


    public boolean delete(int value) {
        boolean searched = false;

        Node currentParentNode = this.head;
        Node currentNode = this.head;

        // Exception Case 1 : There is no node.
        if (this.head == null) {
            return false;
        } else {  // Exception Case 2 : There is only one node which will be deleted.
            if (this.head.value == value && this.head.left == null && this.head.right == null) {
                this.head = null;
                return true;
            }

            while (currentNode != null) {
                if (currentNode.value == value) {
                    searched = true;
                    break;
                } else if (value < currentNode.value) {
                    currentParentNode = currentNode;
                    currentNode = currentNode.left;
                } else {
                    currentParentNode = currentNode;
                    currentNode = currentNode.right;
                }

                if (searched == false) {
                    return false;
                }
            }
            //After execution this method
            //currentNode  = Node which contains searched value
            //currentParentNode = Parents node of node which contains searched value

        }

        //case 1 . The node which will be deleted is Leaf node.
        if(currentNode.left == null && currentNode.right == null){
            if(value < currentParentNode.value){
                currentParentNode.left = null;
                currentNode = null;
            }else{
                currentParentNode.right = null;
                currentNode = null;
            }
            return true;
            //case 2-1 . The node which will be deleted has one left child node.
        }else if(currentNode.left != null && currentNode.right == null){
            if(value<currentParentNode.value){
                currentParentNode.left =currentNode.left;
                currentNode = null;
            }else{
                currentParentNode.right = currentNode.left;
                currentNode = null;
            }
            return true;
            //case 2-2 . The node which will be deleted has one right child node.
        }else if(currentNode.right != null && currentNode.left == null){
            if(value< currentParentNode.value){
                currentParentNode.left = currentNode.right;
                currentNode = null;
            }else{
                currentParentNode.right = currentNode.right;
                currentNode = null;
            }
            return true;
        }else{//case 3-1 . The node which will be deleted has more than 2 child node and the node is placed on parents node's left.

            // parents node's left
            if(value < currentParentNode.value){
                Node changeNode = currentNode.right;
                Node changeParentNode = currentNode.right;
                while(changeNode.left!=null){
                    changeParentNode = changeNode;
                    changeNode  = changeNode.left;
                }
               //case 3-1-1. There is a right child node in chagneNodecase
                if(changeNode.right!=null){
                    changeParentNode.left = changeNode.right;

                }else{// 3-1-2. There is no child node in chagneNode
                    changeParentNode.left = null;
                }

                //left node of Current parent, delete node's minimum value of node will be connected.
                currentParentNode.left = changeNode;

                //child node of parent node is change node
                //left/right node of changeNode will be chages current node's left/right delete node's minimum value of node will be connected'

                changeNode.right = currentNode.right;
                changeNode.left = currentNode.left;
                currentNode = null;

            }else{// Case3-2:The node to be deleted has two child nodes (when the node to be deleted is to the right of the parent node)
                Node changeNode = currentNode.right;
                Node changeParentNode = currentNode.right;
                while (changeNode.left != null) {
                    changeParentNode = changeNode;
                    changeNode = changeNode.left;
                }
                if (changeNode.right != null) {
                    // Case 3-2-2: When there is a child node to the right of changeNode
                    changeParentNode.left = changeNode.right;
                } else {
                    // Case 3-2-1: When there is no child node of changeNode
                    changeParentNode.left = null;
                }

                // To the right Child Node of currParentNode, among the right children of the Node to delete,
                // Connect the changeNode with the smallest value
                currentParentNode.right = changeNode;

                // The left Child Node of parentNode is the current changeNode,
                // All of the left/right Child Nodes of changeNode and the currNode to be deleted
                // Change to the existing left/right Node
                changeNode.right = currentNode.right;
                changeNode.left = currentNode.left;

                currentNode = null;
            }
        }
        return true;
    }



}
