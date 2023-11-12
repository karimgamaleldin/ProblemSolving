class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][k + 1][2];
        for(int i = n - 1; i >= 0; i--){
            for(int j = k; j >= 1 ; j--){
                dp[i][j][1] = Math.max(dp[i + 1][j - 1][0] + prices[i], dp[i+1][j][1]);
                dp[i][j][0] = Math.max(dp[i+1][j][1] - prices[i], dp[i+1][j][0]);
                // System.out.println(dp[i][j][1]);
                // System.out.println(dp[i][j][0]);
            }
        }
        return dp[0][k][0];
    }
}