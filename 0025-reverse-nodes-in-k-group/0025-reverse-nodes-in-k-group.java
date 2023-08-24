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
        ListNode dummy = new ListNode();
        ListNode d = dummy;
        d.next = head;
        ListNode c = head;
        int size = 0;
        while(c != null){
            size++;
            c = c.next;
        }
        ListNode rev = head;
        int j = 0;
        while(j < size / k){
            ListNode curr = rev;
            ListNode prev = null;
            int i = k;
            while(i-- != 0){
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            rev.next = curr;
            d.next = prev;
            d = rev;
            rev = rev.next;
            j++;
        }
        return dummy.next;
    }
}