package DataStructure;

public class SinglyLinkedList {
  Node head;

  public class Node {
    Node next;
    int data;

    // constructor
    public Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  // add node to end
  public void append(int data) {
    if (this.head == null) {
      this.head = new Node(data);
      return;
    }

    Node current = this.head;
    while (current.next != null) {
      current = current.next;
    }
    current.next = new Node(data);
  }

  // add node to start
  public void prepend(int data) {
    Node newHead = new Node(data);
    newHead.next = this.head;
    this.head = newHead;
  }

  // add node after
  public void insertAfter(int insertAfter, int data) {
    Node current = this.head;

    while (current != null) {
      if (current.data == insertAfter) {
        Node newNode = new Node(data);
        newNode.next = current.next;
        current.next = newNode;
        break;
      }
      current = current.next;
    }

  }

  // delete with value
  public void deleteWithValue(int data) {
    // when there's no head
    if (this.head == null) {
      return;
    }

    // when head is to be deleted
    if (this.head.data == data) {
      this.head = this.head.next;
      return;
    }

    // regular case
    Node current = this.head;
    while (current.next != null) {
      if (current.next.data == data) {
        current.next = current.next.next;
        return;
      }

      current = current.next;
    }
  }

  // print node
  public void printList() {
    Node current = this.head;
    while (current != null) {
      System.out.print(current.data + " -> ");
      current = current.next;
    }
  }

  // find a node
  public boolean search(int target) {
    Node current = this.head;
    while (current != null) {
      if (current.data == target) {
        return true;
      }
      current = current.next;
    }

    return false;
  }

  public static void main(String[] args) {
    SinglyLinkedList singlyList = new SinglyLinkedList();

    singlyList.append(1);
    singlyList.prepend(2);
    singlyList.append(5);
    singlyList.insertAfter(5, 10);

    System.out.println("Linked list: ");
    singlyList.printList();
  }

}
