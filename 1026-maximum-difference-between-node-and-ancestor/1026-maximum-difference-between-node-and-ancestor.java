/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int r = 0;
    public int maxAncestorDiff(TreeNode root) {
        helper(root , root.val , root.val);
        return r;
    }
    public void helper(TreeNode root , int max , int min){ // max and min value hold the max and min value passed until now
        if(root == null) return; // base case
        int pmax = Math.abs(max - root.val); // the difference between max and root value
        int pmin = Math.abs(min - root.val); // the difference between min and root value
        r = Math.max(r , Math.max(pmax , pmin)); //updating r
        int newMax = Math.max(max , root.val); // getting the new value of max 
        int newMin = Math.min(min , root.val); // getting the new value of min
        helper(root.right , newMax , newMin); // rec call
        helper(root.left , newMax , newMin); // rec call
    }
}