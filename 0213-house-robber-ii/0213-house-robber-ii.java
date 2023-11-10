class Solution {
    public int rob(int[] nums) {
        // start from the 0 to n - 2 and from 1 to n - 1
        int n = nums.length;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0] , nums[1]);
        int one = Math.max(nums[0], nums[1]);
        int two = nums[0];
        for(int i = 2 ; i < n - 1 ; i++){
            int temp = one;
            one = Math.max(one , two + nums[i]);
            two = temp;
        }
        int one2 = Math.max(nums[1], nums[2]);
        int two2 = nums[1];
        for(int i = 3; i < n ; i++){
            int temp = one2;
            one2 = Math.max(one2, two2 + nums[i]);
            two2 = temp;
        }
        return Math.max(one2, one);
    }
}