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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> r = new LinkedList<>();
        if(root == null) return r;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean leftToRight = false;
        while(!q.isEmpty()){
            List<Integer> t = new LinkedList<>();
            int s = q.size();
            LinkedList<TreeNode> q2 = new LinkedList<>();
            for(int i = 0 ; i < s ; i++){
                TreeNode curr = q.removeFirst();
                t.add(curr.val);
                if(!leftToRight){
                    if(curr.left != null) q2.addFirst(curr.left);
                    if(curr.right != null) q2.addFirst(curr.right);
                }
                else{
                    if(curr.right != null) q2.addFirst(curr.right);
                    if(curr.left != null) q2.addFirst(curr.left);
                }
                
            }
            leftToRight = !leftToRight;
            q = q2;
            r.add(t);
        }
        return r;
    }
}