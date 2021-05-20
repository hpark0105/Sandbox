package Tree;

public class BinarySearchTree {
    //inner Node class
    class Node {
        Integer data;
        Node left;
        Node right;
        Node(Integer data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    Node root = null;
    public void add(Integer value) {
        root = addRecursive(root, value);
    }
    private Node addRecursive(Node node, Integer value) {
        if(node == null) {
            System.out.println("setting up node with [" + value + "]");
            node = new Node(value);
            return node;
        }
        if(value < node.data) {
            node.left = addRecursive(node.left, value);
        } else if(value > node.data) {
            node.right = addRecursive(node.right, value);
        }
        return node;
    }
    public void printInOrder(Node node) {
        if(node == null) {
            return;
        }
        printInOrder(node.left);
        System.out.print(node.data + ",");
        printInOrder(node.right);

    }
    public static void main(String args[]){
        System.out.println("tree example");
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(10);
        bst.add(3);
        bst.add(8);
        bst.add(11);
        System.out.println("Printing InOrder()");
        bst.printInOrder(bst.root);
        System.out.println("Complete");
    }

}
