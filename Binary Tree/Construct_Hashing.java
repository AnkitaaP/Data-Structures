//This approach takes a time complexity of 
// T(n) = O(n)
//Since using Has map reduces the search time to just O(1)
//Class to initialize nodes of the BT
import java.util.*;
class Node{
  char key;
  Node right, left;
//Constructor initializing nodes of the BT once created
  Node(char key){
    this.key = key;
    left=right=null;
  }
}
class Construct_Hashing{
  Node root;
  Construct_Hashing(){
    root = null;
  }
  static int preIndex = 0;
  //Function to construct the BT by parsing through the inorder and preorder traversal
  Node buildTree(char in[], char pre[], int inStart, int inEnd, HashMap<Character, Integer> mp){
    if(inStart > inEnd){
      return null;
    }

    Node tnode = new Node(pre[preIndex++]);
    //Check if BT has only one node
    if(inStart == inEnd){
      return tnode;
    }

    int inIndex = mp.get(tnode.key);

    //Using the index of inorder traversal to construct the left and right subtree of the current node
    tnode.left = buildTree(in, pre, inStart, inIndex-1, mp);
    tnode.right = buildTree(in, pre, inIndex+1, inEnd, mp);

    return tnode;
  }

  //Function to create hashmap of the inorder traversal and a wrapper function to the buildTree function
  Node buildTree(char in[], char pre[], int len){
    //Construct hashmap for the inorder traversal
    HashMap<Character, Integer> mp = new HashMap<Character, Integer>();
    //Set the character or data item of the node as key and its index as the value in the hash map
    for(int i=0; i<len; i++){
      mp.put(in[i], i);
    }

    return buildTree(in, pre, 0, len-1, mp);
  }

  //Function to print the inorder traversal of the constructed tree
  void printInorder(Node node){
    //Check if the BT is empty
    if(node == null){
      return;
    }

    printInorder(node.left);

    System.out.print(node.key + "\t");

    printInorder(node.right);
  }

  public static void main(String args[]){
    //Reference object for the BT
    Construct_Hashing tree = new Construct_Hashing();
    char in[] = new char[] { 'D', 'B', 'E', 'A', 'F', 'C' };
    char pre[] = new char[] { 'A', 'B', 'D', 'E', 'C', 'F' }; 
    int len = in.length;

    Node root = tree.buildTree(in, pre, len);

    System.out.println("Inorder traversal of the constructed tree : ");
    tree.printInorder(root);
  }
}

