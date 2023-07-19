class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> r = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        curr.add(0);
        backtrack(r , curr , graph , 0);
        return r;
    }
    public void backtrack(List<List<Integer>> r , List<Integer> curr , int[][] graph , int i){
        if(curr.size() > 0 && curr.get(curr.size() - 1) == graph.length - 1){
            r.add(new ArrayList<>(curr));
            return;
        }
        for(int k = 0 ; k < graph[i].length ; k++){
            curr.add(graph[i][k]);
            backtrack(r , curr , graph , graph[i][k]);
            curr.remove(curr.size() - 1);
        }
    }
}