class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        int n = nums.length;
        int m = multipliers.length;
        int[][] dp = new int[m + 1][m + 1];
        for(int i = m - 1; i >= 0 ; i--){ // loop from the last element on multipliers
            for(int j = i; j >=0 ; j--){
                int left = j;
                int right = n - 1 - (i - j);
                int start = multipliers[i] * nums[left] + dp[i + 1][left + 1]; // we get the previous iteration with left + 1
                int end = multipliers[i] * nums[right] + dp[i + 1][left];
                dp[i][j] = Math.max(start, end);
            }
        }
        return dp[0][0];
    }
}