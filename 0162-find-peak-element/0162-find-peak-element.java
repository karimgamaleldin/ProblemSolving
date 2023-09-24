class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        if(nums.length == 1) return 0;
        if(nums[0] > nums[1]) return 0;
        else if(nums[r] > nums[r - 1]) return r;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) return mid;
            else if(nums[mid + 1] > nums[mid]){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return -1;
    }
}