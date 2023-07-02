class Solution {
    public int firstMissingPositive(int[] nums) {
        for(int i = 0; i < nums.length ; i++){
            int x = nums[i] - 1;
            if(x < 0 || x >= nums.length ) continue;
            if(nums[x] != nums[i]){
                int temp = nums[i];
                nums[i] = nums[x];
                nums[x] = temp;
                i--;     
            }
        }
        int num = 1;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] == num) num++;
        }
        return num;
        
    }
}