/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode curr = node;
        while(node.next != null){
            node.val = node.next.val;
            curr = node;
            node = node.next;
        }
        curr.next = null;
    }
}