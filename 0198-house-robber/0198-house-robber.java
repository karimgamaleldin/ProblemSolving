class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        else if (nums.length == 1) return nums[0];
        int n = nums.length;
        int o = nums[0];
        int t = Math.max(nums[0], nums[1]);
        for(int i = 2 ; i < n ; i++){
            int temp = t;
            t = Math.max(o + nums[i] , t);
            o = temp;
        }
        return Math.max(o,t);
    }
}