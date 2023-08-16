class Solution {
    // Tabulation
    public int minCostClimbingStairs(int[] cost){
        int n = cost.length;
        int[] tab = new int[n];
        tab[n - 1] = cost[n - 1];
        tab[n - 2] = cost[n - 2];
        for(int i = n - 3 ; i >= 0 ; i--){
            tab[i] = cost[i] + Math.min(tab[i + 1] , tab[i + 2]);
        }
        return Math.min(tab[0] , tab[1]);
    }
//     Top down
    // public int minCostClimbingStairs(int[] cost) {
    //     int n = cost.length;
    //     int[] memo = new int[n];
    //     dp(0 , cost , memo);
    //     return Math.min(memo[0] , memo[1]);
    // }
    // public int dp(int n , int[] cost , int[] memo){
    //     if(n >= cost.length) return 0;
    //     if(memo[n] != 0) return memo[n];
    //     int c = cost[n] + Math.min(dp(n + 1 , cost , memo) , dp(n + 2 , cost , memo));
    //     memo[n] = c;
    //     return c;
    // }
}