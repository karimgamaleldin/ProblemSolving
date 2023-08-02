class Solution {
    int[][] memo;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        this.memo = new int[n][3];
        for(int i = 0 ; i < n ; i++) Arrays.fill(memo[i] , Integer.MIN_VALUE);
        return dp(prices , 0 , 0);
    }
    public int dp(int[] prices , int i , int state){
        if(i == prices.length) return 0;
        if(memo[i][state] != Integer.MIN_VALUE) return memo[i][state];
        int res = 0;
        if(state == 0){
            res = Math.max(dp(prices , i + 1 , 1) - prices[i] , dp(prices , i + 1 , 0));
        }else if(state == 1){
            res = Math.max(dp(prices , i + 1 , 2) + prices[i] , dp(prices , i + 1 , 1));
        }else{
            res = dp(prices , i + 1 , 0);
        }
        memo[i][state] = res;
        return res;
    }
}