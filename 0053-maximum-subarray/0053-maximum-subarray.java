class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int curr = 0;
        for(int num : nums){
            curr = Math.max(num , num + curr);
            max = Math.max(max , curr);
        }
        return max;
    }
}