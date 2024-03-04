class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int curr = 0;
        for(int n : nums){
            curr = Math.max(curr + n, n);
            max = Math.max(curr, max);
        }
        return max;
    }
}