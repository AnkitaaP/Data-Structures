class Insertion{
  static class Node{
    int data;
    Node next;
  };

  static Node insertStart(Node head_ref, int new_data){
    Node ptr1 = new Node();
    Node temp = head_ref;
    ptr1.data = new_data;
    ptr1.next = head_ref;

    if(head_ref != null){
      while(temp.next != head_ref){
        temp = temp.next;
      }
      temp.next = ptr1;
    }else{
      ptr1.next = ptr1;
    }

    head_ref = ptr1;
    return head_ref;
  }

  static void displayList(Node head){
    Node temp = head;
    if(head != null){
      do{
        System.out.print(temp.data+"\t");
        temp = temp.next;
      }while(temp != head);
    }
    System.out.println();
  }

  public static void main(String args[]){
    Node head = null;

    head = insertStart(head, 12);
    head = insertStart(head, 56);
    head = insertStart(head, 2);
    head = insertStart(head, 22);

    System.out.println("List created : ");
    displayList(head);
  }
}