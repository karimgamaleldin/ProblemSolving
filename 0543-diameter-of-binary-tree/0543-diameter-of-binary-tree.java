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
    int r = -1;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return r;
    }
    public int helper(TreeNode root){
        if(root == null) return -1; //base case
        int left = 1 + helper(root.left); //longest path to the left
        int right = 1 + helper(root.right); //longest path to right
        r = Math.max(r , (left+right)); // update the longes diameter found 
        return Math.max(left , right); // return the longest path that passes through this node
    }
}