class Solution {
    HashMap<Integer , Integer> memo = new HashMap<Integer , Integer>();
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        return Math.max(dp(nums.length - 1 , nums) , dp(nums.length - 2 , nums)) ;
    }
    public int dp(int i , int[] nums){
        if(i == 0 || i == 1){
            memo.put(i , nums[i]);
            return nums[i];
        }
        else if(i == 2){
            memo.put(2 , nums[0] + nums[2]);
            return memo.get(2);
        }
        if(!memo.containsKey(i)) memo.put(i , nums[i] + Math.max(dp(i - 2 , nums) , dp(i - 3 , nums)));
        return memo.get(i);
    }
}