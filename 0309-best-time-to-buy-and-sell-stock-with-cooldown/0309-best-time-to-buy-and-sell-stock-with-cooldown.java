class Solution {
    int[][] memo;
    int[] prices;
    public int maxProfit(int[] prices) {
        this.memo = new int[prices.length][3]; // three states : sell , cooldown , buy
        for(int[] m : memo) Arrays.fill(m , -1);
        this.prices = prices;
        return dp(0 , 0);
    }
    public int dp(int i , int state){
        if(i == prices.length) return 0;
        if(memo[i][state] != -1) return memo[i][state];
        int r = 0;
        if(state == 0){
            int buy = dp(i + 1 , 1) - prices[i];
            int rem = dp(i + 1 , 0);
            r = Math.max(buy , rem);
        }else if(state == 1){
            int sell = dp(i + 1 , 2) + prices[i];
            int keep = dp(i + 1 , 1);
            r = Math.max(sell , keep);
        }else{
            r = dp(i + 1 , 0);
        }
        memo[i][state] = r;
        return r;
    }
}