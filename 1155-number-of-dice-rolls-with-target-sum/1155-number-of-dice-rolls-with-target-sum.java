class Solution {
    final int MOD = 1000000007;
    
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n + 1][target + 1];
        dp[n][target] = 1;
        
        for (int diceIndex = n - 1; diceIndex >= 0; diceIndex--) {
            for (int currSum = 0; currSum <= target; currSum++) {
               int ways = 0;
               for (int i = 1; i <= Math.min(k, target - currSum); i++) {
                    ways = (ways + dp[diceIndex + 1][currSum + i]) % MOD;
                }
                
                dp[diceIndex][currSum] = ways;
            }
        }
        return dp[0][0];
    }
}