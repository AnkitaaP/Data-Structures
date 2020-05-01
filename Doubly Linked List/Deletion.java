class Deletion {
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

  //Function to delete node
  public void deleteNode(Node del){
    //Check if head or node to be deleted is null
    if(head == null || del == null){
      return;
    }

    //Check if head is to be deleted
    if(head == del){
      head = del.next;
      
    }
    //Adjust the position of the next and the previous nodes
    if(del.next != null){
      del.next.prev = del.prev;
    }

    if(del.prev != null){
      del.prev.next = del.next;
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
    Deletion dll = new Deletion();

    dll.insertStart(2);
    dll.insertStart(4);
    dll.insertStart(8);
    dll.insertStart(10);

    System.out.println("List created : ");
    dll.displayList(dll.head);
    System.out.println();
    System.out.println("List after deleting node 10 : ");
    dll.deleteNode(dll.head);
    dll.displayList(dll.head);
  }
}