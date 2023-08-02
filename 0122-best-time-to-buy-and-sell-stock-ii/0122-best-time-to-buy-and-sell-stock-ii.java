class Solution {
    int[][] memo;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        this.memo = new int[n][2];
        for(int i = 0 ; i < n ; i++) Arrays.fill(memo[i] , Integer.MIN_VALUE);
        return dp(0 , prices , 0);
    }
    public int dp(int i , int[] prices , int state){
        if(i == prices.length) return 0;
        if(memo[i][state] != Integer.MIN_VALUE) return memo[i][state];
        int res = 0;
        if(state == 0){
            res = Math.max(dp(i+1,prices,1) - prices[i] , dp(i+1,prices,0));
        }else{
            res = Math.max(dp(i+1,prices,0) + prices[i] , dp(i+1,prices,1));
        }
        memo[i][state] = res;
        return res;
    }
}