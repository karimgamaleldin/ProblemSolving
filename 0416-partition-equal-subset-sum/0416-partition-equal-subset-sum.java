class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int total = 0;
        for(int nu : nums) total += nu;
        if(total % 2 != 0) return false;
        boolean[][] dp = new boolean[n + 1][total / 2 + 1];
        Arrays.fill(dp[0], false);
        for(int i = 0; i <= n; i++) dp[i][0] = true;
        for(int i = 1; i <= n; i++){
            int x = nums[i - 1];
            for(int j = 1; j < total / 2 + 1; j++){
                if(j - x >= 0){
                    dp[i][j] = dp[i - 1][j - x] || dp[i - 1][j]; 
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][total / 2];
    }
}