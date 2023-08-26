class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>(); // graph is acyclic we don't need a seen
        curr.add(0);
        bt(res , curr , graph , 0);
        return res;
    }
    public void bt(List<List<Integer>> res , List<Integer> curr , int[][] graph , int i){
        if(i == graph.length - 1){
            res.add(new ArrayList<>(curr));
            return;
        }
        int[] g = graph[i];
        for(int k : g){
            curr.add(k);
            bt(res , curr , graph , k);
            curr.remove(curr.size() - 1);
        }
    }
}