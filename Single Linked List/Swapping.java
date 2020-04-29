import java.util.*;
class Swapping{
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

  //Function to swap nodes without just swapping data
  public void swapNodes(int x, int y){
    //Both the keys are equal there is no point swapping them
     if(x==y){
       return;
     }
    //Objects for previous and current node for key 'x'
     Node prevX = null, curX = head;
    //Traverse till you get x
     while(curX != null && curX.data != x){
       prevX = curX;
       curX = curX.next;
     }
    //Objects for previous and current node for key 'y'
     Node prevY = null, curY = head;
    //Traverse till you get Y
     while(curY != null && curY.data != y){
       prevY = curY;
       curY = curY.next;
     }
    //Check if any one key is not in SLL
     if(curX == null || curY == null){
       return;
     }
    //Check if 'x' is not the head
    //Adjust the previous nodes reference
     if(prevX != null){
       prevX.next = curY;
     }else{
       head = curY;
     }
    //Check if 'y' is not the head
    //Adjust the prev nodes reference
     if(prevY != null){
       prevY.next = curX;
     }else{
       head = curX;
     }
    //Adjust the current nodes reference
     Node temp = curX.next;
     curX.next = curY.next;
     curY.next = temp;
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
    Swapping llist = new Swapping();
;
    //List becomes 1->2->3->4->5->6->7
        llist.insertStart(7); 
        llist.insertStart(6); 
        llist.insertStart(5); 
        llist.insertStart(4); 
        llist.insertStart(3); 
        llist.insertStart(2); 
        llist.insertStart(1); 


    System.out.println(" Single Linked List : ");
    llist.displayList();
    System.out.println("\n");

    System.out.println("Swapping 4 and 3 : ");
    llist.swapNodes(4,3);

    System.out.println("New Linked List : ");
    llist.displayList();
    System.out.println("\n");

    
  }
}