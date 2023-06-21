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
        ListNode x = new ListNode(0);
        ListNode n = x;
        int carry = 0;
        while(l1 != null || l2 != null){
            int v = 0;
            if(l1 != null){
                v += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                v += l2.val;
                l2 = l2.next;
            }
            int num = (carry + v);
            n.next = new ListNode(num % 10);
            carry = num / 10;
            n = n.next;
        }
        if(carry > 0) n.next = new ListNode(carry);
        return x.next;
    }
}