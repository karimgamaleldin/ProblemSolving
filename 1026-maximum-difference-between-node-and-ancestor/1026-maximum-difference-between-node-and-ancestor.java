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
    public void helper(TreeNode root , int max , int min){
        if(root == null) return;
        int pmax = Math.abs(max - root.val);
        int pmin = Math.abs(min - root.val);
        r = Math.max(r , Math.max(pmax , pmin));
        int newMax = Math.max(max , root.val);
        int newMin = Math.min(min , root.val);
        helper(root.right , newMax , newMin);
        helper(root.left , newMax , newMin);
    }
}