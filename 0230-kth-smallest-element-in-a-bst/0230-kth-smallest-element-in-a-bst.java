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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> l= new ArrayList<>();
        helper(root , l);
        return l.get(k - 1);
    }
    public void helper(TreeNode root , List<Integer> l){
        if(root == null) return;
        helper(root.left , l);
        l.add(root.val);
        helper(root.right , l);
    }
}