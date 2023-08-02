class Solution {
    int[][][] memo;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        this.memo = new int[n][3][2];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < 3 ; j++){
                Arrays.fill(memo[i][j] , Integer.MIN_VALUE);
            }
        }
        return dp(0 , 2 , 0 , prices);
    }
    public int dp(int i , int rem , int state , int[] prices){
        if(i == prices.length || (rem == 0 && state == 0)) return 0;
        if(memo[i][rem][state] != Integer.MIN_VALUE) return memo[i][rem][state];
        int ans = 0;
        if(state == 0){
            ans = Math.max(dp(i+1,rem-1,1,prices) - prices[i] , dp(i+1,rem,0,prices));
        }else{
            ans = Math.max(dp(i+1,rem,0,prices) + prices[i] , dp(i+1,rem,1,prices));
        }
        memo[i][rem][state] = ans;
        return ans;
    }
}