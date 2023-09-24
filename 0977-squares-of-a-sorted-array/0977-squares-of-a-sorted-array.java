class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] sol = new int[nums.length];
        int i = 0;
        int j = nums.length - 1;
        int k = nums.length - 1;
        while(i <= j){
            int t = Math.abs(nums[i]) > Math.abs(nums[j]) ? nums[i++] : nums[j--];
            sol[k--] = t * t;
        }
        return sol;
    }
}