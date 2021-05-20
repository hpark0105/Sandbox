package Tree;

import java.util.*;

class LevelOrder {
  public static void levelOrder(Node root) {
    Queue<Node> queue = new LinkedList();
    queue.add(root);
    while(!queue.isEmpty()) {
      Node tempNode = queue.poll();
      System.out.print(tempNode.data + " ");
      if(tempNode.left != null) {
        queue.add(tempNode.left);
      }
      if(tempNode.right != null) {
        queue.add(tempNode.right);
      }
    }
  }

  public static Node insert(Node root, int data) {
    if (root == null) {
      return new Node(data);
    } else {
      Node cur;
      if (data <= root.data) {
        cur = insert(root.left, data);
        root.left = cur;
      } else {
        cur = insert(root.right, data);
        root.right = cur;
      }
      return root;
    }
  }

  public static void main(String[] args) {
    // test System.in
    // input: 6 1 2 5 3 6 4
    // ans: 1 2 5 3 6 4
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    Node root = null;
    while (t-- > 0) {
      int data = scan.nextInt();
      root = insert(root, data);
    }
    scan.close();
    levelOrder(root);
  }
}
