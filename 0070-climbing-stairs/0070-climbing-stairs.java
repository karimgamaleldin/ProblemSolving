class Solution {
    // Memoization
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        return dp(n , memo);
    }
    public int dp(int n , int[] memo){
        if(n <= 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        if(memo[n] != 0) return memo[n];
        int x = dp(n-1 , memo) + dp(n-2 , memo);
        memo[n] = x;
        return x;
    }
}