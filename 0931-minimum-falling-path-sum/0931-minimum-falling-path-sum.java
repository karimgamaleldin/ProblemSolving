class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[] dp = new int[n];
        int[] dp2 = new int[n];
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < n ; i++){
            dp[i] = matrix[n-1][i];
            min = Math.min(dp[i] , min);
            
        }
        for(int i = n - 2; i >= 0 ; i--){
            dp2[0] = Math.min(dp[0] , dp[1]) + matrix[i][0];
            min = dp2[0];
            for(int j = 1 ; j < n - 1 ; j++){
                dp2[j] = Math.min(dp[j] , Math.min(dp[j - 1] , dp[j + 1])) + matrix[i][j];
                min = Math.min(min , dp2[j]);
            }
            dp2[n - 1] = Math.min(dp[n - 1] , dp[n - 2]) + matrix[i][n-1];
            min = Math.min(min , dp2[n - 1]);
            dp = dp2.clone();
        }
        return min;
    }
}