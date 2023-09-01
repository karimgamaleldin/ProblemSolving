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
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(-5001, head);
        ListNode prev = head;
        ListNode curr = head.next;
        while(curr != null){
            ListNode t = dummy;
            boolean f = true;
            while(t != curr){
                if(curr.val < t.next.val){
                    prev.next = prev.next.next;
                    curr.next = t.next;
                    t.next = curr;
                    curr = prev.next;
                    f = false;
                    break;
                }
                t = t.next;
            }
            if(f){
                prev = curr;
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}