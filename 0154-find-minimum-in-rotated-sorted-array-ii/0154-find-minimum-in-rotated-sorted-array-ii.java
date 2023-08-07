class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while(l < r){
            int mid = l + (r - l) / 2;
            if(nums[mid] == nums[l] && nums[l] == nums[r]){
                l++;
                r--;
            }
            else if(nums[mid] <= nums[r])
                r = mid;
            else
                l = mid + 1;
        }
        return nums[l];
    }
}