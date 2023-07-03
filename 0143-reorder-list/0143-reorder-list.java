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
    public void reorderList(ListNode head) {
        if(head.next == null) return;
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast!= null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        Stack<ListNode> s = new Stack<>();
        while(slow != null){
            s.push(slow);
            slow = slow.next;
        }
        slow = head;
        while(!s.isEmpty()){
            ListNode temp = s.pop();
            temp.next = slow.next;
            slow.next = temp;
            slow = slow.next.next;
        }
        slow.next = null;
    }
}