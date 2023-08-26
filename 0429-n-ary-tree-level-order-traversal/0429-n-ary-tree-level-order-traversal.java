/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new LinkedList<>();
        if(root == null) return ans;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> t = new LinkedList<>();
            for(int i = 0 ; i < size ; i++){
                Node temp = q.remove();
                List<Node> ch = temp.children;
                if(ch != null) for(Node n : ch) q.add(n);
                t.add(temp.val);
            }
            ans.add(t);
        }
        return ans;
    }
}