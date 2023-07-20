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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0 , head);
        ListNode prev = dummy;
        ListNode curr = head;
        while(curr != null && curr.next != null){
            ListNode temp = curr.next.next;
            ListNode temp2 = curr.next;
            curr.next.next = curr;
            curr.next = temp;
            prev.next = temp2;
            prev = curr;
            curr = temp;
            
        }
        return dummy.next;
    }
}