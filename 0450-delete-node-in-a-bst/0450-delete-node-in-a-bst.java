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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val == key) return helper(root);
        else if(root.val > key) root.left = deleteNode(root.left , key);
        else root.right = deleteNode(root.right , key);
        return root;
    }
    public TreeNode helper(TreeNode root){
        if(root.right == null && root.left == null) return null;
        if(root.right == null) return root.left; // safe to put the right instead of it
        if(root.left == null) return root.right; // safe to put the left instead of it
        TreeNode r = root.right;
        if(r.left == null) {
            r.left = root.left; // we insert the first node to the left
        } else { // if we loop
            TreeNode parent = root; 
            while(r.left != null) {
                parent = r;
                r = r.left;
            }
            parent.left = r.right;
            r.right = root.right;
            r.left = root.left;
        }
        return r; 
    }
}