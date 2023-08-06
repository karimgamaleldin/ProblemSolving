class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while(left < right){
            int mid = left + (right - left) / 2;
            // System.out.println(left + "-" + right + "\n" + nums[mid]);
            if(nums[mid] >= nums[left]){
                if(nums[mid] > nums[right]){
                    left = mid + 1;
                }else{
                    right = mid;
                }
            }else{
                if(nums[mid] < nums[left]){
                    right = mid;
                }else{
                    left = mid + 1;
                }     
            }
            // System.out.println(left + "-" + right + "\n" + nums[mid]);
        }
        return nums[left];
    }
}