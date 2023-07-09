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
    public boolean isCompleteTree(TreeNode root) {
        int level = 0;
        Queue<Pair<TreeNode , Integer>> q = new LinkedList<>();
        q.add(new Pair(root , 0));
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i < size ; i++){
                Pair<TreeNode , Integer> currNode = q.remove();
                if(currNode.getKey().left != null) q.add(new Pair(currNode.getKey().left , 2*currNode.getValue() + 1));
                if(currNode.getKey().right != null) q.add(new Pair(currNode.getKey().right , 2*currNode.getValue() + 2));
                if(!q.isEmpty() && currNode.getValue() + 1 != q.peek().getValue()) return false;
            }
            if(!q.isEmpty() && size != Math.pow(2,level)) return false;
            level++;
        }
        return true;
    }
}