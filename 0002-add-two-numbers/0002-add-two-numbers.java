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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        int carry = 0;
        while(l1 != null || l2 != null){
            int x = 0;
            int y = 0;
            if(l1 != null){
                x = l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                y = l2.val;
                l2 = l2.next;
            }
            int sol = carry + x + y;
            curr.next = new ListNode(sol % 10);
            carry = sol / 10;
            curr = curr.next;
        }
        if(carry != 0) curr.next = new ListNode(carry);
        return dummy.next;
    }
}