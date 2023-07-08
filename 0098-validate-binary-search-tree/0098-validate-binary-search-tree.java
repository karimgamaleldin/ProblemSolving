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
    public boolean isValidBST(TreeNode root) {
        return helper(root.left , Long.MIN_VALUE , root.val) && helper(root.right , root.val , Long.MAX_VALUE);
    }
    public boolean helper(TreeNode root , long min , long max){
        if(root == null) return true;
        if(root.val >= max || root.val <= min) return false;
        return helper(root.left , min , root.val) && helper(root.right , root.val , max);
    }
//     public boolean isValidBST(TreeNode root) {
//         List<Integer> l = new ArrayList<>();
//         helper(root , l);
//         for(int i = 0 ; i < l.size() - 1 ; i++){
//             if(l.get(i) >= l.get(i+1)) return false;
//         }
//         return true;
        
//     }
//     public void helper(TreeNode root , List<Integer> l){
//         if(root == null) return;
//         helper(root.left , l);
//         l.add(root.val);
//         helper(root.right , l);
//     }
}