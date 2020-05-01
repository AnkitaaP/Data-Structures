import java.awt.SystemColor;

class Reverse {
  Node head;
  // Class to initiaise the node with next and previous reference objects

  /* Doubly Linked list Node */
  class Node {
    int data;
    Node prev;
    Node next;

    // Constructor to create a new node
    // next and prev is by default initialized as null
    Node(int data) {
      this.data = data;
    }
  }

  // Function to insert at the begining
  public void insertStart(int new_data) {
    // Initiaise the new node
    Node new_Node = new Node(new_data);

    // Make next of new node as head and previous as NULL
    new_Node.next = head;
    new_Node.prev = null;

    // change prev of head node to new node
    if (head != null)
      head.prev = new_Node;

    // move the head to point to the new node
    head = new_Node;
  }

  // Function to reverse the DLL
  public void reverseList() {
    Node temp = null;
    Node current = head;

    while (current != null) {
      temp = current.prev;
      current.prev = current.next;
      current.next = temp;
      current = current.prev;
    }
    // Check if DLL is empty
    if (temp != null) {
      head = temp.prev;
    }
  }

  // Function to display the list
  public void displayList(Node node) {
    Node last = null;
    System.out.println("Traversing the list in forward direction : ");
    while (node != null) {
      System.out.print(node.data + "\t");
      last = node;
      node = node.next;
    }
    System.out.println();
    System.out.println("Traversing in the backward direction : ");
    while (last != null) {
      System.out.print(last.data + "\t");
      last = last.prev;
    }
  }

  public static void main(String[] args) {
    Reverse dll = new Reverse();

    dll.insertStart(2);
    dll.insertStart(4);
    dll.insertStart(8);
    dll.insertStart(10);

    System.out.println("List created : ");
    dll.displayList(dll.head);
    System.out.println();

    System.out.println();
    System.out.println("List after reversing : ");
    dll.reverseList();
    dll.displayList(dll.head);
  }
}