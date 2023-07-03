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
    public ListNode partition(ListNode head, int x) {
        Deque<ListNode> q1 = new ArrayDeque<ListNode>();
        Deque<ListNode> q2 = new ArrayDeque<ListNode>();
        ListNode curr = head;
        while(curr != null){
            if(curr.val < x) q1.offer(curr);
            else q2.offer(curr);
            curr = curr.next;
        }
        if(q1.size() == 0 || q2.size() == 0) return head;
        ListNode r = q1.poll();
        ListNode prev = r;
        curr = r;
        while(q1.size() > 0){
            curr.next = q1.poll();
            prev = curr;
            curr = curr.next;
        }
        while(q2.size() > 0){
            curr.next = q2.poll();
            curr = curr.next;
        }
        curr.next = null;
        return r;
    }
}