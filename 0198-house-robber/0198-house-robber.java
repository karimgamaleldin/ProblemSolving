class Solution {
    public int rob(int[] nums){
        int n = nums.length;
        if(n == 1) return nums[0];
        int two = nums[0];
        int one = Math.max(nums[0] , nums[1]);
        for(int i = 2 ; i < n ; i++){
            int temp = one;
            one = Math.max(two + nums[i] , one);
            two = temp;
        }
        return Math.max(one , two);
    }
    // // Top down implementation
    // private HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();
    // private int[] nums;
    // public int rob(int[] nums) {
    //     int n = nums.length;
    //     this.nums = nums;
    //     if(n == 1) return dp(n-1);
    //     return dp(n - 1); // As we can stop in the before last house
    // }
    // public int dp(int n){
    //     if(n == 0) return nums[0];
    //     if(n == 1) return Math.max(nums[1] , nums[0]);
    //     if(memo.containsKey(n)) return memo.get(n);
    //     int x = Math.max(dp(n-2) +  nums[n] , dp(n-1));
    //     memo.put(n , x);
    //     return x;
    // }
}