class Solution {
    public int maxProfit(int[] prices) {
        int[][] memo = new int[prices.length][2];
        for (int[] m: memo) Arrays.fill(m, -1);
        return dp(prices, 0, 0, memo);
    }
    
    public int dp(int[] prices, int i, int hold, int[][] memo){
        if(i == prices.length) return 0;
        if (memo[i][hold] != -1) return memo[i][hold];
        if (hold == 0){
            memo[i][hold] = Math.max(dp(prices, i+1, 1, memo) - prices[i], dp(prices, i+1, 0, memo));
        }else{
            memo[i][hold] = Math.max(dp(prices, i+1, 0, memo) + prices[i], dp(prices, i+1, 1, memo));
        }
        return memo[i][hold];
    }
}