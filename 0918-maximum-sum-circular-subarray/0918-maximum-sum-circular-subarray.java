class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int best = nums[0];
        int worst = nums[0];
        int currentMax = 0;
        int currentMin = 0;
        int total = 0;
        for(int i = 0 ; i < nums.length ; i++){
            currentMax = Math.max(currentMax + nums[i] , nums[i]);
            best = Math.max(currentMax , best);
            total += nums[i];
            currentMin = Math.min(currentMin+nums[i], nums[i]);
            worst = Math.min(currentMin , worst);
        }
    
        return best > 0 ? Math.max(best, total - worst) : best;
    }
}