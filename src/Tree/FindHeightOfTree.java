package Tree;

import java.util.Scanner;

class FindHeightOfTree {
  public static int height(Node root) {
    if (root == null) {
      return -1;
    }
    int maxLeftHeight = height(root.left);
    int maxRightHeight = height(root.right);

    if (maxLeftHeight > maxRightHeight) {
      return maxLeftHeight + 1;
    } else {
      return maxRightHeight + 1;
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
    // input: 7 3 2 1 5 4 6 7
    // ans: 3
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    Node root = null;
    while (t-- > 0) {
      int data = scan.nextInt();
      root = insert(root, data);
    }
    scan.close();
    int height = height(root);
    System.out.println(height);
  }
}
