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
    HashMap<TreeNode , TreeNode> map = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        dfs(root , null);
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> r = new LinkedList<>();
        HashSet<TreeNode> seen = new HashSet<>();
        q.add(target);
        seen.add(target);
        while(!q.isEmpty()){
            if(k-- == 0) break;
            int size = q.size();
            for(int i = 0 ; i < size ; i++){
                TreeNode temp = q.remove();
                TreeNode parent = map.get(temp);
                if(temp.left != null && !seen.contains(temp.left)){
                    q.add(temp.left);
                    seen.add(temp.left);
                }
                if(temp.right != null && !seen.contains(temp.right)){
                    q.add(temp.right);
                    seen.add(temp.right);
                }
                if(parent != null && !seen.contains(parent)){
                    q.add(parent);
                    seen.add(parent);
                }
            }

        }
        while(!q.isEmpty()){
            r.add(q.remove().val);
        }
        return r;
    }
    public void dfs(TreeNode root , TreeNode parent){
        if(root == null) return;
        map.put(root , parent);
        dfs(root.left , root);
        dfs(root.right , root);
    }
}