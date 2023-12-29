class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] memo = new int[n][2];
        for(int[] me : memo) Arrays.fill(me, -1);
        return dp(prices, memo, 0, 0);
    }
    
    public int dp(int[] prices, int[][] memo, int i, int j){
        if(i == prices.length) return 0;
        if(memo[i][j] != -1) return memo[i][j];
        if(j == 0){
            memo[i][j] = Math.max(dp(prices, memo, i + 1, j), dp(prices, memo, i + 1, 1) - prices[i]);
        }else{
            memo[i][j] = Math.max(dp(prices, memo, i + 1, j), dp(prices, memo, i + 1, 0) + prices[i]);
        }
        return memo[i][j];
    }
}