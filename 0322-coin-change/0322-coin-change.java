class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount  + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for(int i = 0; i <= amount ; i++){
            int min = Integer.MAX_VALUE;
            for(int c: coins){
                if(c > i) continue;
                int x = i - c;
                if(dp[x] != -1) min = Math.min(dp[x], min);
            }
            if(min != Integer.MAX_VALUE) dp[i] = min + 1;
        }
        // for(int n : dp) System.out.print(n + " ");
        return dp[amount];
    }
}