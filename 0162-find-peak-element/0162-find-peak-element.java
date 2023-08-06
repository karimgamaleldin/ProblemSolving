class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        if(nums.length == 1 || nums[left] > nums[left + 1]) return 0;
        int right = nums.length - 1;
        if(nums[right] > nums[right - 1]) return right;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]){
                return mid;
            }
            if(nums[mid - 1] < nums[mid]){
                if(nums[left] > nums[mid - 1]){
                    right = mid;
                }else{
                    left = mid + 1;
                }
            }else{
                if(nums[right] > nums[mid + 1]){
                    left = mid + 1;
                }else{
                    right = mid;
                }
            }
        }
        return left;
    }
}