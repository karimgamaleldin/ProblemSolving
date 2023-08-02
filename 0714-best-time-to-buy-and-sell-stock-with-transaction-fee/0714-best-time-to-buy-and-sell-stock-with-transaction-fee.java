class Solution {
    int[][] memo;
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        this.memo = new int[n][2];
        for(int i = 0 ; i < n ; i++) Arrays.fill(memo[i] , Integer.MIN_VALUE);
        return dp(0 , 0 , prices , fee);
    }
    public int dp(int i , int state , int[] prices , int fee){
        if(i == prices.length) return 0;
        if(memo[i][state] != Integer.MIN_VALUE){
            return memo[i][state];
        }
        int ans = 0;
        if(state == 0){
            ans = Math.max(dp(i+1,1,prices,fee) - prices[i] - fee , dp(i+1,0,prices,fee));
        }else{
            ans = Math.max(dp(i+1,0,prices,fee) + prices[i] , dp(i+1,1,prices,fee));
        }
        memo[i][state] = ans;
        return ans;
    }
}