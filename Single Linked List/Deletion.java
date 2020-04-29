import java.util.*;
class Deletion{
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

  //Function to delete a node based on the data of the node
  public void deleteNodeByData(int key){
    //Initialise a node at the start and a previous node
    Node temp = head, prev = null;
    //Cj=heck if head has to be deleted
    if(temp != null && temp.data == key){
      head = temp.next;
      return;
    }
    //Node other than head has to deleted so traverse the SLL
    while(temp != null && temp.data != key){
      //Keep track of previous node
      prev = temp;
      temp = temp.next;
    }
    //Check if node was not found with the given key
    if(temp == null){
      return;
    }
    //Delete the node with given key if found by changing the reference of the previous node
    prev.next = temp.next;
  }

  //Function to delete a node based on the position of the node
  public void deleteNodeBYPosition(int position){
    //Check if SLL is empty
    if(head == null){
      return;
    }

    Node temp = head;
    //Check if head has to deleted
    if(position == 0){
      head = temp.next;
      return;
    }
    //Traverse the SLL till the preceding node of the position
    for(int i=0; i<position-1;i++){
      temp = temp.next;
    }
    //Check if the position is not there in the SLL
    if(temp == null || temp.next == null){
      return;
    }
    //Initialise the reference to the next node after deletion
    Node next = temp.next.next;
    //delete the node
    temp.next = next;
  }

  //Function to insert node at the start of SLL
  public void insertStart(int new_data){
    //Create the new node
    Node new_node = new Node(new_data);
    //Adjust the position of the node at start
    new_node.next = head;
    head = new_node;
  }

  //Function to display the SLL
  public void displayList(){
    Node tnode = head;
    while(tnode != null){
      System.out.print(tnode.data+"\t");
      tnode = tnode.next;
    }
  }

  //Main function to start the program
  public static void main(String args[]){

    //Create an empty List
    Deletion llist = new Deletion();
;
    //List becomes 1->7->6->null
    llist.insertStart(7);
    llist.insertStart(1);
    llist.insertStart(3);
    llist.insertStart(2);


    System.out.println(" Single Linked List : ");
    llist.displayList();
    System.out.println("\n");

    System.out.println("Deleting Node with data 1 : ");
    llist.deleteNodeByData(1);

    System.out.println();

    System.out.println("New Linked List : ");
    llist.displayList();
    System.out.println("\n");

    System.out.println("Deleting Node with position 2 : ");
    llist.deleteNodeBYPositon(1);

    System.out.println();

    System.out.println("New Linked List : ");
    llist.displayList();
  }
}