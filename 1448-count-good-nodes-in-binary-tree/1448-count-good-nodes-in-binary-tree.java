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
    public int helper(TreeNode node , int max){
        if(node == null) return 0;
        else if(node.val >= max){
            return 1 + helper(node.right , node.val) + helper(node.left , node.val);
        }
        return helper(node.right , max) + helper(node.left , max);
    }
}