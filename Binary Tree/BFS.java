//This code has time complexity
// T(n) = O(n^2)

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
class BFS{
  Node root;
  BFS(){
    root = null;
  }

  //Function to print levelOrder traversal or BFS traversal of the BT
  void printLevelorder(){
    int h = height(root);
    for(int i=1; i<=h; i++){
      printGivenLevel(root, i);
    }
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

    //Fucnction to print nodes in a level
    void printGivenLevel(Node root, int level){
      //Check if BT is empty
      if(root == null){
        return;
      }
      else if (level == 1){
        System.out.print(root.key+"\t");
      }
      else if (level > 1){
        printGivenLevel(root.left, level-1);
        printGivenLevel(root.right, level-1);
      }
    } 

  public static void main(String args[]){
    //Reference object for the BT
    BFS tree = new BFS();
    //Create the BT
    tree.root = new Node(1);
    tree.root.left = new Node(2);
    tree.root.right = new Node(3);
    tree.root.left.left = new Node(4);
    tree.root.left.right = new Node(5);

    //BFS traversal of the BT
    System.out.println("Level Order traversal : ");
    tree.printLevelorder();

  }
}
