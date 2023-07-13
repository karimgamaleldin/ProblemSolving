class Solution {
    HashMap<Integer , List<Integer>> map = new HashMap<>();
    boolean[] seen;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        seen = new boolean[n];
        for(int i = 0 ; i < n ; i++) map.put(i , new ArrayList<>());
        for(int i = 0 ; i < edges.length ; i++){
            int a = edges[i][0];
            int b = edges[i][1];
            map.get(a).add(b);
            map.get(b).add(a);
        }
        seen[source] = true;
        dfs(source);
        return seen[destination];
    }
    public void dfs(int n){
        List<Integer> arr= map.get(n);
        for(int i = 0 ; i < arr.size() ; i++){
            int a = arr.get(i);
            if(!seen[a]){
                seen[a] = true;
                dfs(a);
            }
        } 
    }
}