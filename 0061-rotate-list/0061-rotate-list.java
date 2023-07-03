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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;
        ListNode slow = head;
        ListNode fast = head;
        for(int i = k ; i > 0 ; i--){
            if(fast.next != null) fast = fast.next;
            else fast = head;
        }
        if(fast == head) return head;
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        ListNode r = slow.next;
        slow.next = null;
        fast.next = head;
        
        return r;
    }
}