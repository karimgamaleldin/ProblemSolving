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
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((a, b) -> {
            return a.val - b.val;
        });
        for(ListNode node : lists) if(node != null) pq.add(node);
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        while(!pq.isEmpty()){
            ListNode temp = pq.poll();
            curr.next = temp;
            if(temp.next != null) pq.add(temp.next);
            curr = curr.next;
        }
        return dummy.next;
    }
}