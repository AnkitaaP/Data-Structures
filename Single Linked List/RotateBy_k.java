/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class RatateBy_k {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null){
            return head;
        }
        ListNode current=head,tail=null;
        int len=0;
        while(current!=null){
            if(current.next==null){
                tail=current;
            }
            len+=1;
            current=current.next;
        }
        
        if(len==1){
            return head;
        }
        if(len==0){
            return head;
        }
        k=k%len;
        int var=len-k;
        current=head;
        while(--var>0){
            current=current.next;
        }
        
        tail.next=head;
        head=current.next;
        current.next=null;
        return head;
    }
}