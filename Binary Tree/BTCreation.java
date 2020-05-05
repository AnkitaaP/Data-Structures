//Class to intialise a node of the tree
class Node{
  int key;
  Node left;
  Node right;
  //Constructor initializes a new node
  public Node(int key){
    this.key = key;
    right=left=null;
  }
}
class BTCreation {
  //Denotes the root node of the BT
  Node root;
  BinaryTree(int key){
    root = new Node(key);
  }
  BTCreation(){
    root = null;
  }
  //Main driver function which creats a BT with 5 nodes
  public static void main(String[] args) {
    BTCreation tree = new BTCreation();
    tree.root = new Node(1);

    tree.root.left = new Node(2);
    tree.root.right = new Node(3);

    tree.root.left.left = new Node(4);
    tree.root.left.right = new Node(5); 

    /* The tree finally becomes
                  1
                /   \
              2       3
            /   \    
          4       5

    */
  }
}