class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[n - 1] = 0;
        for(int i = n - 2; i >= 0 ; i--){
            int min = Integer.MAX_VALUE;
            int x = i + nums[i];
            if(nums[i] == 0){
                dp[i] = Integer.MAX_VALUE;
                continue;
            }
            for(int j = i + 1; j < n && j <= x; j++){
                min = Math.min(min, dp[j]);
            }
            if(min == Integer.MAX_VALUE){
                dp[i] = min;
            }
            else dp[i] = min + 1;
        }
        return dp[0];
    }
}