//This approach has a better time complexity
// T(n) = O(n)

//Class to initialize nodes of the BT
import java.util.*;
class Node{
  int key;
  Node right, left;
//Constructor initializing nodes of the BT once created
  Node(int key){
    this.key = key;
    left=right=null;
  }
}
class BFS_Queue{
  Node root;
  BFS_Queue(){
    root = null;
  }

  //Function to print Level order traversal by using a queue
  void printLevelorder(){
    Queue<Node> queue = new LinkedList<Node>();
    queue.add(root);
    while(! queue.isEmpty()){
      //Store the current head of the queue in a temporary node
      Node temp_node = queue.poll();
      System.out.print(temp_node.key + "\t");

      //Enqueue the left child of the root
      if(temp_node.left != null){
        queue.add(temp_node.left);
      }

      //Enqueue the right child of the BT
      if(temp_node.right != null){
        queue.add(temp_node.right);
      }
    }
  }
  public static void main(String args[]){
    //Reference object for the BT
    BFS_Queue tree = new BFS_Queue();
    //Create the BT
    tree.root = new Node(1);
    tree.root.left = new Node(2);
    tree.root.right = new Node(3);
    tree.root.left.left = new Node(4);
    tree.root.left.right = new Node(5);

    //BFS Traversal of the BT
    System.out.println("Level order traversal : ");
    tree.printLevelorder();
  }
}
