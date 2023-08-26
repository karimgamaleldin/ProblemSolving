class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer , List<int[]>> graph = new HashMap<>();
        int[] dp = new int[n];
        Arrays.fill(dp , Integer.MAX_VALUE);
        for(int i = 0 ; i < n ; i++) graph.put(i , new ArrayList<>());
        for(int[] f : flights) graph.get(f[0]).add(new int[]{f[1] , f[2]});
        // System.out.println(graph);
        dp[src] = 0;
        for(int i = 0 ; i <= k ; i++){
            int dpt[] = dp.clone();
            for(int j = 0 ; j < n ; j++){
                if(dp[j] != Integer.MAX_VALUE){
                    List<int[]> arr = graph.get(j);
                    for(int[] a : arr){
                        dpt[a[0]] = Math.min(dpt[a[0]] , dp[j] + a[1]);
                         // System.out.println(a[0] + "=" + dpt[a[0]]);
                    }
                }
            }
            dp = dpt;
        }
        return dp[dst] == Integer.MAX_VALUE ? -1 : dp[dst];
    }
}