class Solution {
    // base case : (n - 1) * 1
    
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for(int i = 2 ; i <= n ; i++){
            int max = 0;
            for(int j = i - 1 ; j > 0 ; j--){
                int x = i - j;
                x = Math.max(x , dp[x]);
                int y = Math.max(j , dp[j]);
                max = Math.max(max , x * y);
            }
            dp[i] = max;
        }
        return dp[n];
    }
}