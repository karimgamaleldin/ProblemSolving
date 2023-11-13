class Solution {
    public int maxSubArray(int[] nums) {
        int curr = 0;
        int best = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            curr = Math.max(curr + nums[i], nums[i]);
            best = Math.max(best, curr);
        }
        return best;
    }
}