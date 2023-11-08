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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode head = dummy;
        while(list1 != null || list2 != null){
            int one = list1 != null ? list1.val : Integer.MAX_VALUE;
            int two = list2 != null ? list2.val : Integer.MAX_VALUE;
            if(one > two){
                head.next = list2;
                list2 = list2.next;
            }
            else {
                head.next = list1;
                list1 = list1.next;
            }
            head = head.next;
        }
        return dummy.next;
    }
}