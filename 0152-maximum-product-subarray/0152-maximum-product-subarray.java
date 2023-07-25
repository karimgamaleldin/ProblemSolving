class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int ans = nums[0];
        int max = 1;
        int min = 1;
        for(int i = 0 ; i < nums.length ; i++){
            int x = nums[i];
            int temp = max * x;
            max = Math.max(temp , Math.max(x * min , x));
            min = Math.min(temp , Math.min(x * min , x));
            ans = Math.max(max , ans);
        }
        return ans;
    }
}