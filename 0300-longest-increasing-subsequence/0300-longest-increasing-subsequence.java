class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int max = 0;
        for(int i = 0; i < n; i++){
            int x = 0;
            for(int j = i; j >= 0; j--){
                if(nums[i] > nums[j]) x = Math.max(x, dp[j]);
            }
            dp[i] = ++x;
            max = Math.max(x, max);
        }
        return max;
    }
}