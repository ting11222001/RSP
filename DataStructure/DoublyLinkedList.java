package DataStructure;

/**
 * DoublyLinkedList: doubly linked list/ add node to end/ add node to start/
 * delete node after/ print
 */

public class DoublyLinkedList {
  Node head;

  public DoublyLinkedList() {
    this.head = null;
  }

  public class Node {
    Node next;
    Node prev;
    int data;

    // constructor
    public Node(int data) {
      this.data = data;
      this.next = null;
      this.prev = null;
    }
  }

  // add node to end
  public void append(int data) {
    Node newNode = new Node(data);

    if (this.head == null) {
      this.head = newNode;
      return;
    }

    Node current = this.head;
    while (current.next != null) {
      current = current.next;
    }
    current.next = newNode;
    newNode.prev = current;
  }

  // add node to start
  public void prepend(int data) {
    Node newNode = new Node(data);

    if (this.head == null) {
      this.head = newNode;
      return;
    }

    newNode.next = this.head;
    this.head.prev = newNode;
    this.head = newNode;
  }

  // delete node after
  public void deleteAfter(int data) {
    Node current = this.head;
    while (current != null) {
      if (current.data == data) {
        current = current.next;
        break;
      }
      current = current.next;
    }

    if (current != null) {
      if (current.next != null) {
        current.next.prev = current.prev;
      }

      current.prev.next = current.next;
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

  public static void main(String[] args) {
    DoublyLinkedList doublyList = new DoublyLinkedList();

    doublyList.append(1);
    doublyList.append(9);
    doublyList.prepend(6);

    System.out.println("Doubly Linked list: ");
    doublyList.printList();
    System.out.println();

    System.out.println("Delete After: ");
    doublyList.deleteAfter(6);
    System.out.println("Result: ");
    doublyList.printList();
    System.out.println();
  }

}
