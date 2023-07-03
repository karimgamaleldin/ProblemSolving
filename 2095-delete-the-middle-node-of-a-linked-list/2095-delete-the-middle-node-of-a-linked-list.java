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
    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null) return null;
        int i = 0;
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            i+=2;
            fast = fast.next.next;
            if(fast != null) slow = slow.next;
        }
        if(fast != null && fast.next == null) i++;
        slow.next = slow.next.next;
        return head;
    }
}