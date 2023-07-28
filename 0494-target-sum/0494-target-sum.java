class Solution {
    int total;
    int[][] memo;
    int target;
    int[] arr;
    int n;
    public int findTargetSumWays(int[] nums, int target) {
        total = Arrays.stream(nums).sum();
        this.n = nums.length;
        arr = nums;
        this.target = target;
        memo = new int[n][2 * total + 1];
        for(int[] x : memo) Arrays.fill(x , Integer.MIN_VALUE);
        return dp(0 , 0);
    }
    public int dp(int i , int sum){
        if(i == n){
            if(sum == target) return 1;
            return 0;
        }
        if(memo[i][sum + total] != Integer.MIN_VALUE){
            return memo[i][sum+total];
        }
        memo[i][sum + total] = dp(i+1 , sum + arr[i]) + dp(i+1 , sum - arr[i]);
        return memo[i][sum + total];
    }
}