class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        else if(n == 2) return Math.max(nums[0] , nums[1]);
        int two = nums[0];
        int one = Math.max(nums[0] , nums[1]);
        for(int i = 2 ; i < n - 1 ; i++){
            int temp = one;
            one = Math.max(one , two + nums[i]);
            two = temp;
        }
        int two2 = nums[1];
        int one2 = Math.max(nums[1] , nums[2]);
        for(int i = 3 ; i < n ; i++){
            int temp = one2;
            one2 = Math.max(one2 , two2 + nums[i]);
            two2 = temp;
        }
        return Math.max(Math.max(one , two) , Math.max(one2 , two2));
    }
}