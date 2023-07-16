class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int ans = 1;
        for(int i = 0 ; i < n ; i++){   
            dp[i] = 1;
            for(int j = 0 ; j < i ; j++){
                if(nums[i] > nums[j]) dp[i] = Math.max(dp[i] , dp[j] + 1);
            }
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }
    // HashMap<Integer , Integer> memo = new HashMap<>();
    // public int lengthOfLIS(int[] nums) {
    //     int ans = 1;
    //     for(int i = 0 ; i < nums.length ; i++){
    //         ans = Math.max(ans, dp(i , nums));
    //     }
    //     return ans;
    // }
    // public int dp(int i , int[] arr){
    //     if(memo.containsKey(i)){
    //         return memo.get(i);
    //     }
    //     int ans = 1;
    //     for(int j = 0 ; j < i ; j++){
    //         if(arr[j] < arr[i])
    //             ans = Math.max(ans , dp(j , arr) + 1);
    //     }
    //     memo.put(i , ans);
    //     return ans;
    // }
}