//Class to initialize nodes of the BT
class Node{
  int key;
  Node right, left;
//Constructor initializing nodes of the BT once created
  Node(int key){
    this.key = key;
    left=right=null;
  }
}
class BT_Traversal{
  Node root;
  BT_Traversal(){
    root = null;
  }

  //Function performs postorder traversal of the tree
  void printPostorder(Node node){
    //Check if BT is empty
    if(node == null){
      return;
    }
    //Recur to the leftmost node
    printPostorder(node.left);
    //Recur to the rightmost node
    printPostorder(node.right);

    System.out.print(node.key+"\t");
  }

  //Function performs Inorder traversal on the BT
  void printInorder(Node node){
    //Check if BT is empty
    if(node == null){
      return;
    }

    //Recur to the leftmost node
    printInorder(node.left);
    
    System.out.print(node.key + "\t");

    //Recur to the rightmost node
    printInorder(node.right);
  }

  //Function performs preorder traversal on the BT
  void printPreorder(Node node){
    //Check if the BT is empty
    if(node == null){
      return;
    }

    System.out.print(node.key + "\t");

    //Recur to the leftmost node
    printPreorder(node.left);
    //Recur to the rightmost node
    printPreorder(node.right);
  }

  void printPostorder(){ printPostorder(root);}
  void printPreorder(){printPreorder(root);}
  void printInorder(){printInorder(root);}

  public static void main(String args[]){
    //Reference object for the BT
    BT_Traversal tree = new BT_Traversal();
    //Create the BT
    tree.root = new Node(1);
    tree.root.left = new Node(2);
    tree.root.right = new Node(3);
    tree.root.left.left = new Node(4);
    tree.root.left.right = new Node(5);

    //Tree traversals
    System.out.println("Preorder traversal : ");
    tree.printPreorder();
    System.out.println();

    System.out.println("Inorder traversal : ");
    tree.printInorder();
    System.out.println();

    System.out.println("Postorder traversal : ");
    tree.printPostorder();

  }
}
