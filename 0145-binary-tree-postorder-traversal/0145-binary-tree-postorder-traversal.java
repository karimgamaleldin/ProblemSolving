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
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> x = new ArrayList<>();
        helper(root , x);
        return x;
    }
     public void helper(TreeNode root , ArrayList<Integer> x){
        if(root == null) return;
        else {
            helper(root.left , x);
            helper(root.right,x);
            x.add(root.val);
        }
     }
    
}