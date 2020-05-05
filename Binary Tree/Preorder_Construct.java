//Program constructs Preorder traversal for given Inorder and Postorder traversal

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
class Preorder_Construct{
  Node root;
  Preorder_Construct(){
    root = null;
  }
  static int postIndex;
  //Function to construct the BT by parsing through the inorder and preorder traversal
  void fillPre(int in[], int post[], int inStart, int inEnd, Stack<Integer> s){
    if(inStart > inEnd){
      return;
    }

    int value = post[postIndex--];
    int inIndex = search(in, inStart, inEnd, value);

    //Using the index of inorder traversal to construct the left and right subtree of the current node
    fillPre(in, post, inIndex+1, inEnd, s);
    fillPre(in, post, inStart, inIndex-1, s);

    s.push(value);
  }

  //Function that initialises the postIndex and wrapper function for fillPre function
  void fillPre(int in[], int post[]){
    int len = in.length;
    postIndex = len-1;
    Stack<Integer> s = new Stack<Integer>();
    fillPre(in, post, 0, len-1, s);
    while(! s.empty()){
      System.out.print(s.pop()+"\t");
    }
  }
  //Function to search an element in the inorder traversal
  int search(int ar[], int start, int end, int key){
    int i=0;
    for(i=start; i<=end; i++){
      if(ar[i] == key){
        return i;
      }
    }
    return i;
  }

  //

  public static void main(String args[]){
    //Reference object for the BT
    Preorder_Construct tree = new Preorder_Construct();
    int in[] = new int[]{ 4, 10, 12, 15, 18, 22, 24, 25, 31, 35, 44, 50, 66, 70, 90 };
    int post[] = new int[] { 4, 12, 10, 18, 24, 22, 15, 31, 44, 35, 66, 90, 70, 50, 25 }; 
    int len = in.length;

    System.out.println("Preorder traversal of the constructed tree : ");
    tree.fillPre(in, post);
  }
}

