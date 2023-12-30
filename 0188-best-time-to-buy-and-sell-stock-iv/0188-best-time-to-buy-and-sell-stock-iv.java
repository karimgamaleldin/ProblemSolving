class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][][] memo = new int[prices.length][k + 1][2];
        for(int[][] me : memo)
            for(int[] m : me)
                Arrays.fill(m, -1);
        return dp(memo, prices, k, 0, 0);
    }
    
    public int dp(int[][][] memo, int[] prices, int k, int i, int j){
        if(i >= prices.length || (k == 0 && j == 0)) return 0;
        if(memo[i][k][j] != -1) return memo[i][k][j];
        if(j == 0){
            int take = dp(memo, prices, k - 1, i + 1, 1) - prices[i];
            int leave = dp(memo, prices, k, i + 1, 0);
            memo[i][k][j] = Math.max(take, leave);
        }else{
            int sell = dp(memo, prices, k, i + 1, 0) + prices[i];
            int hold = dp(memo, prices, k, i + 1, 1);
            memo[i][k][j] = Math.max(sell, hold);
        }
        return memo[i][k][j];
    }
}