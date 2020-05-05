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
class Height{
  Node root;
  Height(){
    root = null;
  }

    //Function to calculate the height => the nuo: of nodes from the root to the deepest leaf of the BT
  int height(Node root){
      //Check if the BT is empty
      if(root == null){
        return 0;
      }else{
        int lheight = height(root.left);
        int rheight = height(root.right);

        if(lheight > rheight){
          return (lheight + 1);
        }else{
          return (rheight + 1);
        }
      }
    }

  public static void main(String args[]){
    //Reference object for the BT
    Height tree = new Height();
    //Create the BT
    tree.root = new Node(1);
    tree.root.left = new Node(2);
    tree.root.right = new Node(3);
    tree.root.left.left = new Node(4);
    tree.root.left.right = new Node(5);

    //BFS traversal of the BT
    System.out.println("Height of the tree : "+tree.height(tree.root)); 
  }
}
