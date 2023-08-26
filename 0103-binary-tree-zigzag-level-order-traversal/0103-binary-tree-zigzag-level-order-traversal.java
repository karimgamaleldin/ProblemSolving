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
        boolean ltr = true;
        while(!q.isEmpty()){
            int size = q.size();
            LinkedList<Integer> next = new LinkedList<>();
            for(int i = 0 ; i < size ; i++){
                TreeNode t = q.removeFirst();
                if(ltr) next.addLast(t.val);
                else next.addFirst(t.val);
                if(t.left != null) q.add(t.left);
                if(t.right != null) q.add(t.right);
            }
            ltr = !ltr;
            r.add(next);
        }
        return r;
    }
}