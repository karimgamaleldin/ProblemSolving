class Solution {
    public int longestNiceSubarray(int[] nums) {
        int curr = nums[0];
        int l = 0;
        int max = 1;
        for(int r = 1; r < nums.length; r++){
            boolean f = (curr & nums[r]) == 0;
            while(l <= r && !f){
                curr ^= nums[l];
                f = (curr & nums[r]) == 0;
                l++;
            }
            curr = curr | nums[r];
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}