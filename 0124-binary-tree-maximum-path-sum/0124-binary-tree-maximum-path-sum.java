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
    int sum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return sum;
    }
    public int helper(TreeNode root){
        if(root == null) return 0;
        int x = helper(root.right);
        int y = helper(root.left);
        x = x > 0 ? x : 0 ;
        y = y > 0 ? y : 0;
        sum = Math.max(sum, x + y + root.val);
        return Math.max(x + root.val , Math.max(y + root.val , root.val));
    }
}