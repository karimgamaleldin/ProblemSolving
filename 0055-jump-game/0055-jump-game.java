class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length - 1;
        int goal = n;
        int i = n - 1;
        while(i >= 0){
            if(nums[i] + i >= goal) {
                goal = i;
            }
            i--;
        }
        return goal == 0;
    }
}