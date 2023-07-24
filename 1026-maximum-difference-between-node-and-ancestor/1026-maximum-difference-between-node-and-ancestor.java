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
    int r = - 1;
    public int maxAncestorDiff(TreeNode root) {
        helper(root , root.val , root.val);
        return r;
    }
    public void helper(TreeNode root , int max , int min){
        if(root == null) return;
        r = Math.max(r , Math.max(Math.abs(root.val - max) , Math.abs(root.val - min)));
        max = Math.max(root.val , max);
        min = Math.min(root.val , min);
        helper(root.left , max , min);
        helper(root.right , max , min);
    }
}