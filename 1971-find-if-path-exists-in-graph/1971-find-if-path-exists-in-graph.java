class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(i, new ArrayList<>());
        }
        
        for(int[] e: edges){
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }
        HashSet<Integer> seen = new HashSet<>();
        seen.add(source);
        dfs(map, seen, source);
        return seen.contains(destination);
    }
    
    public void dfs(HashMap<Integer, ArrayList<Integer>> map,HashSet<Integer> seen, int curr){
        ArrayList<Integer> arr = map.get(curr);
        for(int x: arr){
            if(seen.contains(x)) continue;
            seen.add(x);
            dfs(map, seen, x);
        }
    }
}