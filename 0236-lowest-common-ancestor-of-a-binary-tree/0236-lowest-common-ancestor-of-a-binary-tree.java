/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null; //case when we finish a branch
        if(root == p || root == q) return root; // cases if we find one of the node then it is for sure the root and the lca
        TreeNode right = lowestCommonAncestor(root.right , p , q);
        TreeNode left = lowestCommonAncestor(root.left , p , q);
        if(left != null && right != null) return root; // we found the root as one to the left and one to the right
        if(left == null) return right; //  both are to the right
        return left;
    }
}