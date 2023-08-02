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
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode curr = head;
        while(curr != null){
            count++;
            curr = curr.next;
        }
        count = count / k;
        ListNode dummy = new ListNode(0); // dummy
        ListNode start = dummy; // element before
        dummy.next = head;
        while(count-- != 0){
            ListNode x = start.next;
            curr = start.next;
            ListNode prev = null;
            int n = k;
            while(n-- != 0){
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            x.next = curr;
            start.next = prev;
            start = x;
        }
        return dummy.next;
    }
}