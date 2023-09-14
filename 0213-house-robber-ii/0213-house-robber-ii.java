class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        else if(nums.length == 2) return Math.max(nums[0], nums[1]);
        int n = nums.length;
        int o = nums[0];
        int t = Math.max(nums[0] , nums[1]);
        int th = nums[1];
        int f = Math.max(nums[1], nums[2]);
        for(int i = 2 ; i < n - 1; i++){
            int temp = t;
            t = Math.max(t , o + nums[i]);
            o = temp;
            temp = f;
            f = Math.max(f, th + nums[i + 1]);
            th = temp;
        }
        return Math.max(f, t);
    }
}