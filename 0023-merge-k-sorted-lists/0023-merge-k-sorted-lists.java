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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode l : lists) {
            if(l != null) pq.offer(l);
        }
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        while(!pq.isEmpty()){
            ListNode temp = pq.poll();
            curr.next = temp;
            temp = temp.next;
            if(temp != null) pq.offer(temp);
            curr = curr.next;
        }
        return dummy.next;
    }
}