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
        if(lists.length == 0) return null;
        ListNode r = lists[0];
        for(int i = 1 ; i < lists.length ; i++){
            r = mergeTwoLists(r , lists[i]);
        }
        return r;
        
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null) return null;
        else if(list1 == null) return list2;
        else if(list2 == null) return list1;
        ListNode a = list1;
        ListNode b = list2;
        boolean f; 
        ListNode head = null;
        if(a.val <= b.val){
            head = a;
            a = a.next;
            f = true;
        }
        else{
            head = b;
            b = b.next;
            f = false;
        }
        while(a != null || b != null){
            int x = a != null ? a.val : Integer.MAX_VALUE;
            int y = b != null ? b.val : Integer.MAX_VALUE;
            if(x <= y){
                head.next = a;
                head = a;
                a = a.next;
            }
            else{
                head.next = b;
                head = b;
                b = b.next;
            }
        }
        return f ? list1 : list2;
    }
}