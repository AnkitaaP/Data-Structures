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
class PalindromeList {
    static ListNode second_half,slow_ptr,fast_ptr;
    
     void reverse() 
    { 
        ListNode prev = null; 
        ListNode current = second_half; 
        ListNode next; 
        while (current != null) { 
            next = current.next; 
            current.next = prev; 
            prev = current; 
            current = next; 
        } 
        second_half = prev; 
    } 
  
    
    boolean compareLists(ListNode head1, ListNode head2) 
    { 
        ListNode temp1 = head1; 
        ListNode temp2 = head2; 
  
        while (temp1 != null && temp2 != null) { 
            if (temp1.val == temp2.val) { 
                temp1 = temp1.next; 
                temp2 = temp2.next; 
            } 
            else
                return false; 
        } 
  
        
        if (temp1 == null && temp2 == null) 
            return true; 
        
        return false; 
    } 
  
    
    public boolean isPalindrome(ListNode head) {
        slow_ptr = head; 
        fast_ptr = head; 
        ListNode prev_of_slow_ptr = head; 
        ListNode midnode = null;  
        boolean res = true;  
  
        if (head != null && head.next != null) { 
            
            while (fast_ptr != null && fast_ptr.next != null) { 
                fast_ptr = fast_ptr.next.next; 
  
                
                prev_of_slow_ptr = slow_ptr; 
                slow_ptr = slow_ptr.next; 
            } 
  
            
            if (fast_ptr != null) { 
                midnode = slow_ptr; 
                slow_ptr = slow_ptr.next; 
            } 
  
             
            second_half = slow_ptr; 
            prev_of_slow_ptr.next = null; 
            reverse(); 
            res = compareLists(head, second_half); 
            reverse(); 
            if (midnode != null) { 
                
                prev_of_slow_ptr.next = midnode; 
                midnode.next = second_half; 
            } 
            else
                prev_of_slow_ptr.next = second_half; 
        } 
        return res; 
        
    }
}