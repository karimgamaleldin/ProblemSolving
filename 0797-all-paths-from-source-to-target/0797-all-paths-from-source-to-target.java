class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> sol = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        list.add(0);
        backtrack(sol, graph, list ,0);
        return sol;
    }
    public void backtrack(List<List<Integer>> sol, int[][] graph, LinkedList<Integer> list, int curr){
        if(curr == graph.length - 1){
            sol.add(new LinkedList<>(list));
            return;
        }
        int[] g = graph[curr];
        for(int i : g){
            list.add(i);
            backtrack(sol, graph, list, i);
            list.remove(list.size() - 1);
        }
    }
}