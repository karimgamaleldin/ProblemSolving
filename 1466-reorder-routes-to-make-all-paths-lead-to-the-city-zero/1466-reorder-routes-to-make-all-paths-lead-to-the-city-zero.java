class Solution {
    HashMap<Integer , ArrayList<Integer>> map = new HashMap<>();
    HashSet<String> roads = new HashSet<>();
    boolean [] seen;
    public int minReorder(int n, int[][] connections) {
        seen = new boolean[n];
        for(int i = 0 ; i <  n ; i++){
            map.put(i , new ArrayList<>());
        }
        for(int i = 0 ; i < connections.length ; i++){
            int a = connections[i][0];
            int b = connections[i][1];
            map.get(a).add(b);
            map.get(b).add(a);
            roads.add(a + "," + b);
        }
        seen[0] = true;
        int ans = dfs(0);
        return ans;
    }
    public int dfs(int n){
        int ans = 0;
        ArrayList<Integer> arr = map.get(n);
        for(int i = 0 ; i < arr.size() ; i++){
            int x = arr.get(i);
            if(!seen[x]){
                if(roads.contains(n + "," + x)) ans++;
                seen[x] = true;
                ans += dfs(x);
            }
        }
        return ans;
    }
}