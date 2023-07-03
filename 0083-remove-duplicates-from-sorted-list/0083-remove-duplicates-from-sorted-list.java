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
        if(head == null) return null;
        ListNode curr = head;
        int value = head.val;
        while(curr.next != null){
            if (curr.next.val != value){
                curr = curr.next;
                value = curr.val;
            }
            else{
                curr.next = curr.next.next;
            }
        }
        return head;
    }
}