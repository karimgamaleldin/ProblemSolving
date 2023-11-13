class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for(int[] d : dp) Arrays.fill(d, Integer.MAX_VALUE);
        dp[m - 1][n] = 0;
        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j>=0 ; j--){
                dp[i][j] = grid[i][j] +  Math.min(dp[i + 1][j], dp[i][j + 1]);
            }
        }
        return dp[0][0];
    }
}