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
    public int widthOfBinaryTree(TreeNode root) {
        LinkedList<Pair<TreeNode , Integer>> q = new LinkedList<>();
        q.addLast(new Pair<TreeNode , Integer>(root , 0));
        int maxWidth = 0;
        while(!q.isEmpty()){
            int s = q.size();
            int left =  q.getFirst().getValue();
            int right = left;
            for(int i = 0 ; i < s ; i++){
                Pair<TreeNode , Integer> curr = q.removeFirst();
                if(curr.getKey().left != null) q.addLast(new Pair<TreeNode,Integer>(curr.getKey().left , 2 * curr.getValue() + 1));
                if(curr.getKey().right != null) q.addLast(new Pair<TreeNode,Integer>(curr.getKey().right , 2 * curr.getValue() + 2));
                right = curr.getValue();
            }
            maxWidth = Math.max(right - left + 1 , maxWidth);
        }
        return maxWidth;   
    }
}