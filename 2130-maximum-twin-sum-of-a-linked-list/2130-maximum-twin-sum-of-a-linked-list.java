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
    public int pairSum(ListNode head) {
        ListNode curr = head;
        int j = 0;
        while(curr != null){
            j++;
            curr = curr.next;
        }
        int max = Integer.MIN_VALUE ;
        int [] allResults = new int[j / 2];
        curr = head;
        int i = 0; 
        int k = j / 2 - 1;
        while(curr != null){
            if(i < j / 2){
                allResults[i] = curr.val;
                i++;
            }
            else{
                max = Math.max(max , allResults[k] + curr.val);
                k--;
            }
            curr = curr.next;
        }
        return max;
    }
}