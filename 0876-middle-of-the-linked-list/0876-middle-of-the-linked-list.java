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
        ListNode curr = head;
        long i = 0;
        while(curr != null){
            curr = curr.next;
            i++;
        }
        i = i / 2;
        for(; i > 0 ; i--) head = head.next;
        return head;
    }
}