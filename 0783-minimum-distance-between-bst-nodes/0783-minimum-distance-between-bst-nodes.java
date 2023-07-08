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
    public int minDiffInBST(TreeNode root) {
        List<Integer> l = new LinkedList<>();
        helper(root , l);
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < l.size() - 1 ; i++) min = Math.min(min , l.get(i+1) - l.get(i));
        return min;
    }
    public void helper(TreeNode root , List<Integer> l){
        if(root == null) return;
        helper(root.left , l);
        l.add(root.val);
        helper(root.right , l);
    }
}