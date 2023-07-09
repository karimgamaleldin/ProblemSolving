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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> r = new ArrayList<>();
        HashMap<String , ArrayList<String>> map = new HashMap<>();
        preOrder(root , map , r);
        return r;
    }
    public String preOrder(TreeNode root , HashMap<String , ArrayList<String>> map , List<TreeNode> r){
        if(root == null) return "N,";
        String s = root.val + "," + preOrder(root.left , map , r) + "," + preOrder(root.right , map , r);
        if(map.containsKey(s)){
            if(map.get(s).size() == 0){ // because i didnot add while creating so the comparison is 0
                r.add(root);
                map.get(s).add(s);
            }
        }else{
            map.put(s , new ArrayList<String>());
        }
        return s;
    }
}