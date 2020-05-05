//This approach takes a time complexity of 
// T(n) = O(n^2)
//Class to initialize nodes of the BT
class Node{
  char key;
  Node right, left;
//Constructor initializing nodes of the BT once created
  Node(char key){
    this.key = key;
    left=right=null;
  }
}
class Construct{
  Node root;
  Construct(){
    root = null;
  }
  static int preIndex = 0;
  //Function to construct the BT by parsing through the inorder and preorder traversal
  Node buildTree(char in[], char pre[], int inStart, int inEnd){
    if(inStart > inEnd){
      return null;
    }

    Node tnode = new Node(pre[preIndex++]);
    //Check if BT has only one node
    if(inStart == inEnd){
      return tnode;
    }

    int inIndex = search(in, inStart, inEnd, tnode.key);

    //Using the index of inorder traversal to construct the left and right subtree of the current node
    tnode.left = buildTree(in, pre, inStart, inIndex-1);
    tnode.right = buildTree(in, pre, inIndex+1, inEnd);

    return tnode;
  }

  //Function to search an element in the inorder traversal
  int search(char ar[], int start, int end, char key){
    int i=0;
    for(i=start; i<=end; i++){
      if(ar[i] == key){
        return i;
      }
    }
    return i;
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
    Construct tree = new Construct();
    char in[] = new char[] { 'D', 'B', 'E', 'A', 'F', 'C' };
    char pre[] = new char[] { 'A', 'B', 'D', 'E', 'C', 'F' }; 
    int len = in.length;

    Node root = tree.buildTree(in, pre, 0, len-1);

    System.out.println("Inorder traversal of the constructed tree : ");
    tree.printInorder(root);
  }
}

