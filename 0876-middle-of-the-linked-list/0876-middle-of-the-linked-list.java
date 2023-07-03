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
    public ListNode middleNode(ListNode head) {
        if(head == null) return null;
        ListNode fast = head.next;
        ListNode slow = head;
        int i = 1;
        while(fast != null && fast.next != null){
            i+=2;
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast != null && fast.next == null) i++;
        if(i%2 == 0) return slow.next;
        return slow;
        // ListNode curr = head;
        // long i = 0;
        // while(curr != null){
        //     curr = curr.next;
        //     i++;
        // }
        // i = i / 2;
        // for(; i > 0 ; i--) head = head.next;
        // return head;
    }
}