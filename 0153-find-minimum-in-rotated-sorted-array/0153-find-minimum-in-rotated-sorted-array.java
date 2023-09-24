class Solution {
    public int findMin(int[] nums) {
        int r = nums.length - 1;
        if(r == 0) return nums[0];
        if(nums[0] < nums[1] && nums[0] < nums[r]) return nums[0];
        if(nums[r] < nums[r - 1] && nums[r] < nums[0]) return nums[r];
        int l = 0;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(nums[mid] < nums[mid + 1] && nums[mid] < nums[mid - 1]) return nums[mid];
            if(nums[mid] > nums[r]){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return -1;
    }
}