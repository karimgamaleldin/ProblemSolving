class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int one = Math.max(nums[1], nums[0]);
        int two = nums[0];
        for(int i = 2; i < nums.length; i++){
            int temp = one;
            one = Math.max(one, two + nums[i]);
            two = temp;
            // System.out.println("one " + one);
            // System.out.println(two);
        }
        return Math.max(one, two);
    }
}