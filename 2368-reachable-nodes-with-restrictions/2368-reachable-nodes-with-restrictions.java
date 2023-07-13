class Solution {
    HashMap<Integer , List<Integer>> map = new HashMap<>();
    HashSet<Integer> set = new HashSet<Integer>(); 
    boolean[] seen;
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        seen = new boolean[n];
        for(int i = 0 ; i < restricted.length ; i++) set.add(restricted[i]);
        for(int i = 0 ; i < edges.length ; i++){
            int a = edges[i][0];
            int b = edges[i][1];
            if(!map.containsKey(a)){
                ArrayList<Integer> x = new ArrayList<>();
                map.put(a,x);
            }
            if(!map.containsKey(b)){
                ArrayList<Integer> x = new ArrayList<>();
                map.put(b,x);
            }
            map.get(a).add(b);
            map.get(b).add(a);
        }
        seen[0] = true;
        int ans = dfs(0);
        return ans;
    }
    public int dfs(int n){
        List<Integer> arr = map.get(n);
        int ans = 1;
        for(int i = 0 ; i < arr.size() ;i++){
            int a = arr.get(i);
            if(!set.contains(a) && !seen[a]){
                seen[a] = true;
                ans += dfs(a);
            }
        }
        return ans;
    }
}