class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;
        while(i >= 0 && nums[i] >= nums[i + 1]) i--;
        if(i != -1){
            // get smallest bigger number
            int j = i + 1;
            int index = i + 1;
            for(; j < nums.length; j++){
                if(nums[j] > nums[i] && nums[j] <= nums[index]) index = j;
            }
            int temp = nums[i];
            nums[i] = nums[index];
            nums[index] = temp;
            reverse(nums, i + 1, n - 1);
        }
        else{
            reverse(nums, 0, n - 1);
        }
    }
    public void reverse(int[] nums, int i, int j){
        while(i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}