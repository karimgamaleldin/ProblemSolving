class Solution {
    HashMap<Integer , Integer> memo = new HashMap<>();
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        else if(nums.length == 2) return Math.max(nums[0] , nums[1]);
        return Math.max(dp(nums , nums.length - 1) , dp(nums , nums.length - 2));
    }
    public int dp(int[] nums , int x){
        if(x ==0 || x == 1){
            memo.put(x , nums[x]);
            return nums[x];
        }
        if(x == 2){
            memo.put(2 , nums[2] + nums[0]);
            return memo.get(2);
        }
        if(memo.containsKey(x)){
            return memo.get(x);
        }
        int a = dp(nums , x - 2);
        int b = dp(nums , x - 3);
        int y = Math.max(a,b) + nums[x];
        memo.put(x , y);
        return y;
    }
}