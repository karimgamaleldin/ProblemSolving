class Solution {
    int[][][] memo;
    int[] prices;
    public int maxProfit(int k, int[] prices) {
        this.prices = prices;
        this.memo = new int[prices.length + 1][k + 1][2];
        for(int[][] me: memo) for(int[] m : me) Arrays.fill(m , -1);
        return dp(0 , 0 , k);
    }
    public int dp(int i , int hold , int k){
        if(k == 0 || i == prices.length) return 0;
        if(memo[i][k][hold] != -1) return memo[i][k][hold];
        int r = 0;
        if(hold == 1){
            int sell = dp(i + 1 , 0 , k - 1) + prices[i];
            int keep = dp(i + 1 , 1 , k);
            r = Math.max(sell , keep);
        }else{
            int buy = dp(i + 1 , 1 , k) - prices[i];
            int keep = dp(i + 1 , 0 , k);
            r = Math.max(buy , keep);
        }
        memo[i][k][hold] = r;
        return r;
    }
}