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
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> s = new Stack<Integer>();
        ListNode x = head;
        while(x != null ){
            s.push(x.val);
            x = x.next;
        }
        for(int i = 0 ; i < s.size() ; i++){
            if(s.pop() != head.val) return false;
            head = head.next;
        }
        return true;
        
    }
}