class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        HashMap<Integer , List<Integer>> map = new HashMap<>();
        for(int[] edge : edges){
            if(!map.containsKey(edge[0])) map.put(edge[0] , new ArrayList<>());
            map.get(edge[0]).add(edge[1]);
            if(!map.containsKey(edge[1])) map.put(edge[1] , new ArrayList<>());
            map.get(edge[1]).add(edge[0]);
        }
        return dfs(map , source , destination , new HashSet<>());
    }
    
    public boolean dfs(HashMap<Integer , List<Integer>> map , int source , int destination , HashSet<Integer> seen){
        if(source == destination) return true;
        boolean f = false;
        List<Integer> m = map.get(source);
        for(Integer i : m){
            if(f) break;
            if(!seen.contains(i)){
                seen.add(i);
                f = dfs(map , i , destination , seen);
            }
        }
        return f;
    }
}