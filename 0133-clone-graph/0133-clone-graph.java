/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Node root = new Node(node.val);
        HashMap<Node,Node> map = new HashMap<>();
        dfs(root , node , map);
        return root;
    }
    public void dfs(Node root , Node node , HashMap<Node,Node> map){
        List<Node> l = node.neighbors;
        List<Node> rl = root.neighbors;
        map.put(node , root);
        for(int i = 0 ; i < l.size() ; i++){
            Node temp = l.get(i);
            if(!map.containsKey(temp)){
                Node t = new Node(temp.val);
                rl.add(t);
                dfs(t,temp,map);
            }else{
                rl.add(map.get(temp));
            }
        }
    }
}