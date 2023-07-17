class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int size = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;
        int right = 0;
        while(right < nums.length){
            sum += nums[right];
            while(left <= right && sum >= target){
                size = Math.min(right - left + 1 , size);
                sum -= nums[left++];
            }
            right++;
        }
        if(size == Integer.MAX_VALUE) return 0;
        return size;
    }
}