class Solution {
    boolean cycle = false;
    public int largestPathValue(String colors, int[][] edges) {
        Map<Integer , List<Integer>> map = new HashMap<>();
        char[] nc = new char[colors.length()];
        for(int i = 0 ; i < nc.length ; i++) nc[i] = colors.charAt(i);
        for(int[] edg : edges){
            if(!map.containsKey(edg[0])) map.put(edg[0] , new LinkedList<>());
            map.get(edg[0]).add(edg[1]);
        }
        int[][] memo = new int[colors.length()][];
        for(int k : map.keySet()){
            dfs(k , new HashSet<Integer>() , map , nc , memo);
        }
        int sol = 1;
        for(int[] x : memo){
            if(x == null) continue;
            for(int num : x){
                sol = Math.max(sol , num);
            }
        }
        return cycle ? -1 : sol;
    }
    public int[] dfs(int num , HashSet<Integer> seen , Map<Integer , List<Integer>> map , char[] nc , int[][] memo){
        int[] alph = new int[26];
        if(seen.contains(num)){
            cycle = true;
            return alph;
        }
        if(memo[num] != null) return memo[num];
        List<Integer> edges = map.get(num);
        if(edges == null){
            alph[nc[num] - 'a']++;
            memo[num] = alph;
            return alph;
        }
        int n = edges.size();
        seen.add(num);
        for(int i = 0 ; i < n ; i++){
            int x = edges.get(i);
            int[] arr = dfs(x , seen , map , nc , memo);
            for(int j = 0 ; j < 26 ; j++){
                int t = j == (nc[num] - 'a') ? 1 : 0 ;
                alph[j] = Math.max(alph[j] , arr[j] + t);
            }
        }
        seen.remove(num);
        memo[num] = alph;
        return alph;
    }
}