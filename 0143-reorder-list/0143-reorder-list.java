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
class Solution {
    public void reorderList(ListNode head) {
        // Reverse solution:
        if(head.next == null) return;
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast!= null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode prev = null;
        ListNode curr = slow.next;
        slow.next = null;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        slow = head;
        while(prev != null){
            ListNode a = slow.next;
            ListNode b = prev.next;
            slow.next = prev;
            prev.next = a;
            slow = a;
            prev = b;
        }
        
        //Stack solution:
        // if(head.next == null) return;
        // ListNode fast = head.next;
        // ListNode slow = head;
        // while(fast!= null && fast.next != null){
        //     fast = fast.next.next;
        //     slow = slow.next;
        // }
        // Stack<ListNode> s = new Stack<>();
        // while(slow != null){
        //     s.push(slow);
        //     slow = slow.next;
        // }
        // slow = head;
        // while(!s.isEmpty()){
        //     ListNode temp = s.pop();
        //     temp.next = slow.next;
        //     slow.next = temp;
        //     slow = slow.next.next;
        // }
        // slow.next = null;
    }
}