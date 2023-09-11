class Solution {
    public boolean canJump(int[] nums) {
        int goal = nums.length - 1;
        int i = nums.length - 1;
        while(i >= 0){
            if(nums[i] + i >= goal)
                goal = i;
            i--;
        }
        return goal == 0;
    }
}