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
    public ListNode reverseBetween(ListNode head, int left, int right){
        ListNode dummy = new ListNode(0 , head);
        ListNode curr = dummy;
        int i = 1;
        while(curr != null){
            if(i == left){
                ListNode prev = null;
                ListNode curr2 = curr.next;
                ListNode end = curr2;
                ListNode temp = null;
                while(i <= right){
                    i++;
                    temp = curr2.next;
                    curr2.next = prev;
                    prev = curr2;
                    curr2 = temp;
                }
                curr.next = prev;
                end.next = temp;
                break;
            }
            else{
                curr = curr.next;
                i++;
            }
        }
        return dummy.next;
    }
}