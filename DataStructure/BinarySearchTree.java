package DataStructure;

public class BinarySearchTree {
  Node root;

  public BinarySearchTree() {
    this.root = null;
  }

  public class Node {
    int data;
    Node left, right;

    public Node(int data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }
  }

  // insert new node
  public void insert(int data) {
    this.root = insertNode(this.root, data);
  }

  public Node insertNode(Node root, int data) {
    // Return new node when root is null
    if (root == null) {
      root = new Node(data);
      return root;
    }

    // Traverse to the right spot to insert new node
    if (data < root.data) {
      root.left = insertNode(root.left, data);
    } else if (data > root.data) {
      root.right = insertNode(root.right, data);
    }

    return root;
  }

  // print in-order
  public void printInOrder() {
    System.out.println("Print in-order:");
    inOrderRec(this.root);
  }

  public void inOrderRec(Node root) {
    if (root != null) {
      inOrderRec(root.left);
      System.out.print(root.data + " -> ");
      inOrderRec(root.right);
    }
  }

  // print pre-order
  public void printPreOrder() {
    System.out.println("Print pre-order:");
    preOrderRec(this.root);
  }

  public void preOrderRec(Node root) {
    if (root != null) {
      System.out.print(root.data + " -> ");
      inOrderRec(root.left);
      inOrderRec(root.right);
    }
  }

  // print post-order
  public void printPostOrder() {
    System.out.println("Print pre-order:");
    postOrderRec(this.root);
  }

  public void postOrderRec(Node root) {
    if (root != null) {
      postOrderRec(root.left);
      postOrderRec(root.right);
      System.out.print(root.data + " -> ");
    }
  }

  public static void main(String[] args) {
    BinarySearchTree tree = new BinarySearchTree();

    tree.insert(8);
    tree.insert(3);
    tree.insert(1);
    tree.insert(6);
    tree.insert(7);
    tree.insert(10);
    tree.insert(14);
    tree.insert(4);

    tree.printInOrder();
    System.out.println();

    tree.printPreOrder();
    System.out.println();

    tree.printPostOrder();
    System.out.println();
  }
}
