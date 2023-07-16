class Solution {
    HashMap<Integer , Integer> memo = new HashMap<>();
    public int lengthOfLIS(int[] nums) {
        int ans = 1;
        for(int i = 0 ; i < nums.length ; i++){
            ans = Math.max(ans, dp(i , nums));
        }
        return ans;
    }
    public int dp(int i , int[] arr){
        if(memo.containsKey(i)){
            return memo.get(i);
        }
        int ans = 1;
        for(int j = 0 ; j < i ; j++){
            if(arr[j] < arr[i])
                ans = Math.max(ans , dp(j , arr) + 1);
        }
        memo.put(i , ans);
        return ans;
    }
}