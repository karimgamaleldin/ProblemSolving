class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length - 1;
        for( ; i < nums.length && i <= j ; i++){
            if(nums[i] == val){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j--; 
                i--; // to return back to the previous index just in case what was swappeed was the val.
            }
        }
        return i;
    }
}