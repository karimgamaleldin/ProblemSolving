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
        while(num <= nums.length && nums[num - 1] == num) num++;
        return num;
        
    }
}