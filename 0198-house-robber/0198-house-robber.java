class Solution {
    // Top down implementation
    private HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();
    private int[] nums;
    public int rob(int[] nums) {
        int n = nums.length;
        this.nums = nums;
        if(n == 1) return dp(n-1);
        return dp(n - 1); // As we can stop in the before last house
    }
    public int dp(int n){
        if(n == 0) return nums[0];
        if(n == 1) return Math.max(nums[1] , nums[0]);
        if(memo.containsKey(n)) return memo.get(n);
        int x = Math.max(dp(n-2) +  nums[n] , dp(n-1));
        memo.put(n , x);
        return x;
    }
}