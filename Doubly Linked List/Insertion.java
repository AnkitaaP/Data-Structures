class Insertion {
  Node head;
  //Class to initiaise the node with next and previous reference objects
  
    /* Doubly Linked list Node*/
    class Node { 
        int data; 
        Node prev; 
        Node next; 
  
        // Constructor to create a new node 
        // next and prev is by default initialized as null 
        Node(int data) { this.data = data; } 
    } 

  //Function to insert at the begining
  public void insertStart(int new_data){
    //Initiaise the new node
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

  //Function to insert at the end
  public void insertEnd(int new_data){
    //Initialise new node
    Node new_node = new Node(new_data);
    //Initialise object reference for last node
    Node last = head;
    new_node.next = null;
    //Check if DLL is empty
    if(head == null){
      new_node.prev = null;
      head = new_node;
      return;
    }

    while(last.next != null){
      last = last.next;
    }
    //Adjust the new node position
    last.next = new_node;
    new_node.prev = last;
  }

  //Function to insert new node after a given node
  public void insertAfter(Node prev_node, int new_data){
    //Check if previous node is null
    if(prev_node == null){
      System.out.println("The previous node cannot be null");
      return;
    }
    //Initialise the new node
    Node new_node = new Node(new_data);
    //Adjust the position of the new Node
    new_node.next = prev_node.next;
    prev_node.next = new_node;
    new_node.prev = prev_node;

    if(new_node.next != null){
      new_node.next.prev = new_node;
    }
  }

  //Function to display the list
  public void displayList(Node node){
    Node last = null;
    System.out.println("Traversing the list in forward direction : ");
    while(node != null){
      System.out.print(node.data+"\t");
      last = node;
      node = node.next;
    }
    System.out.println();
    System.out.println("Traversing in the backward direction : ");
    while(last != null){
      System.out.print(last.data+"\t");
      last = last.prev;
    }
  }
  public static void main(String[] args) {
    Insertion dll = new Insertion();

    dll.insertEnd(6);
    dll.insertStart(7);
    dll.insertStart(1);
    dll.insertEnd(4);

    dll.insertAfter(dll.head.next, 8);

    System.out.println("List contains : ");
    dll.displayList(dll.head);
  }
}