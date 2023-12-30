class Solution {
    public int maxProfit(int[] prices, int fee) {
        int[][] memo = new int[prices.length][2];
        for(int[] me : memo) Arrays.fill(me, -1);
        return dp(memo, prices, fee, 0, 0);
        
    }
    public int dp(int[][] memo, int[] prices, int fee , int index, int hold){
        if(index >= prices.length) return 0;
        if(memo[index][hold] != -1) return memo[index][hold];
        if(hold == 0){
            int take = dp(memo, prices, fee, index + 1, 1) - fee - prices[index];
            int leave = dp(memo, prices, fee, index + 1, 0);
            memo[index][hold] = Math.max(take, leave);
        }else{
            int sell = dp(memo, prices, fee, index + 1, 0) + prices[index];
            int rem = dp(memo, prices, fee, index + 1, 1);
            memo[index][hold] = Math.max(sell, rem);
        }
        return memo[index][hold];
    }
}