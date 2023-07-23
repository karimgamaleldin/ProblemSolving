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
    public int goodNodes(TreeNode root) {
        return helper(root , Integer.MIN_VALUE);
    }
    public int helper(TreeNode root , int max){
        if(root == null) return 0;
        if(root.val >= max){
            return helper(root.left , root.val) + helper(root.right , root.val) + 1;
        }
        return helper(root.left , max) + helper(root.right , max);
    }
}