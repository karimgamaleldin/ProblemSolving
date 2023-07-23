class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n]; // store the max length
        int[] dp2 = new int[n]; // stores number of time this length happen
        for(int i = 0 ; i < n ; i++){
            dp[i] = 1;
            dp2[i] = 1;
            for(int j = 0 ; j < i ; j++){
                if(nums[i] > nums[j]){
                    int t = dp[j] + 1;
                    if(dp[i] == t){
                        dp2[i] += dp2[j];
                    }
                    else if(dp[i] < t){
                        dp2[i] = dp2[j];
                        dp[i] = t;
                    } 
                }
            }
        }
        int max = dp[0];
        int count = dp2[0];
        for(int i = 1 ; i < n ; i++){
            if(max < dp[i]){
                max  = dp[i];
                count = dp2[i];
            }else if (max == dp[i]){
                count += dp2[i];
            }
        }
        return count;
    }
}