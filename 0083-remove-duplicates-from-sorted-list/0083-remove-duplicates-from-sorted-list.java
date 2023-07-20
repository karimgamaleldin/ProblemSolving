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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while(curr != null){
            ListNode fast = curr;
            while(fast != null && fast.val == curr.val){
                fast = fast.next;
            }
            curr.next = fast;
            curr = curr.next;
        }
        return head;
    }
}