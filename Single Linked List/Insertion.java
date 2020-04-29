import java.util.*;
class Insertion{
  //Object for the head or starting node
  Node head;
  static class Node{
    //Integer variable containing data of the node
    int data;
    //Object for the next node;
    Node next;
    //Constructor to initialise a node when craeted
    Node(int data){
      this.data=data;
      this.next=null;
    }
  }
  //Function to insert node at the start of SLL
  public void insertStart(int new_data){
    //Create the new node
    Node new_node = new Node(new_data);
    //Adjust the position of the node at start
    new_node.next = head;
    head = new_node;
  }
  //Function to insert node after a given node in SLL
  public void insertAfter(Node prev_node, int new_data){
    //Check for presence of new node
    if(prev_node == null){
      System.out.println("Previous node cannot be null");
      return;
    }
    //Adjust the position of the new node at the given position
    Node new_node = new Node(new_data);
    new_node.next = prev_node.next;
    prev_node.next = new_node;
  }
  //Function to insert a node at the end of SLL
  public void insertEnd(int new_data){
    Node new_node = new Node(new_data);
    //Check whether SLL is empty
    if(head == null){
      head = new Node(new_data);
      return;
    }
    //Since node is added last there wont be any next 
    new_node.next = null;
    //Initialise to find the last node
    Node last_node = head;
    //Traverse till the end of the SLL
    while(last_node.next != null){
      last_node = last_node.next;
    }
    //Adjust the position of the new node
    last_node.next = new_node;
    return;
  }
  //Function to display the SLL
  public void displayList(){
    Node tnode = head;
    while(tnode != null){
      System.out.println(tnode.data+"\t");
      tnode = tnode.next;
    }
  }

  //Main function to start the program
  public static void main(String args[]){

    //Create an empty List
    Insertion llist = new Insertion();
    //List becomes 6->null
    llist.insertEnd(6);
    //List becomes 1->7->6->null
    llist.insertStart(7);
    llist.insertStart(1);
    //List becomes 1->7->6->4->null
    llist.insertEnd(4);
    //List becomes 1->7->8->6->4->null
    llist.insertAfter(llist.head.next, 8);

    System.out.println(" Single Linked List : \n");
    llist.displayList();


  }
}