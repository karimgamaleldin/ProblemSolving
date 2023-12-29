class Solution {
    public int rob(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return dp(memo, 0, nums);
    }
    
    public int dp(int[] memo, int i, int[] nums){
        if(nums.length <= i) return 0;
        if(memo[i] != -1){
            return memo[i];
        }
        return memo[i] = Math.max(dp(memo, i + 1, nums), dp(memo, i + 2, nums) + nums[i]);
    }
}