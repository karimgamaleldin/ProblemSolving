class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int left = 0;
        int sum = 0;
        for(int i = 0 ; i < k ; i++) sum += nums[i];
        int max = sum;
        for(int i = k ; i < nums.length ; i++){
            sum = sum + nums[i] - nums[left++];
            max = Math.max(sum , max);
        }
        return ((double) max ) / k;
    }
}