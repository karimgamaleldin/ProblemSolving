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
    boolean f = true;
    public boolean isBalanced(TreeNode root) {
        helper(root);
        return f;
    }
    public int helper(TreeNode root){
        if(root == null) return 0;
        int left = helper(root.left) + 1;
        int right = helper(root.right) + 1;
        if(Math.abs(left - right) > 1) f = false;
        return Math.max(left , right);
    }
}