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
        List<List<Integer>> sol = new ArrayList<>();
        if(root == null) return sol;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> l = new ArrayList<>();
            for(int i = 0 ; i < size ; i++){
                Node x = q.remove();
                l.add(x.val);
                List<Node> arr = x.children;
                for(Node n : arr){
                    q.add(n);
                }
            }
            sol.add(l);
        }
        return sol;
    }
    
}