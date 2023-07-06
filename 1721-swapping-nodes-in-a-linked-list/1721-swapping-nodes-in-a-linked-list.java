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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode curr = head;
        ListNode end = head;
        int j = 1;
        ListNode first = null;
        while(j < k){
            j++;
            end = end.next;
        }
        first = end;
        while(end.next != null){
            curr = curr.next;
            end = end.next;
        }
        int temp = curr.val;
        curr.val = first.val;
        first.val = temp;
        return head;
    }
}