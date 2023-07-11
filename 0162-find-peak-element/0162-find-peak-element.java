class Solution {
    public int findPeakElement(int[] nums) {
        int left = 1;
        int right = nums.length - 2;
        if(nums.length == 1 || nums[0] > nums[1]) return 0;
        if(nums[right] < nums[nums.length - 1]) return nums.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) return mid;
            else if(nums[mid - 1] > nums[mid]) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }
}